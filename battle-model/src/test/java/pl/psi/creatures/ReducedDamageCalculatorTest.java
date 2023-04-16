package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ReducedDamageCalculatorTest {

    @Test
    public void testCalculateDamage() {
        Random random = new Random(42L); // Use a fixed seed value

        ReducedDamageCalculator calculator = new ReducedDamageCalculator(random, true);
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

        DefaultDamageCalculator defCalculator = new DefaultDamageCalculator(random);
        int damage = calculator.calculateDamage(attacker, defender);
        int baseDamage = defCalculator.calculateDamage(attacker,defender);
        // Assert that the damage is calculated correctly with 5% decrease
        assertEquals((int)(baseDamage-Math.round(baseDamage*0.05)), damage);
    }
}
