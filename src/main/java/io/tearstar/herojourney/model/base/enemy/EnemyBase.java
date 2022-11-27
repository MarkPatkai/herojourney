package io.tearstar.herojourney.model.base.enemy;

import io.tearstar.herojourney.model.core.DeveloperField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_BASE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnemyBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DeveloperField(field = "id", editable = false)
    private Long id;

    @DeveloperField(field = "name", required = true)
    private String name;

    @DeveloperField(field = "level", required = true)
    private int level;

    @DeveloperField(field = "health", required = true)
    private int health;

    @DeveloperField(field = "attack", required = true)
    private int attack;

    private int defense;

}
