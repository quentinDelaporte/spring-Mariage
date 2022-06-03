package com.delaporte.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController

public class InviteController {
    @Autowired
    
    private InviteRepository inviteRepository;

    
    @Operation( 
        summary = "Retourne la liste des invités",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @GetMapping("/invite")
    public Iterable<Invite> getAllInvite(@RequestHeader(value="API-KEY") String apiKey ){
        return inviteRepository.findAll();
    }

    @Operation( 
        summary = "Retourne l'invités correspondant à l'id",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @GetMapping("/invite/id/{id}")
    public Invite getInviteById(@RequestHeader(value="API-KEY") String apiKey ,@PathVariable String id) {
        return inviteRepository.findById(id)
                .orElseThrow(() -> new InviteNotFoundException());
    }
    
    @Operation( 
        summary = "Retourne les stats de présence de chaque 'evenement'",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @GetMapping("/invite/stat/")
    public String getNbInviteByPresenceCeremonie(@RequestHeader(value="API-KEY") String apiKey) {
        return "{\"Presence_Ceremony\":\"" + inviteRepository.countByPresentCeremonie(true) + "\", \"Presence_Vin_Honneur\":\"" + inviteRepository.countByPresentVinHonneur(true) + "\", \"Presence_Present_Repas\":\"" + inviteRepository.countByPresentRepas(true) + "\"}";
    }

    @Operation( 
        summary = "Retourne le nombre de participant par plat",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @GetMapping("/invite/plat/")
    public String getNbInviteByPlat(@RequestHeader(value="API-KEY") String apiKey) {
        return "{\"Boeuf\" : " + inviteRepository.countByPlatChoisi("Boeuf") + ",\"Poisson\" : " + inviteRepository.countByPlatChoisi("Poisson") + ",\"Vege\" : " + inviteRepository.countByPlatChoisi("Vege") + "}";
    }

    @Operation( 
        summary = "Ajoute un invité",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @PostMapping("/invite")
    public void postInvite(@RequestHeader(value="API-KEY") String apiKey, @RequestBody Invite invite){
        if(invite.getPlatChoisi().equals("Boeuf") || invite.getPlatChoisi().equals("Poisson") || invite.getPlatChoisi().equals("Vege"))
            inviteRepository.save(invite);
        else throw new PlatNotFoundException();
    }

    @Operation( 
        summary = "Modifie un invité",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @PutMapping ("/invite")
    public void putInvite(@RequestHeader(value="API-KEY") String apiKey , @RequestBody Invite invite){
        if(invite.getPlatChoisi().equals("Boeuf") || invite.getPlatChoisi().equals("Poisson") || invite.getPlatChoisi().equals("Vege"))
            inviteRepository.save(invite);
        else throw new PlatNotFoundException();
    }

    @Operation(
        summary = "Supprime un invité",
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé"),
            @ApiResponse(responseCode = "403", description = "Authentification impossible")
        }
    )
    @DeleteMapping ("/invite/{id}")
    public void deleteInvite(@RequestHeader(value="API-KEY") String apiKey , @PathVariable Long id){
        inviteRepository.deleteById(id);

    }

}
