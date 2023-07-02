package com.hub.acchub.Controllers;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Repository.LotsRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LotsRepository lotsRepository;

    public HomeController(LotsRepository lotsRepository){
        this.lotsRepository = lotsRepository;
    }

    @GetMapping("/")
    public String getHome(HttpSession session, @AuthenticationPrincipal AccountModel user, Model model){
        model.addAttribute("lots", lotsRepository.findAll());
        session.setAttribute("user", user);
        return "index";
    }
}
