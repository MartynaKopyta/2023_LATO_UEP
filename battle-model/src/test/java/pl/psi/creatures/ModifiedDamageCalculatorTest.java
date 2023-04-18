package pl.psi.creatures;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import com.google.common.collect.Range;
import org.junit.Test;

public class ModifiedDamageCalculatorTest {


    @Test
        public void damageShouldBeIncreased1() {
            Random random = new Random(42L); // Use a fixed seed value

            ModifiedDamageCalculator calculator = new ModifiedDamageCalculator(random);
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
            //attacker attack > defender armor
            DefaultDamageCalculator defCalculator = new DefaultDamageCalculator(random);
            int damage = calculator.calculateDamage(attacker, defender);
            int baseDamage = defCalculator.calculateDamage(attacker,defender);

            assertTrue(damage>baseDamage);
        }

    @Test
    public void damageShouldBeIncreased2() {
        Random random = new Random(42L); // Use a fixed seed value

        ModifiedDamageCalculator calculator = new ModifiedDamageCalculator(random);
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
                        .armor(6)
                        .build())
                .build();
        //attacker attack < defender armor
        DefaultDamageCalculator defCalculator = new DefaultDamageCalculator(random);
        int damage = calculator.calculateDamage(attacker, defender);
        int baseDamage = defCalculator.calculateDamage(attacker,defender);

        assertTrue(damage>baseDamage);
    }
}


