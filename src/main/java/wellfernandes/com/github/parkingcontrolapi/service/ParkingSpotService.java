package wellfernandes.com.github.parkingcontrolapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wellfernandes.com.github.parkingcontrolapi.model.ParkingSpotModel;
import wellfernandes.com.github.parkingcontrolapi.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Transactional
	public Object save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);
	}

	public ParkingSpotRepository getParkingSpotRepository() {
		return parkingSpotRepository;
	}

	public boolean existsByLicensePlateCar(String licensePlateCar) {
		
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}
}
