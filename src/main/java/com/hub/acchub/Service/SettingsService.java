package com.hub.acchub.Service;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SettingsService {

    private final AccountRepository accountRepository;

    public SettingsService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Value("${upload.path}")
    private String uploadPath;

    public Boolean UpdateAvatar(AccountModel account, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFile = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + "/" + resultFile));
            account.setAvatar(resultFile);
            accountRepository.save(account);

            return true;
        }
        else {
            return false;
        }
    }

    public Boolean UpdatePassword(AccountModel account, String OldPassword, String NewPassword){
        if(account.getPassword().equals(OldPassword) && !NewPassword.equals(OldPassword)){
            account.setPassword(NewPassword);
            accountRepository.save(account);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean UpdateEmail(AccountModel account, String NewEmail){
        if(!account.getEmail().equals(NewEmail)){
            account.setEmail(NewEmail);
            accountRepository.save(account);
            return true;
        }
        else {
            return false;
        }
    }
}
