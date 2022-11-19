package io.tearstar.herojourney.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HERO_PURSE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeroPurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gold = 100;

    private int crystal;

    private int heavenCoin;

    @OneToOne(mappedBy = "hero_id")
    private Hero owner;
}
