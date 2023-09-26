package game;

public class Monster extends Creature {
    private int minDamage, maxDamage;

    public Monster(String monsterName, int health, int attack, int defence, int mindDamage, int maxDamage) {
        super(monsterName, health, attack, defence);
        this.minDamage = mindDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public void attackCreature(Creature creature, Rollable... dices) {
        if (!creature.isDied()) {
            if (!this.isDied()) {
                for (Rollable r :
                        dices) {
                    r.roll();
                    if (r.isSuccessfully()) {
                        System.out.println(name +": " +r.getValue() +" - удачный бросок ");
                        creature.takeDamage((int) (Math.random() * (maxDamage - minDamage) + 1));
                    } else
                        System.out.println(name +": " +r.getValue() + " - бросок был неудачным");
                }

            } else
                System.out.println("Существо " + name + " не может атаковать, оно уже мертво");
        } else
            System.out.println("Существо c именем " + creature.name + " уже погибло");
    }

}
