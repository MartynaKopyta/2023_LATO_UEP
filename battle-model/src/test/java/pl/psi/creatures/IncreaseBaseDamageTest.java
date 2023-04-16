package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncreaseBaseDamageTest {

    @Test
    public void shouldIncreaseBaseDamage(){
        Random rand = new Random(42L);
        Creature attacker = new Creature.Builder()
                .amount(10)
                .statistic(CreatureStats.builder()
                        .maxHp(10)
                        .damage(Range.closed(5, 5))
                        .attack(5)
                        .armor(0)
                        .build())
                .build();
        Creature defender = new Creature.Builder()
                .amount(10)
                .statistic(CreatureStats.builder()
                        .maxHp(20)
                        .damage(Range.closed(5, 5))
                        .attack(5)
                        .armor(0)
                        .build())
                .build();

        // Create a new instance of IncreaseBaseDamage with shouldIncreaseDamage = true
        IncreaseBaseDamage strategy = new IncreaseBaseDamage(rand, true);

        // Calculate the damage using the new strategy
        int damageWithIncrease = strategy.calculateDamage(attacker, defender);

        // Create a new instance of IncreaseBaseDamage with shouldIncreaseDamage = false
        IncreaseBaseDamage defaultStrategy = new IncreaseBaseDamage(rand, false);

        // Calculate the damage using the default strategy
        int damageWithoutIncrease = defaultStrategy.calculateDamage(attacker, defender);

        // Assert that the damage with the increased base damage is greater than the damage without the increase
        assertTrue(damageWithIncrease > damageWithoutIncrease);
    }
}
