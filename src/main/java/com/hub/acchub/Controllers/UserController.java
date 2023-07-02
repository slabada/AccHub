package com.hub.acchub.Controllers;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {

    private final AccountService accountService;

    public UserController(AccountService accountService){
        this.accountService = accountService;
    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model){
        Optional<AccountModel> User = accountService.UserById(id);
        model.addAttribute("user", User);
        if(User.isEmpty()){
            return "redirect:/";
        }
        return "user";
    }

    @GetMapping("/settings")
    public String getSettings(){
        return "settings";
    }

    @GetMapping("{id}/edit")
    public String getEditUser(@PathVariable("id") long id, Model model){
        Optional<AccountModel> User = accountService.UserById(id);
        model.addAttribute("user", User);
        return "edit";
    }
}
