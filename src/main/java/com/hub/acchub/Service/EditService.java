package com.hub.acchub.Service;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    private final AccountRepository accountRepository;

    public EditService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Boolean UpdateName(AccountModel account, String NewName){
        if(!account.getUsername().equals(NewName)){
            account.setUsername(NewName);
            accountRepository.save(account);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean BlockUser(AccountModel account){
        account.setActive(!account.isActive());
        accountRepository.save(account);
        return account.isActive();
    }
}
