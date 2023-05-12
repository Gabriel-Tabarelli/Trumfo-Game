package net.weg.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class TrumfoAPI3Application {

    public static void main(String[] args) {
        SpringApplication.run(TrumfoAPI3Application.class, args);
    }

}
