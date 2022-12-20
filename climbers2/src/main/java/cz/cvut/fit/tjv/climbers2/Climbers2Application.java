package cz.cvut.fit.tjv.climbers2;

import cz.cvut.fit.tjv.climbers2.domain.Climber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class Climbers2Application {

	public static void main(String[] args) {
		SpringApplication.run(Climbers2Application.class, args);
	}


}
