package com.harsh.springjdbc;

import com.harsh.springjdbc.model.Alien;
import com.harsh.springjdbc.model.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        Alien alien = context.getBean(Alien.class);
        alien.setId(1);
        alien.setName("Harsh");
        alien.setTech("Software");

        AlienRepo repo = context.getBean(AlienRepo.class);
        repo.save(alien);
        System.out.println(repo.getallAlien());
    }

}
