package io.tearstar.herojourney.model.base.event;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EVENT_FIGHT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventFightEnemies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EVENT_FIGHT_ID")
    private EventFight eventFight;

    @ManyToOne
    @JoinColumn(name = "ENEMY_BASE_ID")
    private EnemyBase enemyBase;

}
