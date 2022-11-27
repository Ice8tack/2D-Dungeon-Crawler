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

    public static void printDirection(int value, String dirName){
        switch (value){
            case 1: //Passageway
                System.out.printf("There is a passage to the %s%n",dirName);
                break;
            case 2: //Sword
                System.out.printf("%s of you, a glimmer in the dark.%n",dirName);
                break;
            case 9: //Trap
                System.out.printf("The ground to the %s looks unstable.%n",dirName);
                break;
        }
    }

    public static int checkNorth(Player user){
        return (map[user.getY()-1][user.getX()]);
    }

    public static int checkSouth(Player user){
        return (map[user.getY()+1][user.getX()]);
    }

    public static int checkEast(Player user){
        return (map[user.getY()][user.getX()+1]);
    }

    public static int checkWest(Player user){
        return (map[user.getY()][user.getX()-1]);
    }
    
    public static int checkCurrent(Player user){
        return (map[user.getY()][user.getX()]);
    }
}