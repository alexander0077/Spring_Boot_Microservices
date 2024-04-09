package lab4.aui.players.function;

import lab4.aui.players.dto.GetPlayersResponse;
import lab4.aui.players.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse> {

    @Override
    public GetPlayersResponse apply(List<Player> entities) {
        return GetPlayersResponse.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getUuid())
                                .name(player.getName())
                                .build())
                        .toList())
                .build();

    }

}