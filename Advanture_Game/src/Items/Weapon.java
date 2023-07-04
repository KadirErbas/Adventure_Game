package Items;

public class Weapon extends Item {

    private int damage;

    public Weapon(String name, int id, int damage, int price){
        super(name, id, price);
        this.damage=damage;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0]= new Weapon("Gun",1,2,25);
        weaponList[1]= new Weapon("Sword",2,3,35);
        weaponList[2]= new Weapon("Rifle",3,7,45);
        return weaponList;
    }
    public void info(){
        System.out.printf("%-2s- Name: %-9s |Damage: %-3s |Price: %-3s |\n",this.getId() , this.getName(), this.damage ,this.getPrice());
    }
    public static Weapon getWeaponObjByID(int id){
        Weapon[] weaponList = weapons();
        for (Weapon weapon:weaponList) {
            if (weapon.getId() == id){
                return weapon;
            }
        }
        return null;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
