package lab4.aui.players.controller;

import lab4.aui.players.dto.GetPlayersResponse;
import lab4.aui.players.dto.PatchPlayerRequest;
import lab4.aui.players.dto.PutPlayerRequest;
import lab4.aui.players.function.PlayerToResponseFunction;
import lab4.aui.players.function.PlayersToResponseFunction;
import lab4.aui.players.function.RequestToPlayerFunction;
import lab4.aui.players.service.PlayerService;
import lab4.aui.teams.service.TeamService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lab4.aui.players.dto.GetPlayerResponse;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class PlayerController {

    private final PlayerService service;

    private final TeamService teamService;
    private final PlayerToResponseFunction playerToResponse;

    private final PlayersToResponseFunction playersToResponse;

    private final RequestToPlayerFunction requestToPlayer;

    @Autowired
    public PlayerController(
            PlayerService service,
            TeamService teamService, PlayerToResponseFunction playerToResponse,
            PlayersToResponseFunction playersToResponse,
            RequestToPlayerFunction requestToPlayer
    ){
        this.service = service;
        this.teamService = teamService;
        this.playerToResponse = playerToResponse;
        this.playersToResponse = playersToResponse;
        this.requestToPlayer = requestToPlayer;
    }

    @GetMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(
            @PathVariable("id")
            UUID id
    ){
        return service.findByUUID(id)
                .map(playerToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("api/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers(){
        return playersToResponse.apply(service.findAll());
    }

    @GetMapping("api/teams/{teamId}/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getTeamPlayers(@PathVariable("teamId")
                                      UUID teamId
    ){
        return service.findAllByTeamsId(teamId)
                .map(playersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCharacter(
            @PathVariable("id")
            UUID id
    ){
        service.findByUUID(id)
                .ifPresentOrElse(
                        player -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @PutMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPlayer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutPlayerRequest request
    ){
        if (teamService.findByUuid(request.getTeam()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        service.create(requestToPlayer.apply(id, request));
    }

    @PatchMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void patchPlayer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchPlayerRequest request
    ){
        if (service.findByUUID(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        service.update(id, request.getName(), request.getShirt_number());
    }
}
