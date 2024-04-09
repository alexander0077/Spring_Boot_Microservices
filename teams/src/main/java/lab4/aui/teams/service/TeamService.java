package lab4.aui.teams.service;

import lab4.aui.teams.dto.PutTeamRequest;
import lab4.aui.teams.entity.Team;
import lab4.aui.teams.event.TeamEventRestRepository;
import lab4.aui.teams.repository.TeamRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamEventRestRepository eventRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, TeamEventRestRepository eventRepository){
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
    }

    public void create(Team team){
        teamRepository.save(team);
        eventRepository.put(team.getUuid(), team);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Optional<Team> findByName(String name){
        return teamRepository.findByName(name);
    }

    public Optional<Team> findByUuid(UUID id){
        return teamRepository.findByUuid(id);
    }

    public void delete(UUID id) {
        teamRepository.findByUuid(id).ifPresent(teamRepository::delete);
        eventRepository.delete(id);
    }

}

