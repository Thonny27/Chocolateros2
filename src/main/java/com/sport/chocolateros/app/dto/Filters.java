package com.sport.chocolateros.app.dto;

import lombok.Data;

@Data
public class Filters {

    private String name;
    private String departament;
    private String type;
    private Integer maxPlayers;
    private Float price;
}
