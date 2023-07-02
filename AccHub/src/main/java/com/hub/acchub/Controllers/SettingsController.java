package com.hub.acchub.Controllers;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Repository.AccountRepository;
import com.hub.acchub.Service.AccountService;
import com.hub.acchub.Service.SettingsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/users/settings/")
public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService){
        this.settingsService = settingsService;
    }

    @GetMapping("/image")
    public String GetImage(){
        return "settings/image";
    }

    @PutMapping("/image")
    public String PutImage(@RequestParam("file")MultipartFile file,
                           @AuthenticationPrincipal AccountModel account,
                           Model model) throws IOException
    {
        if(settingsService.UpdateAvatar(account, file)){
            return "redirect:/users/settings";
        }
        else {
            model.addAttribute("Error_Text", "Произошла ошибка");
            return "settings/image";
        }
    }

    @GetMapping("/password")
    public String GetPassword(){
        return "settings/password";
    }

    @PutMapping("/password")
    public String PutPassword(@RequestParam("OldPassword") String OldPassword,
                              @RequestParam("NewPassword") String NewPassword,
                              @AuthenticationPrincipal AccountModel user,
                              Model model
    ){
        if(settingsService.UpdatePassword(user, OldPassword, NewPassword)){
            return "redirect:/users/settings";
        }
        else {
            model.addAttribute("Error_Text", "Не верный пароль или новый пароль совпадает со старым!");
            return "settings/password";
        }
    }

    @GetMapping("/email")
    public String GetEmail(){
        return "settings/email";
    }

    @PutMapping("/email")
    public String PutEmail(@RequestParam("NewEmail") String NewEmail,
                           @AuthenticationPrincipal AccountModel user,
                           Model model
    ){
        if(settingsService.UpdateEmail(user, NewEmail)){
            return "redirect:/users/settings";
        }
        else {
            model.addAttribute("Error_Text", "К учетной записи уже привязана данная почта.!");
            return "settings/email";
        }
    }
}
