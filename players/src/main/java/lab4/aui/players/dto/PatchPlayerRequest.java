package lab4.aui.players.dto;
import lombok.AccessLevel;
        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.EqualsAndHashCode;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchPlayerRequest {
    private String name;
    private int shirt_number;
}
