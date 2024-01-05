package com.sport.chocolateros.app.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String namePlayer;
    private String lastNamePlayer;
    private String nickName;
    private Integer agePlayer;
    private String positionPlayer;
    private String photo;
}
