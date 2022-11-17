package io.tearstar.herojourney.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HEROES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer level;

    private Integer str = 2;

    private Integer dex = 2;

    private Integer mnd = 2;

    private Integer vit = 2;

    public HeroClass heroClass;

}
