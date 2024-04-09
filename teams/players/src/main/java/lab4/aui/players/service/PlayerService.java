package lab4.aui.players.service;

import lab4.aui.players.entity.Player;
import lab4.aui.players.repository.PlayerRepository;
import lab4.aui.teams.entity.Team;
import lab4.aui.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    public final PlayerRepository playerRepository;
    public final TeamRepository teamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public void create(Player player){
        playerRepository.save(player);
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public List<Player> findAllByTeam(Team team){
        return playerRepository.findAllByTeam(team);
    }

    public Optional<List<Player>> findAllByTeamsId(UUID id){
        return teamRepository.findByUuid(id)
                .map(playerRepository::findAllByTeam);

    }

    public Optional<Player> findByName(String name){
        return playerRepository.findByName(name);
    }

    public Optional<Player> findByUUID(UUID uuid){
        return playerRepository.findByUuid(uuid);
    };

    public void delete(UUID id){
        playerRepository.findById(id).ifPresent(playerRepository::delete);;
    }

    public void update(UUID id, String name, int shirt_number){
        Player player = playerRepository.findById(id).get();
        if (shirt_number != 0){
            player.setShirt_number(shirt_number);
        }
        if (name != null){
            player.setName(name);
        }
        playerRepository.save(player);
    }
}

