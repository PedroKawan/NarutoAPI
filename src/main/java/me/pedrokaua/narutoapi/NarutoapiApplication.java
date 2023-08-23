package me.pedrokaua.narutoapi;

import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.repositories.NarutoCharacterRepository;
import me.pedrokaua.narutoapi.models.services.NarutoCharacterServiceImpl;
import me.pedrokaua.narutoapi.models.services.impl.NarutoCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NarutoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NarutoapiApplication.class, args);
	}

}
