package com.hub.acchub.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LotsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
