package FirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "domain")
//@EntityScan(basePackages = "domain")
public class SpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }
}
