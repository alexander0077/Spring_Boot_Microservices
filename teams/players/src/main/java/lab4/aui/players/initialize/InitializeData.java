package lab4.aui.players.initialize;

import lab4.aui.players.entity.Player;
import lab4.aui.players.service.PlayerService;
import lab4.aui.teams.service.TeamService;
import lab4.aui.teams.entity.Team;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final TeamService teamService;
    private final PlayerService playerService;

    public InitializeData(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
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

        playerService.create(Player.builder().uuid(UUID.fromString("d8c0ca57-6a87-4981-b7c2-2f2d1e80d605"))
                .name("Gianluigi Donnarumma")
                .shirt_number(21)
                .team(psg)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                .name("Ousmane Dembele")
                .shirt_number(10)
                .team(psg)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("6cf194d2-8f95-45cb-af0a-3b781db6e6f0"))
                .name("Kylian Mbappe")
                .shirt_number(7)
                .team(psg)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("9f5eab12-2e54-4923-8e5b-cdc6e2442a6b"))
                .name("Kevin De Bruyne")
                .shirt_number(17)
                .team(man_city)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("e155f53a-497d-4b4a-9e7c-5e3ad7bb4800"))
                .name("Aymeric Laporte")
                .shirt_number(14)
                .team(man_city)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("ddc0ef58-4dab-490c-9a97-30b33e8e9204"))
                .name("Phil Foden")
                .shirt_number(47)
                .team(man_city)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("b7bb5b11-6f38-4ea3-9b38-240d7b8313a5"))
                .name("Harry Kane")
                .shirt_number(9)
                .team(bayern)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("c35c6093-57cc-48ec-8a19-63be8b252789"))
                .name("Manuel Neuer")
                .shirt_number(24)
                .team(bayern)
                .build());

        playerService.create(Player.builder().uuid(UUID.fromString("7d4e8fc6-8faa-4db7-bcd3-87aee94f2626"))
                .name("Jamal Musiala")
                .shirt_number(42)
                .team(bayern)
                .build());
    }
}
