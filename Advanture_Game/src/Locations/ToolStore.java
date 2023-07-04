package Locations;

import Items.*;
import Player.*;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Welcome To The Store! -------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons\n" +
                    "2 - Armors\n" +
                    "3 - Exit");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Please enter a valid value!");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    // show weapons
    public void printWeapons(){
        System.out.println("--------------------- Weapons ---------------------");
        for (Weapon w : Weapon.weapons()) {
            w.info();
        }
        System.out.println("0 - Exit");
    }
    // show Armors
    public void printArmors(){
        System.out.println("--------------------- Armors ---------------------");
        for (Armor armor : Armor.armors()) {
            armor.info();
        }
        System.out.println("0 - Exit");
    }

    // buy weapon
    public void buyWeapon(){
        System.out.print("Choose: ");
        int selectWeaponID = input.nextInt();
        if (selectWeaponID == 0) return;
        while (selectWeaponID< 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Please enter a valid value!");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if (selectedWeapon != null){
            if (this.getPlayer().getMoney() < selectedWeapon.getPrice()){
                System.out.println("You don't have enough money");
            }else {
                // Satın Alma Gerceklesti
                System.out.println("You bought "+selectedWeapon.getName());
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your Remaining Money: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }else{
            System.out.println("Enter valid ID!");
        }
    }


    public void buyArmor(){
        System.out.print("Choose: ");
        int selectArmorID = input.nextInt();
        if (selectArmorID == 0) return;
        while (selectArmorID< 1 || selectArmorID > Armor.armors().length){
            System.out.println("Please enter a valid value!");
            selectArmorID = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectedArmor != null){
            if (this.getPlayer().getMoney() < selectedArmor.getPrice()){
                System.out.println("You don't have enough money");
            }else {
                // Satın Alma Gerceklesti
                System.out.println("You bought "+selectedArmor.getName());
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your Remaining Money: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }else{
            System.out.println("Please enter a valid ID!");

        }
    }

}
