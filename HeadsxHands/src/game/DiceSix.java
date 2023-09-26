package game;

public class DiceSix implements Rollable {
    private int value;

    @Override
    public void roll() {
        value = (int)(Math.random() * 6+1);
    }

    @Override
    public boolean isSuccessfully() {
        return value > 4;
    }

    public int getValue() {
        return value;
    }

}
