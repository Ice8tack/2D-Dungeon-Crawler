public class Player
{
    private int x,y,north,south,east,west,score;
    private boolean sword, torch, rope, key, exit, gauntlet;

    public Player (DungeonMap map){
        sword = torch = rope = key = exit = gauntlet = false;
        score = 0;
        x = map.getStartingX();
        y = map.getStartingY();
    }

    public void checkPosition(DungeonMap map){
        north = map.checkNorth(this);
        south = map.checkSouth(this);
        east = map.checkEast(this);
        west = map.checkWest(this);

        map.printDirection(north,"North");
        map.printDirection(south,"South");
        map.printDirection(east,"East");
        map.printDirection(west,"West");
    }

    public void move(String input){
        //check where you're at
        input = input.toLowerCase();
        switch (input){
            case ("north"):
                if (north > 0){
                    y--;
                }
                break;
            case ("south"):
                if (south > 0){
                    y++;
                }
                break;
            case ("east"):
                if (east > 0){
                    x++;
                }
                break;
            case ("west"):
                if (west > 0){
                    x--;
                }
                break;
            case ("exit"):
                exit = true;
                printGameOverMessage();
                break;
            default:
                System.out.println("What?");
                break;
        }
        //check if occupied
    }

    public void newGamePlus(DungeonMap map){
        sword = torch = rope = key = exit = gauntlet = false;
        x = map.getStartingX();
        y = map.getStartingY();
    }
    
    public void printWinMessage(){
        System.out.printf("Congratulations! You escaped the dungeon with %d points!%n",score);
    }
    
    public void printGameOverMessage(){
        System.out.printf("Game over! You failed to escape with %d points. Try again?",score);
    }
    
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean hasSword()
    {
        return sword;
    }

    public void getSword()
    {
        this.sword = true; 
    }

    public boolean hasTorch()
    {
        return torch;
    }

    public void getTorch()
    {
        this.torch = true; 
    }

    public boolean hasRope()
    {
        return rope;
    }

    public void getRope()
    {
        this.rope = true; 
    }

    public boolean hasKey()
    {
        return key;
    }

    public void getKey()
    {
        this.key = true; 
    }
    
    public boolean hasGauntlet()
    {
        return gauntlet;
    }

    public void getGauntlet()
    {
        this.gauntlet = true; 
    }

    public int xPos()
    {
        return x;
    }

    public int yPos()
    {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setExit(boolean exit){
        this.exit = exit;
    }

    public boolean getExit(){
        return exit;
    }
    
    public void increaseScore(int x){
        score += x;
    }
}
