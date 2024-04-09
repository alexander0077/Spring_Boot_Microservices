package lab4.aui.teams.controller;

import lab4.aui.teams.dto.PutTeamRequest;
import lab4.aui.teams.function.RequestToTeamFunction;
import lab4.aui.teams.service.TeamService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log

public class TeamController {
    private final TeamService service;
    private final RequestToTeamFunction requestToTeam;

    @Autowired
    public TeamController(
            TeamService service,
            RequestToTeamFunction requestToTeam) {
        this.service = service;
        this.requestToTeam = requestToTeam;
    }

    @DeleteMapping("api/teams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteTeam(@PathVariable("id") UUID id
    ) {
        service.findByUuid(id)
                .ifPresentOrElse(
                        team -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );

    }

    @PutMapping("/api/teams/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putTeam(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutTeamRequest request
    ){
        service.create(requestToTeam.apply(id, request));
    }
}
