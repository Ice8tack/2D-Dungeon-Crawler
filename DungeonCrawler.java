import java.util.Scanner;
public class DungeonCrawler{
    boolean sword, torch, rope, key; 
    //might need more items later
    //obstacles: monster to attack, door, pitfall, monster that is scared of fire
    //obstacles are set in the map
    int x, y; //global 

    //make a method that keeps track of x and y, and possibly work on movement
    
    public static void main(String[] args){
        DungeonMap map = new DungeonMap();
        map.readMap();
        map.printMap();
        checkPosLoop(map);
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
}