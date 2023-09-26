package game;

abstract class Creature {
    protected String name;
    protected int health;
    protected int attack;
    protected int defence;

    Creature(String name, int health, int attack, int defence) {
        if (health <= 0 || attack < 1 || defence < 1 || attack > 30 || defence > 30 || name.isEmpty()) {
            throw new IllegalArgumentException("Некорректные значения параметров: name - не должно быть пустым, health >= 0, 1 <= defence и attack <= 30 ");
        }
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }

    protected void takeDamage(int damage) {
        if (health > 0 ) {
            if (damage > defence) {
                System.out.println(name + " получает " + damage + " урона");
                health -= damage - defence + 1;
            }
            else
                System.out.println("Удар не прошел через броню");
        }
        else
            System.out.println("Cущество " + name + " уже погибло");

    }

    protected abstract void attackCreature(Creature creature, Rollable... dices);


    protected boolean isDied(){
        return health <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }
}
