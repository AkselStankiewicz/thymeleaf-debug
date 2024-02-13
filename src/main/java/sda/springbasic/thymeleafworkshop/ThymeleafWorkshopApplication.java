package sda.springbasic.thymeleafworkshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Moja aplikacja",
                version = "1.0.0"
        )
)
@SpringBootApplication
public class ThymeleafWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafWorkshopApplication.class, args);
    }

}
