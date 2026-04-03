package pe.edu.idat.book_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("=====================================");
            System.out.println("🚀 BOOK-SERVICE LEVANTADO");
            System.out.println("🌐 URL: http://localhost:8082");
            System.out.println("=====================================");
        };
    }
}