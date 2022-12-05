import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;

public class DungeonMap{
    static int[][] map;
    static int width,height;
    static int startingX, startingY;

    // 0 = dead end, 1 = passageway, 2 = sword, 3 = torch, 4 = rope, 5 = key
    // 6 = door, 7 = monster, 8 = monster thats scared of fire 9 = pitfall trap
    // 10 = start point

    public DungeonMap(String pathName){
        startingX = startingY = -1;
        readMap(pathName);
    }
    
    public static int[][] readMap(String pathName){
        //File mapFile = new File("./maps/dungeon.txt");
        //File mapFile = new File("./maps/dungeon2.txt");
        //File mapFile = new File("./maps/dungeon3.txt");
        //File mapFile = new File("./maps/dungeon4.txt");
        File mapFile = new File(pathName);
        Scanner mapInput = null;
        try{
            mapInput = new Scanner(mapFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file.");
            System.exit(-1);
        }
        String[] data = mapInput.nextLine().split(",");
        width = Integer.parseInt(data[0]);
        height= Integer.parseInt(data[1]);
        map = new int[height][width];
        for (int i = 0; i<height; i++){
            int[] currentRow = new int[width];
            data = mapInput.nextLine().split(",");
            for (int j = 0; j < width; j++){
                int mapTile = Integer.parseInt(data[j]);
                currentRow[j] = mapTile;
                if (mapTile == 10){
                    startingX = j;
                    startingY = i;
                }
            }
            map[i] = currentRow;
        }

        mapInput.close();
        return map;
    }

    public static void printMap(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.printf("%d",map[i][j]);
            }
            System.out.println();
        }
    }

    public static void printDirection(int value, String dirName){
        switch (value){
            case 1: //Passageway
                System.out.printf("There is a passage to the %s%n",dirName);
                break;
            case 2: //Sword
                System.out.printf("%s of you, there's a glimmer in the dark.%n",dirName);
                break;
            case 3: //Torch
                System.out.printf("%s of you, you spot a lick of a flame.%n", dirName);
                break;
            case 4: //Rope
                System.out.printf("To the %s of you, a coil of something catches your attention.%n", dirName);
                break;
            case 5: //Key
                System.out.printf("As you were walking by, you see a blink of something shiny to your %s.%n", dirName);
                break;
            case 6: //Door
                System.out.printf("Ahead of you to the %s, an old door stands there.%n", dirName);
                break;
            case 7: //Monster
                System.out.printf("Down the passageway to the %s, blood spots the stones down the way.%n", dirName);
                break;
            case 8: //Monster that no like fire
                System.out.printf("A terrible smell comes from the dark tunnel %sward.%n", dirName); 
                break;
            case 9: //Trap
                System.out.printf("The ground to the %s looks unstable.%n",dirName);
                break;
            case 10: //start point
                System.out.printf("The place from the %s is where you started from%n", dirName);
                break;
            default:
                break;
        }
    }

    public static void removeMapElement(Player user){
        map[user.getY()][user.getX()] = 1;
    }

    public static int checkNorth(Player user){
        try {
            return (map[user.getY()-1][user.getX()]);
        } catch (ArrayIndexOutOfBoundsException e){
            return 0;
        }
    }

    public static int checkSouth(Player user){
        try {
            return (map[user.getY()+1][user.getX()]);
        } catch (ArrayIndexOutOfBoundsException e){
            return 0;
        }
    }

    public static int checkEast(Player user){
        try {
            return (map[user.getY()][user.getX()+1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public static int checkWest(Player user){
        try {
            return (map[user.getY()][user.getX()-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public static int checkCurrent(Player user){
        try {
            return (map[user.getY()][user.getX()]);
        } catch (ArrayIndexOutOfBoundsException e){
            return 0; // SHOULD NEVER HAPPEN
        }
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }

    public static int getStartingX(){
        return startingX;
    }
    public static int getStartingY(){
        return startingY;
    }
}