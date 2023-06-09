package pi.enset.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereDTO {
    private Long id;
    private String libelle;
    private int nombreSem;
    private String chefFiliere; //à discuter
    private DepartementDTO departement;
}
