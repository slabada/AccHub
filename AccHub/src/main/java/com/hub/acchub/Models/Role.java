package com.hub.acchub.Models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;

    public Role(){

    }

    public Role(Long id){
        this.id = id;
    }

    public Role(Long id, String name){

        this.id = id;
        this.name = name;
    }

    public Role(String name){

        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
