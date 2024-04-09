package lab4.aui.teams.function;

import lab4.aui.teams.dto.PutTeamRequest;
import lab4.aui.teams.entity.Team;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToTeamFunction implements BiFunction<UUID, PutTeamRequest, Team> {

    @Override
    public Team apply(UUID id, PutTeamRequest request) {
        return Team.builder()
                .uuid(id)
                .name(request.getName())
                .budget(request.getBudget())
                .build();
    }

}
