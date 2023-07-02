package com.hub.acchub.Controllers;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Service.EditService;
import com.hub.acchub.Service.SettingsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/users/{id}/edit")
public class EditController {

    private final SettingsService settingsService;
    private final EditService editService;

    public EditController(SettingsService settingsService, EditService editService){
        this.settingsService = settingsService;
        this.editService = editService;
    }

    @GetMapping("/image")
    public String GetImage(@PathVariable("id") String id, Model model){
        model.addAttribute("userId", id);
        return "edit/image";
    }

    @PutMapping("/image")
    public String PutImage(@RequestParam("file") MultipartFile file,
                           @PathVariable("id") AccountModel account,
                           Model model) throws IOException
    {
        if(settingsService.UpdateAvatar(account, file)){
            return "redirect:/users/{id}/edit";
        }
        else {
            model.addAttribute("Error_Text", "Произошла ошибка");
            return "edit/image";
        }
    }

    @GetMapping("/name")
    public String GetPassword(@PathVariable("id") String id, Model model){
        model.addAttribute("userId", id);
        return "edit/name";
    }

    @PutMapping("/name")
    public String PutPassword(@RequestParam("NewName") String NewName,
                              @PathVariable("id") AccountModel user,
                              Model model
    ){
        if(editService.UpdateName(user, NewName)){
            return "redirect:/users/{id}/edit";
        }
        else {
            model.addAttribute("Error_Text", "Данное имя уже принадлежит этому пользователю!");
            return "edit/name";
        }
    }

    @PutMapping("/block")
    public String BlockUser(@PathVariable("id") AccountModel account){

        editService.BlockUser(account);

        return "redirect:/users/{id}/edit";
    }
}
