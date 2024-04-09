package lab4.aui.teams.event;

import lab4.aui.teams.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class TeamEventRestRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public TeamEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/teams/{id}", id);
    }

    public void put(UUID id, Team team) {
        restTemplate.put("/api/teams/{id}", team, id);
    }

}
