package io.tearstar.herojourney.model.response;

import io.tearstar.herojourney.model.base.hero.Hero;
import io.tearstar.herojourney.model.base.hero.HeroDetails;
import io.tearstar.herojourney.model.base.hero.HeroPurse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroEssentialsResponse {

    private Long heroId;

    private Hero hero;

    private HeroPurse purse;

    private HeroDetails details;

}
