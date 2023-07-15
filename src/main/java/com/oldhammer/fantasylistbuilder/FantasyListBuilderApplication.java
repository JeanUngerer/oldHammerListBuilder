package com.oldhammer.fantasylistbuilder;

import com.oldhammer.fantasylistbuilder.auth.config.RsaKeyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
@Slf4j
public class FantasyListBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FantasyListBuilderApplication.class, args);
    }

}
