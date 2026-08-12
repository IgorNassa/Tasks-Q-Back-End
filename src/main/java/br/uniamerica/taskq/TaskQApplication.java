package br.uniamerica.taskq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TaskQApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskQApplication.class, args);
    }

}
