package wellfernandes.com.github.parkingcontrolapi.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wellfernandes.com.github.parkingcontrolapi.dtos.ParkingSpotDto;
import wellfernandes.com.github.parkingcontrolapi.model.ParkingSpotModel;
import wellfernandes.com.github.parkingcontrolapi.service.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	final ParkingSpotService parkingSportService;

	public ParkingSpotController(ParkingSpotService parkingSportService) {
		this.parkingSportService = parkingSportService;
	}

	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSportService.save(parkingSpotModel));
	}
}
