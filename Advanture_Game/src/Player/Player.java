package Player;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private int originalHealth;

    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name= name;
        this.inventory= new Inventory();

    }


    public void selectChar(){

        GameChar[] charList= {new Samurai(),new Archer(),new Knight()};

        System.out.println("--------------------------------------------------------------------");

        for (GameChar gameChar:charList) {
           // System.out.println("Karakter:" + gameChar.getName()+"\t Hasar: "+gameChar.getDamage()+"\t Sağlık: "+gameChar.getHealth()+"\t Para: "+gameChar.getMoney());
            System.out.printf("ID: %-3s |Character: %-8s |Damage: %-3s |Health: %-3s |Money: %-3s |\n", gameChar.getId(), gameChar.getName(), gameChar.getDamage(), gameChar.getHealth(), gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------------");

        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:initPlayer(new Samurai()); break;
            case 2:initPlayer(new Archer()); break;
            case 3:initPlayer(new Knight()); break;
            default: initPlayer(new Samurai());
        }
    }
    public void info(){
        System.out.printf("Character: %-4s |Armor: %-6s|Block: %-2s |Weapon: %-3s |Damage: %-3s |Health: %-3s |Money: %-3s |\n", this.charName,this.getInventory().getArmor().getName() ,this.getInventory().getArmor().getBlock(),this.getInventory().getWeapon().getName(),this.getTotalDamage(), this.getHealth(), this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setOriginalHealth(gameChar.getHealth());
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getTotalDamage(){return damage + inventory.getWeapon().getDamage();};
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) health=0;
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

