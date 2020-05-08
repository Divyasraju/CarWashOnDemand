package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.CarWasher;
import com.casestudy.ondemandcarwash.model.RatingsAndReviews;
import com.casestudy.ondemandcarwash.repository.RatingsAndReviewsRepository;
import com.casestudy.ondemandcarwash.repository.WasherRepository;

@Component
public class WasherOperation {

	@Autowired
	private WasherRepository washerRepository;

	@Autowired
	private RatingsAndReviewsRepository ratingsAndReviewsRepository;

	public void insertNewCarWasherDetails(CarWasher carWasher) {
		washerRepository.save(carWasher);

	}

	public ResponseEntity<CarWasher> UpdateCarWasherDetails(int id, @Valid CarWasher carWasher) {
		CarWasher carWasherDetail = washerRepository.findById(id);
		if (carWasherDetail != null) {
			carWasherDetail.setId(carWasher.getId());
			carWasherDetail.setMailId(carWasher.getMailId());
			carWasherDetail.setWasherId(carWasher.getWasherId());
			carWasherDetail.setWasherName(carWasher.getWasherName());
			carWasherDetail.setWasherNo(carWasher.getWasherNo());
			carWasherDetail.setOrders(carWasher.getOrders());
			return new ResponseEntity<>(washerRepository.save(carWasherDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

	public List<RatingsAndReviews> getAllRatingsForCarWasher(String washerId) {
	List<RatingsAndReviews> ratingsAndReviews = new ArrayList<>();
				ratingsAndReviews = ratingsAndReviewsRepository.findBywasherId(washerId);
				return ratingsAndReviews;

	}
}
