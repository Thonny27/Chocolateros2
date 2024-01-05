package com.sport.chocolateros.app.document;


import com.sport.chocolateros.app.dto.SoccerFieldReserved;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reserve")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {

    @Id
    private String id;
    private String customerSoccerFieldId;
    private SoccerFieldReserved soccerFieldReserved;
    private User user;
    private String date;
    private String time;
    private Boolean confirmed;
    private Boolean expired;
}
