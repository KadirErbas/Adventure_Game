package Locations;
import Player.*;
public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }
    @Override
    public boolean onLocation(){
        if(control()){
            System.out.println("Congratulations, You Won!!");
            return false;
        }
        System.out.println("You are in the safe house. Your healthy is updated");
        getPlayer().setHealth(getPlayer().getOriginalHealth());
        return true;
    }
    boolean control(){
        if(this.getPlayer().getInventory().getAwards().size()>=3){
            return true;
        }
        return false;
    }

}
