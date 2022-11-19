package io.tearstar.herojourney.model.response;

import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.base.HeroDetails;
import io.tearstar.herojourney.model.base.HeroPurse;
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
