package kodlamaio.hrms.business.concrates;


import jakarta.transaction.Transactional;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

import kodlamaio.hrms.entities.concrates.Candidate;

import kodlamaio.hrms.entities.dto.CandidateLoginRequest;
import kodlamaio.hrms.entities.dto.CandidateRegisterRequest;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Service


public class CandidateManager implements CandidateService {
	

	private Cloudinary cloudinary;
	private CandidateDao candidateDao;
	
	@Autowired
	
	public CandidateManager(CandidateDao candidateDao,Cloudinary cloudinary) {
		super();
		this.candidateDao = candidateDao;
		this.cloudinary = cloudinary;
	}
	


	@Override
	public Result candidateregister(CandidateRegisterRequest candidateRegisterRequest) {
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateRegisterRequest.getFirstname());
		candidate.setLastName(candidateRegisterRequest.getLastname());
		candidate.setPassword(candidateRegisterRequest.getPassword());
		candidate.setEmail(candidateRegisterRequest.getEmail());
		candidate.setTckimlik_no(candidateRegisterRequest.getTckimlik_no());
		this.candidateDao.save(candidate);
		return new SuccessResult("Başarılı Kayıt Oldunuz.");
		
	}



	@Override
	public DataResult<Candidate> candidateLogin(CandidateLoginRequest candidateLoginRequest) {
		 if (candidateLoginRequest.getEmail() == null || candidateLoginRequest.getPassword() == null) {
	            return new ErrorDataResult<>("Email ve şifre zorunludur!");
	        }
		 Candidate candidate = candidateDao.findByEmail(candidateLoginRequest.getEmail());
	        if (candidate == null) {
	            return new ErrorDataResult<>("Kullanıcı bulunamadı!");
	        }
	        if (!candidate.getPassword().equals(candidateLoginRequest.getPassword())) {
	            return new ErrorDataResult<>("Şifre hatalı!");
	        }
	        return new  SuccessDataResult<>(candidate, "Başarılı giriş yapıldı");
	      
	
	}

	@Override
	public Result uploadImage(int candidateId, MultipartFile file) {
		try {
			// Candidate kontrolü
			Optional<Candidate> candidate = candidateDao.findById(candidateId);
			if (candidate.isEmpty()) {
				return new ErrorResult("Kullanıcı bulunamadı");
			}

			// Dosya kontrolü
			if (file == null || file.isEmpty()) {
				return new ErrorResult("Lütfen bir resim seçiniz");
			}

			// Dosya türü kontrolü
			if (!file.getContentType().startsWith("image/")) {
				return new ErrorResult("Lütfen sadece resim dosyası yükleyiniz");
			}

			// Cloudinary'ye yükleme
			Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(),
					ObjectUtils.asMap(
							"folder", "profiles",
							"allowed_formats", Arrays.asList("jpg", "jpeg", "png"),
							"transformation", new Transformation().width(400).height(400).crop("fill")
					));

			// URL'i kaydetme
			String imageUrl = (String) uploadResult.get("secure_url");
			Candidate updatedCandidate = candidate.get();
			updatedCandidate.setImgUrl(imageUrl);
			candidateDao.save(updatedCandidate);

			return new SuccessResult("Profil resmi başarıyla yüklendi");

		} catch (IOException e) {
			return new ErrorResult("Resim yükleme sırasında bir hata oluştu: " + e.getMessage());
		}


	}

	@Override
	public Result deleteImage(int candidateId) {
		try {
			Optional<Candidate> candidate = candidateDao.findById(candidateId);
			if(candidate.isEmpty()){
				return new ErrorResult("Kullanıcı bulunamadı");
			}
			Candidate updatedCandidate = candidate.get();
			updatedCandidate.setImgUrl("https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg");
			candidateDao.save(updatedCandidate);



			return new SuccessResult("Profil resmi başarı ile silindi");
		} catch (Exception e) {
		return new ErrorResult("Bir hata ile karşılaşıldı: " + e.getMessage());
		}






	}


}

