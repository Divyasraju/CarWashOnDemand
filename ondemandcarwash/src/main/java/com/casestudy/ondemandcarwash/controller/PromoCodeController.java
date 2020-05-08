package com.casestudy.ondemandcarwash.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.PromoCode;
import com.casestudy.ondemandcarwash.operation.PromoCodeOperation;

@RestController
@RequestMapping("/api/promo")
public class PromoCodeController {
	
	@Autowired
	private PromoCodeOperation promoCodeOperation;

	@PostMapping("/insertpromo")
	public ResponseEntity<?> insertNewPromoCode(@RequestBody PromoCode promoCode) {
		promoCodeOperation.insertNewPromoCode(promoCode);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PromoCode> updateExistingPromoCode(@PathVariable(value = "id") int id,
	  @Valid @RequestBody PromoCode promoCodeDetails) throws Exception {
		return promoCodeOperation.updateExistingPromoCode(id,promoCodeDetails);
	}
}
