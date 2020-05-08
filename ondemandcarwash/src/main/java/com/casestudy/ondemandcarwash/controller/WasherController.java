package com.casestudy.ondemandcarwash.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.CarWasher;
import com.casestudy.ondemandcarwash.model.RatingsAndReviews;
import com.casestudy.ondemandcarwash.operation.WasherOperation;
import com.casestudy.ondemandcarwash.repository.WasherRepository;
import com.casestudy.ondemandcarwash.util.ExcelGenerator;

@RestController
@RequestMapping("/api/washer")
public class WasherController {

	@Autowired
	private WasherOperation washerOperation;
	
	@Autowired
	private WasherRepository washerRepository;

	@PostMapping("/addwasher")
	public ResponseEntity<?> insertNewCarWasherDetails(@RequestBody CarWasher carWasher) {
		washerOperation.insertNewCarWasherDetails(carWasher);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarWasher> UpdateCarWasherDetails(@PathVariable(value = "id") int id,
			@Valid @RequestBody CarWasher carWasher) throws Exception {
		return washerOperation.UpdateCarWasherDetails(id, carWasher);
	}

	@GetMapping("/viewRatings/{washerId}")
	public List<RatingsAndReviews> getAllRatingsForCarWasher(@PathVariable String washerId) {

		return washerOperation.getAllRatingsForCarWasher(washerId);

	}
	
	@GetMapping(value = "/download/carWashers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<CarWasher> carWasher = (List<CarWasher>) washerRepository.findAll();
    
    ByteArrayInputStream in = ExcelGenerator.CarWashersToExcel(carWasher);
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=carWasher.xlsx");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }
}
