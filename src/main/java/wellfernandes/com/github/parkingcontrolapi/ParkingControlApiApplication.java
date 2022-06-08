package wellfernandes.com.github.parkingcontrolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ParkingControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApiApplication.class, args);
	}

	// just to test
	@GetMapping("/")
	public String index() {
		return "running parking control api!";
	}
}
