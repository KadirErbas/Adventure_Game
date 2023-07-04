package Locations;


import Items.*;
import Obstacle.*;
import Player.*;
import java.util.Random;
import Locations.*;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }
    public boolean combat(int obsNumber){
        for (int i = 1; i <= obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealth() > 0){
                System.out.println("<F> fight or <R> run: ");
                String selectCombat= Location.input.nextLine().toUpperCase();
                if(selectCombat.equals("F")){
                    System.out.println("You hit it!!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("The obstacle hit you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0 ){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You Defeated The Enemies!");
                System.out.println("Your earned "+this.getObstacle().getAward()+" money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Now, You have: "+ this.getPlayer().getMoney() + " money!");
            }else{
                System.out.println("You Lost!");
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Health: "+ this.getObstacle().getHealth());

    }
    public void playerStats(){
        System.out.println(
                "Player Status\n"+
                "---------------------------------------\n"+
                "Health: "+this.getPlayer().getHealth()+"\n"+
                "Weapon: "+this.getPlayer().getInventory().getWeapon().getName()+"\n"+
                "Damage: "+ this.getPlayer().getTotalDamage()+"\n" +
                "Armor: "+ this.getPlayer().getInventory().getArmor().getName()+"\n"+"" +
                "Block: "+this.getPlayer().getInventory().getArmor().getBlock()+"\n"+
                "Money: "+this.getPlayer().getMoney()
        );
        System.out.println();
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+
                this.getObstacle().getName()+" Status\n"+
                "------------------------------\n"+
                "Health: "+this.getObstacle().getHealth()+"\n"+
                "Damage: "+this.getObstacle().getDamage()+"\n"+
                "Money Award: "+this.getObstacle().getAward()
        );
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are in "+ this.getName());
        System.out.println("Be Careful! There are "+ obsNumber +" " +this.getObstacle().getName()+" in here.");
        System.out.println("<F> fight or <R> run: ");
        String selectCase = Location.input.nextLine().toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)){
                System.out.println("You defeated all the enemies in the "+ this.getName());
            System.out.println("Your award is some "+this.getAward());
                this.getPlayer().getInventory().addAward(this.getAward());
                return true;
        }
        if (this.getPlayer().getHealth() < 0){
            System.out.println("You Died!");
            return false;
        }
        return true;
    }
    public  int randomObstacleNumber(){
        Random r= new Random();

        return r.nextInt(1,this.getMaxObstacle()+1);
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
