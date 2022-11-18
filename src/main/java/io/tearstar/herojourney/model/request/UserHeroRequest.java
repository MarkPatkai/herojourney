package io.tearstar.herojourney.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.user.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserHeroRequest {

    private User user;
    private Hero hero;
}
