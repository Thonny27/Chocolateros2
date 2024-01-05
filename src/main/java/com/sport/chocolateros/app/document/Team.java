package com.sport.chocolateros.app.document;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private String id;
    private String nameTeam;
    private User userAdminTeam;
    private String departament;
    private String district;
    private Integer quantityPlayers;
    private String photo;
    private List<Player> players;
}
