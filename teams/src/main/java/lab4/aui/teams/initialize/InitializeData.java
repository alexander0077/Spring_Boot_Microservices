package lab4.aui.teams.initialize;

import lab4.aui.teams.entity.Team;
import lab4.aui.teams.service.TeamService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final TeamService teamService;

    public InitializeData(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Team psg = Team.builder().uuid(UUID.fromString("f5872213-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("PSG")
                .budget(800000000)
                .build();
        teamService.create(psg);

        Team legia = Team.builder().uuid(UUID.fromString("f5872213-bf7b-4ae1-b8a5-5b70a1b90e90"))
                .name("Legia Warszawa")
                .budget(8000000)
                .build();
        teamService.create(legia);

        Team man_city = Team.builder().uuid(UUID.fromString("b5a94031-577b-4da0-87f1-1918e7c5f43f"))
                .name("Manchaster City")
                .budget(450000000)
                .build();
        teamService.create(man_city);

        Team bayern = Team.builder().uuid(UUID.fromString("fafe8e68-88b2-4c7e-9c56-5d8b5019a9c1"))
                .name("Bayern Munich")
                .budget(90000000)
                .build();
        teamService.create(bayern);
    }
}
