package com.sport.chocolateros.app.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("soccerField")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoccerField {

    private String typeField;
    private Integer maxNumberOfPlayers;
    private Float price;
    private String photo;
}
