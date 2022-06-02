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
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite")
        }
    )
    @GetMapping("/invite")
    public Iterable<Invite> getAllInvite(@RequestHeader(value="API-KEY") String apiKey ){
        return inviteRepository.findAll();
    }

    @Operation( 
        responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé")
        }
    )
    @GetMapping("/invite/{id}")
    public Invite getInviteById(@RequestHeader(value="API-KEY") String apiKey ,@PathVariable Long id) {
        return inviteRepository.findById(id)
                .orElseThrow(() -> new InviteNotFoundException());
    }

    @Operation( responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
        }
    )
    @PostMapping("/invite")
    public void postInvite(@RequestHeader(value="API-KEY") String apiKey, @RequestBody Invite invite){
        if(invite.getPlatChoisi().equals("Boeuf") || invite.getPlatChoisi().equals("Poisson") || invite.getPlatChoisi().equals("Vege"))
            inviteRepository.save(invite);
    }

    @Operation( responses = {
            @ApiResponse(responseCode = "200", description = "Reussite")
        }
    )
    @PutMapping ("/invite")
    public void putInvite(@RequestHeader(value="API-KEY") String apiKey , @RequestBody Invite invite){
        inviteRepository.save(invite);
    }

    @Operation( responses = {
            @ApiResponse(responseCode = "200", description = "Reussite"),
            @ApiResponse(responseCode = "404", description = "Ressource non trouvé")
        }
    )
    @DeleteMapping ("/invite/{id}")
    public void deleteInvite(@RequestHeader(value="API-KEY") String apiKey , @PathVariable Long id){
        inviteRepository.deleteById(id);
    }

}
