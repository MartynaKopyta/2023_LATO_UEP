package pl.psi.creatures;

import java.util.Random;

class IncreasedDamageCalculator extends AbstractCalculateDamageStrategy {
    private final boolean shouldIncreaseDamage;

    public IncreasedDamageCalculator(final Random rand, final boolean shouldIncreaseDamage) {
        super(rand);
        this.shouldIncreaseDamage = shouldIncreaseDamage;
    }

    @Override
    public int calculateDamage(final Creature attacker, final Creature defender) {
        int damage = super.calculateDamage(attacker, defender);

        if (shouldIncreaseDamage) {
            double increasedDamage = damage * 0.1;
            damage += (int) Math.round(increasedDamage);
        }

        return damage;
    }
}
