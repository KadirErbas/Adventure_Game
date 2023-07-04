package Items;

public class Armor extends Item {

    private int block;

    public Armor(String name, int id, int block, int price){
        super(name,id,price);
        this.block = block;
    }

    public static Armor[] armors(){
        Armor[] armorsList = new Armor[3];
        armorsList[0]= new Armor("Light",1,1,15);
        armorsList[1]= new Armor("Medium",2,3,25);
        armorsList[2]= new Armor("Heavy",3,5,40);
        return armorsList;
    }
    public void info(){
        System.out.printf("%-2s- Name: %-9s |Armor: %-6s |Price: %-7s |\n",this.getId() , this.getName(), this.block ,this.getPrice());
    }

    public static Armor getArmorObjByID(int id){
        Armor[] armors = armors();
        for (Armor armor: armors) {
            if (armor.getId() == id){
                return armor;
            }
        }
        return null;
    }
    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
