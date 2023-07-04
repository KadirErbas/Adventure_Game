package Player;

import Items.*;
import java.util.ArrayList;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private ArrayList awards = new ArrayList();

    public Inventory() {
        this.weapon = new Weapon("Punch",-1,0,0);
        this.armor = new Armor("None",-1,0,0);
    }

    public ArrayList getAwards() {
        return awards;
    }


    //add if reward is not available
    public void addAward(String award){
        boolean isAvailable = false;
        for (Object a:getAwards()) {
            if(a.equals(award)){
                isAvailable = true;
            }
        }
        if(!isAvailable)  awards.add(award);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}