public class Player
{
    private int x,y,north,south,east,west;
    private boolean sword, torch, rope, key = false;

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

    public void updateXnY(int[] arr)
    {
        x = DungeonMap.readMap().indexOf(10, 1);
        //take start point, get x and y of start point, print x and y
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
    
    public int xPos()
    {
        return x;
    }
    
    public int yPos()
    {
        return y;
    }
}
