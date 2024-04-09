package lab4.aui.players.entity;

import jakarta.persistence.*;
import lab4.aui.teams.entity.Team;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@ToString
@Table(name = "players")
public class Player implements Serializable {
    @Id
    private UUID uuid;

    @Column(unique = true)
    private String name;

    private int shirt_number;

    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

}
