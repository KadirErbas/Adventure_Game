package Locations;

import Items.Armor;
import Items.Weapon;
import Obstacle.Obstacle;
import Player.Player;
import Obstacle.*;

import java.util.Random;

public class Mine extends  BattleLoc{
    public Mine(Player player) {
        super(player, "Mine", new Snake(), null, 5);
    }

    @Override
    public boolean combat(int obsNumber) {
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
                mineAward();
            }else{
                System.out.println("You Lost!");
                return false;
            }
        }
        return true;
    }

    public void mineAward(){
        Random random= new Random();

        int categoryChance  = random.nextInt(0,100);
        int weaponTypeChance = random.nextInt(0,100);
        int armorTypeChance = random.nextInt(0,100);
        int moneyAmountChance = random.nextInt(0,100);

        //Money(25%)
        if(0<=categoryChance && categoryChance<=24){

            if(0<=moneyAmountChance && moneyAmountChance<=19){
                //10(20%)
                System.out.println("You won 10 coin!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            } else if (20<=moneyAmountChance && moneyAmountChance<=49) {
                //5(30%)
                System.out.println("You won 5 coin!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            }else{
                //1(50%)
                System.out.println("You won 1 coin!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            }

        }
        //Weapon(15%)
        else if (25<=categoryChance && categoryChance<=39) {
            if(1<=weaponTypeChance && weaponTypeChance<=19){
                //Rifle(20%)
                System.out.println("You won a rifle!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));

            }else if(20<=weaponTypeChance && weaponTypeChance<=49){
                //Sword(30%)
                System.out.println("You won a sword!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
            }else{
                //Gun(50%)
                System.out.println("You won a gun!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
            }
        }
        //Armor(15%)
        else if (40<=categoryChance && categoryChance<=54) {

            if(1<=armorTypeChance && armorTypeChance<=19){
                //Heavy armor(20%)
                System.out.println("You won a heavy armor!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
            }else if(20<=armorTypeChance && armorTypeChance<=49){
                //Medium armor(30%)
                System.out.println("You won a medium armor!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
            }else{
                //Light armor(50%)
                System.out.println("You won a light armor!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
            }

        }
        //Nothing(45%)
        else {
            System.out.println("You couldn't get an award from Mine :(");
        }

    }

}
