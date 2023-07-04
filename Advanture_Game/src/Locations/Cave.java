package Locations;

import Player.*;
import Obstacle.*;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3);
    }
}
