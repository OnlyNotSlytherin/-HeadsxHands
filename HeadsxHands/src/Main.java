import game.*;

public class Main {
    public static void main(String[] args) {
        Rollable d1 = new DiceSix();
        Rollable d2 = new DiceSix();
        Player h1 = new Player("Геральт",12, 4, 4);
        Monster m1 = new Monster("Вурдалак", 5, 20, 1, 1, 7);
        h1.attackCreature(m1, d1, d2);
        m1.attackCreature(h1, d1);
        m1.attackCreature(h1, d1);
        h1.attackCreature(m1, d1);
        m1.attackCreature(h1, d1);
    }
}