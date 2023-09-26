package game;

public class Player extends Creature {
    private int maxHealth;
    private int healCount;

   public Player(String heroName, int health, int attack, int defence) {
        super(heroName, health, attack, defence);
        maxHealth = health;
        healCount = 0;
    }

    public void heal() {
        if (healCount < 4) {
            super.health += maxHealth * 0.3;
            System.out.println(super.name + " лечится на " + maxHealth * 0.3 + " здоровья");
            if (maxHealth < super.health)
                super.health = maxHealth;
            healCount += 1;
        } else {
            System.out.println("Лекарства закончились, Милорд!");
        }
    }

    @Override
    public void attackCreature(Creature creature, Rollable... dices) {
        int damageScale = 1;
        if (!creature.isDied()) {
            if (!this.isDied()) {
                for (Rollable r :
                        dices) {
                    r.roll();
                    if (r.isSuccessfully()) {
                        System.out.println(name +": " +r.getValue() + " - удачный бросок" );
                        damageScale += 1;
                    } else
                        System.out.println(name +": " +r.getValue() + " - бросок неудачный");
                }
                creature.takeDamage(attack * (damageScale - 1));
            } else
                System.out.println("Существо " + name + " не может атаковать, оно уже мертво");
        } else
            System.out.println("Существо c именем " + creature.getName() + " уже погибло");

    }

}
