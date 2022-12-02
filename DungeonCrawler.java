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
            case 2: //sword
                System.out.println("You investigate the glimmer..");
                System.out.println("...");
                System.out.println("A sword! You pick it up.");
                user.getSword();
                break;
            case 3: //torch
                System.out.println("You walk towards the flame..");
                System.out.println("...");
                System.out.println("A torch is placed on the wall, you pick it up gratefully.");
                user.getTorch();
                break;
            case 4: //Rope
                System.out.println("You advance towards the coil carefully..");
                System.out.println("...");
                System.out.println("Lying on the ground is a long piece of rope. You grab it and move on.");
                break;
            case 5: //Key
                System.out.println("You walk towards the flame..");
                System.out.println("...");
                System.out.println("A torch is placed on the wall, you pick it up gratefully.");
                break;
            case 6: //Door
                if(user.hasKey() == false)
                {
                    System.out.println("The door stands right in front of you. The spot a silver handle and give it a jiggle....\n No luck, its locked. ");
                }
                else
                {
                    System.out.println("The door is right there in front of you. You see a silver handle and go to turn it...");
                    System.out.println("Locked. Fortunately for you, you have a key. As you insert the key you hear clicks and then turn the handle. The door groans open and you step through.");
                }
                break;
            case 7: //Monster
                if(user.hasSword() == false)
                {
                    System.out.println("Following the blood trails forward, you hear snarling. It grows ever louder as you creep down the way. Then, a creature jumps towards you. Bitng, gnashing, grabbing. The pain its inflicting, it hurits.");
                    System.out.println("There's no way for you to properly fight back. No sword, spear, or weapon on your person. You're helpless to the monster's attacks");
                    System.out.println("You fall to the ground, a bloody, helpless mess. There was nothing you could do...");
                }
                else
                {
                    System.out.println("Following the blood trails forward, you hear snarling. It grows ever louder as you creep down the way");
                    System.out.println("A creature jumps towards you. Using the new sword that you found, you bat it awy after it scratches you.");
                    System.out.println("You make a clean, quick cut at the monster, ending its life swiftly");
                }
                break;
            case 8: //Monster that no like fire
                if(user.hasTorch() == false)
                {
                    System.out.println("Creeping into the blinding darkness makes you uneasy. \n...");
                    System.out.println("The sound of metal cuts through the air and you feel a sharp pain in your chest.");
                    System.out.println("You fall to the ground, not being capable of doing anything but bleeding out slowly to your death.");
                    // add a way to end the game, maybe we just do system.exit?
                }
                else
                {
                    System.out.println("Slowly advancing into the dark tunnel with your torch, you start to hear sounds. Grunting even.");
                    System.out.println("You move towards the sound, ever careful of what could be ahead. Just as you see a glimpse of a monster, you see their face.");
                    System.out.println("It looks scared. Terrified even. You see their eyes focus on the fire and then they just run. They're fast, and the footsteps echo down the tunnel.");
                }
                break;
            case 9: //Trap
                if(user.hasRope() == false)
                {
                    System.out.println("Going to the unstable ground, you walk across it slowly. Testing each step carefully before going further");
                    System.out.println("As you are walking along, you faintly hear cracking, and notice the ground is falling at your feet."); 
                    System.out.println("You try to sprint to where you think the end will be, but fall short, and land in a pit of spikes");
                }
                else
                {
                    System.out.println("Going to the unstable ground, first you tie yourself to a sconce that looks sturdy. Then you walk across it slowly. Testing each step carefully before going further");
                    System.out.println("As you are walking along, you hear cracking. You start sprinting to where you estimate the end to be, but fall short.");
                    System.out.println("Thankfully the rope holds tight and you are suspended above a pit of spikes. You spot loose bricks near you and start to climb up the wall towards the other end of the pit. Not once stopping to looking below you");
                }
                break;
            case 10: //Start point
                System.out.println("You remember this place. This is where you started. Though where will you go next?");
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