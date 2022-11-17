package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.Hero;
import io.tearstar.herojourney.model.exceptions.DataNotFoundException;
import io.tearstar.herojourney.model.exceptions.ExceptionMessage;
import io.tearstar.herojourney.model.repository.UserHeroRepository;
import io.tearstar.herojourney.model.repository.UserRepository;
import io.tearstar.herojourney.model.user.User;
import io.tearstar.herojourney.model.user.UserHero;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private UserHeroRepository userHeroRepository;

    public UserService(UserRepository userRepository, UserHeroRepository userHeroRepository) {
        this.userRepository = userRepository;
        this.userHeroRepository = userHeroRepository;
    }

    public User createUser(@NonNull User user) {
        log.info("Creating user with name {}", user.getUserId());
        return userRepository.save(user);
    }
    public UserHero createHeroForUser(@NonNull User user, @NonNull Hero hero) throws DataNotFoundException {
        if (isNull(user.getId())) throw new DataNotFoundException("There exists no such user!");
        if (isNull(hero.getId())) throw new DataNotFoundException("There exists no such hero!");
        log.info("Binding User({}) with Hero({})", user.getUserId(), hero.getName());
        return userHeroRepository.save(UserHero.builder().hero(hero).user(user).build());
    }


    public User getUserById(@NonNull Long id) {
        return userRepository.getReferenceById(id);
    }

    public boolean deleteUser(Long id) {
        userRepository.delete(userRepository.getReferenceById(id));
        return true;
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    private ExceptionMessage handleDataNotFoundException(DataNotFoundException ex){
        log.error("Data error in {}, error: ", this.getClass().getSimpleName(), ex);
        return ExceptionMessage.builder().exception(ex).errorMsg(ex.getMessage()).build();
    }

}
