package com.hub.acchub.Repository;

import com.hub.acchub.Models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    AccountModel findByUsernameOrEmail(String username, String email);

    AccountModel findByUsername(String username);
}
