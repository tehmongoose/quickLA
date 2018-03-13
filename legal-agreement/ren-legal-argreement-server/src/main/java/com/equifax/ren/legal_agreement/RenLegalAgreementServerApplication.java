package com.equifax.ren.legal_agreement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RenLegalAgreementServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenLegalAgreementServerApplication.class, args);
    }
}
