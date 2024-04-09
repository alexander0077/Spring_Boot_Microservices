package lab4.aui.teams.function;

import lab4.aui.teams.dto.GetTeamsResponse;
import lab4.aui.teams.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class TeamsToResponseFunction implements Function<List<Team>, GetTeamsResponse> {
    @Override
    public GetTeamsResponse apply(List<Team> entities) {
        return GetTeamsResponse.builder()
                .teams(entities.stream()
                        .map(team -> GetTeamsResponse.Team.builder()
                                .id(team.getUuid())
                                .name(team.getName())
                                .build())
                        .toList())
                .build();
    }


}
