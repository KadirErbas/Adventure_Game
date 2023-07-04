package Locations;

import Player.*;
import Obstacle.*;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Wood",3);
    }
}
