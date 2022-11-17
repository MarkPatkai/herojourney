package io.tearstar.herojourney.model.base;

import io.tearstar.herojourney.model.base.HeroClass;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="HEROTEMPLATES")
public class HeroTemplate {

    public Long id;

    public HeroClass name;

    private Integer str;

    private Integer dex;

    private Integer mnd;

    private Integer vit;

}
