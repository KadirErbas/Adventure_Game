package Obstacle;


import Player.Player;

public class Snake extends  Obstacle{
    public Snake() {
        super(4, "Snake", 6, 12, 0);
    }

    @Override
    public int getDamage() {
        int randomDamage = (int) (Math.random()*super.getDamage()+1);
        return randomDamage;
    }



}
