package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int minHealth = 1000000000;
        int maxHealth = 0;
        BattleUnit unitWithMinHealth = null;
        BattleUnit unitWithMaxHealth = null;

        for(int i = 0; i < ownTeam.length; i++){
            if(ownTeam[i].health() < minHealth && ownTeam[i].health() > 0){
                minHealth = ownTeam[i].health();
                unitWithMinHealth = ownTeam[i];
            }
            else if(ownTeam[i].health() > maxHealth && ownTeam[i].health() > 0){
                unitWithMaxHealth = ownTeam[i];
                maxHealth = ownTeam[i].health();
            }
        }

        unitWithMinHealth.heal(10);
        unitWithMaxHealth.setStrength(unitWithMaxHealth.strength()+1);

    }

    @Override
    public void attack(BattleUnit other) {
        other.setStrength(other.strength()-2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
