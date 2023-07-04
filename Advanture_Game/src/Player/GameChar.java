package Player;

public abstract class GameChar {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int money;

    GameChar(int id, String name,int damage, int health, int money){
        this.id = id;
        this.name=name;
        this.damage=damage;
        this.health=health;
        this.money=money;

    }


    protected void info(){
        //System.out.printf("%-2s | %-9s | %-6s | %-7s | %-5s |\n",  this.damage, this.health, this.money);
        System.out.printf("%-2s | %-9s | %-6s |\n",  this.damage, this.health, this.money);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
