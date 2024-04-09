package lab4.aui.players.repository;

import lab4.aui.players.entity.Player;
import lab4.aui.teams.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findAllByTeam(Team team);

    Optional<Player> findByName(String name);

    Optional<Player> findByUuid(UUID uuid);
}
