package lab4.aui.players.function;

import lab4.aui.players.dto.PatchPlayerRequest;
import lab4.aui.players.entity.Player;

import java.util.function.BiFunction;

public class UpdatePlayerWIthRequestFunction implements BiFunction<Player, PatchPlayerRequest, Player> {
    @Override
    public Player apply(Player player, PatchPlayerRequest request) {
        return Player.builder()
                .uuid(player.getUuid())
                .name(request.getName())
                .shirt_number(request.getShirt_number())
                .team(player.getTeam())
                .build();
    }
}
