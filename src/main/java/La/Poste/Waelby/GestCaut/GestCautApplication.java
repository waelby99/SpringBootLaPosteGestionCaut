package La.Poste.Waelby.GestCaut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController
public class GestCautApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestCautApplication.class, args);
	}

	@GetMapping
	public List<String> hello(){
		return Arrays.asList("hello" ,"world");
	}
}