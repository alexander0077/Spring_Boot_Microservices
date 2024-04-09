package lab4.aui.teams.function;

import lab4.aui.teams.dto.GetTeamResponse;
import lab4.aui.teams.entity.Team;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamToResponseFunction implements Function<Team, GetTeamResponse> {
    @Override
    public GetTeamResponse apply(Team entity) {
        return GetTeamResponse.builder()
                .id(entity.getUuid())
                .name(entity.getName())
                .budget(entity.getBudget())
                .build();
    }


}
