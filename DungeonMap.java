import java.io.File;
import java.util.Scanner;
public class DungeonMap{
    static int[][] map;
    static int width,height;
    
    // 0 = dead end, 1 = passageway, 2 = sword, 3 = torch, 4 = rope, 5 = key
    // 6 = door, 7 = monster, 8 = monster thats scared of fire 9 = pitfall trap
    // 10 = i forget what goes here
    
    public static int[][] readMap(){
        //File mapFile = new File("./maps/dungeon.txt");
        //File mapFile = new File("./maps/dungeon2.txt");
        //File mapFile = new File("./maps/dungeon3.txt");
        File mapFile = new File("./maps/dungeon4.txt");
        Scanner mapInput;
        try{
            mapInput = new Scanner(mapFile);
        } catch (Exception e) {
            System.out.println("Could not find file.");
            int[][] dead = new int[0][0];
            return dead;
        }
        String[] data = mapInput.nextLine().split(",");
        width = Integer.parseInt(data[0]);
        height= Integer.parseInt(data[1]);
        map = new int[height][width];
        for (int i = 0; i<height; i++){
            int[] currentRow = new int[width];
            data = mapInput.nextLine().split(",");
            for (int j = 0; j < width; j++){
                currentRow[j] = Integer.parseInt(data[j]);
            }
            map[i] = currentRow;
        }
        
        mapInput.close();
        return map;
    }
    
    public static void printMap(){
        for (int i = 0; i < height; i++){
            for (int j=0;j<width;j++){
                System.out.printf("%d",map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void pitfallTrapPos(int x, int y){
        boolean North, South, East, West = false; 
        if (map[y][x-1] == 9){
            System.out.println("There is a trap to the WEST");
        }
        if (map[y][x+1] == 9){
            System.out.println("There is a trap to the EAST");
        }
        if (map[y-1][x] == 9){
            System.out.println("There is a trap to the NORTH");
        }
        if (map[y+1][x] == 9){
            System.out.println("There is a trap to the SOUTH");
        }
    }
    
    public void swordPos(int x, int y){
        boolean North, South, East, West = false; 
        boolean sword = true;
        if (map[y][x] == 2 ){
            System.out.println("You find a sword lying about");
            DungeonCrawler.setSword(sword); 
        }
    }
    
    public static void checkPos(int x, int y){
        boolean North, South, East, West = false; 
        if (map[y][x] == 1){
            System.out.println("There is a passage to the WEST");
        }
        if (map[y][x+1] == 1){
            System.out.println("There is a passage to the EAST");
        }
        if (map[y-1][x] == 1){
            System.out.println("There is a passage to the NORTH");
        }
        if (map[y+1][x] == 1){
            System.out.println("There is a passage to the SOUTH");
        }
    }
}