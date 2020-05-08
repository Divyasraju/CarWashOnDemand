package com.casestudy.ondemandcarwash.operation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.PromoCode;
import com.casestudy.ondemandcarwash.repository.PromoCodeRepository;

@Component
public class PromoCodeOperation {

	@Autowired
	private PromoCodeRepository promoCodeRepository;

	public void insertNewPromoCode(PromoCode promoCode) {
		promoCodeRepository.save(promoCode);
	}

	public ResponseEntity<PromoCode> updateExistingPromoCode(int id, @Valid PromoCode promoCodeDetails) {
		PromoCode promoCodeDetail = promoCodeRepository.findById(id);
		if (promoCodeDetail != null) {
			promoCodeDetail.setPromoCode(promoCodeDetails.getPromoCode());
			return new ResponseEntity<>(promoCodeRepository.save(promoCodeDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

}
