package mk.finki.ukim.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WpstudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(WpstudyApplication.class, args);
    }

}
