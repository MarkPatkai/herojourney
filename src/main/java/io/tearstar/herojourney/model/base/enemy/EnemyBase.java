package io.tearstar.herojourney.model.base.enemy;

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
    private Long id;

    private String name;

    private int level;

    private int health;

    private int attack;

    private int defense;

}
