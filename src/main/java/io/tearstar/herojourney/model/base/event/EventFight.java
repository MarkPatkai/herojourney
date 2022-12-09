package io.tearstar.herojourney.model.base.event;

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
public class EventFight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EVENT_BASE_ID")
    private EventBase eventBase;

}
