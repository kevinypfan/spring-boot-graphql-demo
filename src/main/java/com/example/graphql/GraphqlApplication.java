package com.example.graphql;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            Author john = authorRepository.save(new Author(null, "John Long"));
            Author mark = authorRepository.save(new Author(null, "Mark Heckler"));

            bookRepository.saveAll(List.of(
                    new Book(null, "Reactive Spring", "Kevin", john),
                    new Book(null, "Cloud Native Java", "Allen", mark),
                    new Book(null, "Front End React", "Kao", mark)
            ));
        };
    }
}
