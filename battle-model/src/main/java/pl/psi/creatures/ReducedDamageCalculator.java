package pl.psi.creatures;

import java.util.Random;

public class ReducedDamageCalculator extends AbstractCalculateDamageStrategy{

    private final boolean shouldReduceDamage;

    public ReducedDamageCalculator(final Random rand, final boolean shouldIncreaseDamage) {
        super(rand);
        this.shouldReduceDamage = shouldIncreaseDamage;
    }

    @Override
    public int calculateDamage(final Creature attacker, final Creature defender) {
        int damage = super.calculateDamage(attacker, defender);

        if (shouldReduceDamage) {
            double reducedDamage = damage * 0.05;
            damage -= (int) Math.round(reducedDamage);
        }

        return damage;
    }
}
