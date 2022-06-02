package com.delaporte.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Invite {
    @Schema(description = "Identifiant de l'invite'", example = "1")
    @Id
    private String id;
    @Schema(description = "Nom de l'invité", example = "Delaporte")
    private String nom;
    @Schema(description = "Prenom de l'invité", example = "Quentin")
    private String prenom;
    @Schema(description = "Est présent à la cérémonie", example = "1")
    private boolean presentCeremonie;
    @Schema(description = "Est présent au vin d'honneur", example = "1")
    private boolean presentVinHonneur;
    @Schema(description = "Est présent au repas", example = "1")
    private boolean presentRepas;
    @Schema(description = "Plat choisi", example = "Boeuf")
    private String platChoisi;


    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public boolean getPresentCeremonie() {
        return presentCeremonie;
    }
    public boolean getPresentVinHonneur() {
        return presentVinHonneur;
    }
    public boolean getPresentRepas() {
        return presentRepas;
    }
    public String getPlatChoisi() {
        return platChoisi;
    }

}
