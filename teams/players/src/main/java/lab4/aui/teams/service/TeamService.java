package lab4.aui.teams.service;

import lab4.aui.teams.entity.Team;
import lab4.aui.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public void create(Team team){
        teamRepository.save(team);
    }

    public Optional<Team> findByUuid(UUID id){
        return teamRepository.findByUuid(id);
    }

    public void delete(UUID id) {
        teamRepository.findByUuid(id).ifPresent(teamRepository::delete);
    }
}
