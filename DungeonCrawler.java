import java.util.Scanner;
public class DungeonCrawler{
    //might need more items later
    //obstacles: monster to attack, door, pitfall, monster that is scared of fire
    //obstacles are set in the map
    private int x, y; //global 

    //make a method that keeps track of x and y, and possibly work on movement
    
    public static void main(String[] args){
        DungeonMap map = new DungeonMap();
        map.readMap();
        map.printMap();
        checkPosLoop(map);
    }
    
    public static void checkRoom(DungeonMap map,Player user){
        switch (map.checkCurrent(user)){
            case 2:
                System.out.println("You investigate the glimmer..");
                System.out.println("...");
                System.out.println("A sword! You pick it up.");
                user.getSword();
                break;
            case 3: 
                System.out.println("You walk towards the flame..");
                System.out.println("...");
                System.out.println("A torch is placed on the wall, you pick it up gratefully.");
                user.getTorch();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                break;
        }
    }
    
    public static void checkPosLoop(DungeonMap map){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("X?");
            int x = input.nextInt();
            System.out.println("Y?");
            int y = input.nextInt();
            if (x == 99 && y == 99){
                break;
            } else {
                map.checkPos(x,y);
            }
        }
        input.close();
    } 
    
    public void DungeonObstacles(){
        String monster; 
        String scaredOfFireMon; 
        
        /*if(sword)
        {
            System.out.print("You picked up a sword");
        }*/
        
    }
    
    
}