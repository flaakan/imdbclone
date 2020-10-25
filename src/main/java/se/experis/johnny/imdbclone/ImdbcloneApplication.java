package se.experis.johnny.imdbclone;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.experis.johnny.imdbclone.entity.Actor;
import se.experis.johnny.imdbclone.repository.ActorRepository;

import java.util.Date;

@SpringBootApplication
public class ImdbcloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImdbcloneApplication.class, args);
    }

}
