package lab4.aui.teams.controller;

import lab4.aui.teams.dto.GetTeamResponse;
import lab4.aui.teams.dto.GetTeamsResponse;
import lab4.aui.teams.dto.PutTeamRequest;
import lab4.aui.teams.function.RequestToTeamFunction;
import lab4.aui.teams.function.TeamToResponseFunction;
import lab4.aui.teams.function.TeamsToResponseFunction;
import lab4.aui.teams.service.TeamService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log

public class TeamController {
    private final TeamService service;
    private final TeamToResponseFunction teamToResponse;
    private final TeamsToResponseFunction teamsToResponse;
    private final RequestToTeamFunction requestToTeam;

    @Autowired
    public TeamController(
            TeamService service,
            TeamToResponseFunction teamToResponse,
            TeamsToResponseFunction teamsToResponse,
            RequestToTeamFunction requestToTeam
    ) {
        this.service = service;
        this.teamToResponse = teamToResponse;
        this.teamsToResponse = teamsToResponse;
        this.requestToTeam = requestToTeam;
    }

    @GetMapping("api/teams")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetTeamsResponse getTeams() {
        return teamsToResponse.apply(service.findAll());
    }

    @GetMapping("api/teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetTeamResponse getTeam(@PathVariable("id") UUID id
    ) {
        return service.findByUuid(id)
                .map(teamToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
