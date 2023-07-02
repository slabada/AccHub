package com.hub.acchub.Controllers;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/registration")
    public String GetRegistration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String PostRegistration(AccountModel account, Model model){
        if(!accountService.AddUser(account)){
            model.addAttribute("Error_Text", "Пользователь не существует!");
            return "/registration";
        }
        return "redirect:/";
    }
}
