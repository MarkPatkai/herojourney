package io.tearstar.herojourney.model.base.spell;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "RESISTANCE_TYPE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResistenceType {

    // all, armor, magic, ignore

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
