package com.sport.chocolateros.app.document;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customerSoccerField")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSoccerField {
    @Id
    private String id;
    private String customerName;
    private String customerLastName;
    private String customerAge;
    private String email;
    private String phone;
    private String password;
    private String soccerFieldName;
    private String departament;
    private String district;
    private String soccerFieldAddress;
    private String startTime;
    private String endTime;
    private Integer quantitySoccersField;
    private String photo;
    private List<SoccerField> soccerFields;

}
