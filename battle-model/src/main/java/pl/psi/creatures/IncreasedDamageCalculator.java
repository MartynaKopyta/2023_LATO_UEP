package pl.psi.creatures;

import java.util.Random;

class IncreasedDamageCalculator extends AbstractCalculateDamageStrategy implements DamageCalculatorIf{

    public IncreasedDamageCalculator(final Random rand) {
        super(rand);
    }

    @Override
    public int calculateDamage(final Creature aAttacker, final Creature aDefender)
    {
        final int armor = getArmor( aDefender );

        final int randValue = rand.nextInt( aAttacker.getDamage()
                .upperEndpoint()
                - aAttacker.getDamage()
                .lowerEndpoint()
                + 1 ) + aAttacker.getDamage()
                .lowerEndpoint();

        double oneCreatureDamageToDeal;
        if( aAttacker.getAttack() >= armor )
        {
            int attackPoints = aAttacker.getAttack() - armor;
            if( attackPoints > MAX_ATTACK_DIFF )
            {
                attackPoints = MAX_ATTACK_DIFF;
            }
            oneCreatureDamageToDeal = randValue * (1 + attackPoints * ATTACK_BONUS + increaseDamageBy());
        }
        else
        {
            int defencePoints = armor - aAttacker.getAttack();
            if( defencePoints > MAX_DEFENCE_DIFF )
            {
                defencePoints = MAX_DEFENCE_DIFF;
            }
            oneCreatureDamageToDeal = (randValue * (1 - defencePoints * DEFENCE_BONUS)) * (1 + increaseDamageBy());
        }

        if( oneCreatureDamageToDeal < 0 )
        {
            oneCreatureDamageToDeal = 0;
        }
        return (int)(aAttacker.getAmount() * oneCreatureDamageToDeal);
    }

    private double increaseDamageBy() {
        return 0.1;
    }
}
