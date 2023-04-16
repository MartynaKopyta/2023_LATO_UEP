package pl.psi.creatures;

import java.util.Random;

public class IncreaseBaseDamage extends AbstractCalculateDamageStrategy{

    private final boolean shouldIncreaseBaseDamage;
    protected IncreaseBaseDamage(final Random aRand, final boolean shouldIncreaseDamage) {
        super(aRand);
        this.shouldIncreaseBaseDamage = shouldIncreaseDamage;
    }

    @Override
    protected int calculateBaseDamage(Creature aAttacker, Creature aDefender) {
        int baseDamage = super.calculateBaseDamage(aAttacker, aDefender);
        if(shouldIncreaseBaseDamage){
            return baseDamage + (int)Math.round(baseDamage*0.1);
        }
        return baseDamage;
    }
}
