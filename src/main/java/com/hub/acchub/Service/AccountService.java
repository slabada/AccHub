package com.hub.acchub.Service;

import com.hub.acchub.Models.AccountModel;
import com.hub.acchub.Models.Role;
import com.hub.acchub.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Value("${defaultAvatar}")
    String defaultAvatar;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel account = accountRepository.findByUsernameOrEmail(username, username);
        if(account == null){
            throw new UsernameNotFoundException("Неверный логин или пароль");
        }
        return account;
    }

    public Optional<AccountModel> UserById(long id){
        return accountRepository.findById(id);
    }

    public boolean AddUser(AccountModel account){

        AccountModel accountFromDb = accountRepository.findByUsername(account.getUsername());

        if(accountFromDb != null){
            return false;
        }

        account.setUsername(account.getUsername());
        account.setEmail(account.getEmail());
        account.setPassword(account.getPassword());
        account.setAvatar(defaultAvatar);
        account.setRoles(Collections.singleton(new Role(1L)));
        account.setActive(true);

        accountRepository.save(account);

        return true;
    }
}
