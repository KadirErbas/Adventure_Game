import Locations.*;
import Player.Player;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please write your name: ");
        String playerName =  input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hi, "+player.getName());
        System.out.println("If you want to win you need to collect food, wood and water.");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Please pick a character");
        player.selectChar();


        while (true) {
            Location location= null;
            player.info();
            menuView();

            int selectLoc = input.nextInt();
            if(selectLoc == 0) return;
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case  3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please pick valid value!");
            }

            if (!location.onLocation()){
                System.out.println("Game Over");
                break;
            }

        }
    }

    void menuView(){
        System.out.println("Locations:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1 - Safe House - There are no enemies in Safe House and you can restored your health. When you've collected all the items, bring them here.");
        System.out.println("2 - Store - You can buy a weapon or armor in Store.");
        System.out.println("3 - Cave - You can find food in the cave. But be careful there are zombies.");
        System.out.println("4 - Forest - You can find wood in the forest. But be careful there are vampires.");
        System.out.println("5 - River - You can find water in the river. But be careful there are bears.");
        System.out.println("6 - Mine - You can win an award in here randomly(Weapon, armor, money or nothing). But careful there are snakes.");
        System.out.println("0 - Quit the game");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please pick a location to move: ");
        /*
        System.out.println("Where do you want to go?");
        System.out.println("1- Home, you can do your health max");
        System.out.println("2- Shop, you can do buy armors or weapons");
        System.out.println("3 - Locations.Cave   --> [Level 1] battle place");
        System.out.println("4 - Locations.Forest  --> [Level 2] battle place");
        System.out.println("5 - Locations.River  --> [Level 3] battle place");
        System.out.println("0 - Exit");*/
    }

}
