package hbv501g.gaia.GAIA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GaiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaiaApplication.class, args);
	}

}
