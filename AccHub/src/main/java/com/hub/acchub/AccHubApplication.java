package com.hub.acchub;

import com.hub.acchub.Models.AccountModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AccHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccHubApplication.class, args);
    }
}
