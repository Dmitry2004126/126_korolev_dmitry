package task;

public abstract class  BattleUnitBase implements BattleUnit{
    int maxHealth;
    int baseStrength;
    int maxArmor;
    int health;
    int strength;
    int armor;
    String name;

    BattleUnitBase(String name, int maxHealth , int baseStrength, int maxArmor ){
        this.name =name;
        this.maxHealth =maxHealth;
        this.baseStrength=baseStrength;
        this.maxArmor=maxArmor;
        health=maxHealth;
        strength=baseStrength;
        armor=maxArmor;
    }
    public String name(){
        return name;
    }
    public int health(){
        return health;
    }
    public int maxHealth(){
        return maxHealth;
    }
    public void setMaxHealth(int value){
        if(value < 0) {
            maxHealth = 0;
        }else {
            maxHealth = value;
        }
        if(health > maxHealth)
            health = maxHealth;

    }
    public void heal(int value){
        if(health + value > maxHealth) {
            health = maxHealth;
        }
        else {
            health= health+ value;
        }

    }
    public void takeDamage(int value){
        if(health - value < 0) {
            health = 0;
        }
        else {
            health= health-value;
        }

    }
    public int strength() {
        return strength;
    }
    public void setStrength(int value){
        strength = value;
    }
    public int baseStrength(){
        return baseStrength;
    }
    public int armor(){
        return armor;
    }
    public void restoreArmor(int value){
        if(armor + value > maxArmor)
            armor = maxArmor;
        else
            armor= armor+ value;
    }
    public void damageArmor(int value){
        if(armor - value < 0) {
            armor = 0;
        }
        else {
            armor= armor-value;
        }

    }
    public int maxArmor(){
        return maxArmor;
    }
    public void setMaxArmor(int value){
        maxArmor = value;
        if(armor > maxArmor)
            armor = maxArmor;
    }
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);
}
