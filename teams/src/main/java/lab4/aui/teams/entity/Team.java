package lab4.aui.teams.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@ToString
@Table(name = "teams")
public class Team implements Serializable {
    @Id
    private UUID uuid;

    @Column(unique = true)
    private String name;

    private int budget;
}