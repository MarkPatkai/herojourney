package io.tearstar.herojourney.service;

import io.tearstar.herojourney.model.base.enemy.EnemyBase;
import io.tearstar.herojourney.model.repository.event.EnemyBaseRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnemyService {

    private EnemyBaseRepository enemyBaseRepository;

    public EnemyService(EnemyBaseRepository enemyBaseRepository) {
        this.enemyBaseRepository = enemyBaseRepository;
    }

    public EnemyBase getEnemyBaseById(@NonNull Long id) {
        return enemyBaseRepository.findById(id).orElse(null);
    }

    public EnemyBase createEnemyBase(@NonNull EnemyBase enemyBase) {
        return enemyBaseRepository.save(enemyBase);
    }

    public List<EnemyBase> getEnemyBases() {
        return enemyBaseRepository.findAll();
    }
}
