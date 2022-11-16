import java.io.File;
import java.util.Scanner;
public class DungeonMap{
    static int[][] map = new int[6][8];
    public static int[][] readMap(){
        File mapFile = new File("./maps/dungeon.txt");
        Scanner mapInput;
        try{
            mapInput = new Scanner(mapFile);
        } catch (Exception e) {
            System.out.println("Could not find file.");
            int[][] dead = new int[0][0];
            return dead;
        }
        for (int i = 0; i<6; i++){
            int[] currentRow = new int[8];
            String[] data = mapInput.nextLine().split(",");
            for (int j = 0; j < 8; j++){
                currentRow[j] = Integer.parseInt(data[j]);
            }
            map[i] = currentRow;
        }
        
        for (int i = 0; i < 6; i++){
            for (int j=0;j<8;j++){
                System.out.printf("%d",map[i][j]);
            }
            System.out.println();
        }
        mapInput.close();
        return map;
    }
    
    public static void checkPos(int x, int y){
        if (map[y][x-1] == 1){
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
    
    public static void main(){
        readMap();
        checkPos(3,3);
    }
}