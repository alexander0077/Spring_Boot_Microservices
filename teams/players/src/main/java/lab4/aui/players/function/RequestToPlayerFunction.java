package lab4.aui.players.function;

import lab4.aui.players.dto.PutPlayerRequest;
import lab4.aui.players.entity.Player;
import lab4.aui.teams.entity.Team;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToPlayerFunction implements BiFunction<UUID, PutPlayerRequest, Player> {

    @Override
    public Player apply(UUID id, PutPlayerRequest request) {
        return Player.builder()
                .uuid(id)
                .name(request.getName())
                .shirt_number(request.getShirt_number())
                .team(Team.builder()
                        .uuid(request.getTeam())
                        .build())
                .build();
    }

}
