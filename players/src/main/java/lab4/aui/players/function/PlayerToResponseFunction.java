package lab4.aui.players.function;

import lab4.aui.players.dto.GetPlayerResponse;
import lab4.aui.players.entity.Player;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlayerToResponseFunction implements Function<Player, GetPlayerResponse> {

    @Override
    public GetPlayerResponse apply(Player entity) {
        return GetPlayerResponse.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .shirt_number(entity.getShirt_number())
                .team((GetPlayerResponse.Team.builder()
                        .uuid(entity.getTeam().getUuid())
                        .name(entity.getTeam().getName())
                        .build())
                )
                .build();
    }

}
