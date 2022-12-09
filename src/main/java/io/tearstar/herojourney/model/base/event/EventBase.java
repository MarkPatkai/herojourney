package io.tearstar.herojourney.model.base.event;

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
public class EventBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    public int requiredLevel;
}
