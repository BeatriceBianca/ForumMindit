package com.mindit.forum;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({"com.mindit.forum"})
@EnableJpaRepositories("com.mindit.forum")
@EntityScan({"com.mindit.forum"})
@ComponentScan({"com.mindit.forum"})
@EnableScheduling
@Configuration
public class MinditForum {

    private static final Logger log = LoggerFactory.getLogger(MinditForum.class);

    public static void main(String[] args) {

        SpringApplication.run(MinditForum.class, args);

        log.info("Access URL: \n ---------------------------------------------\n\t" +
                "Local: \t\thttp://127.0.0.1:8080\n");

    }

}
