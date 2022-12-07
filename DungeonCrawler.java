import java.util.Scanner;
public class DungeonCrawler{
    //might need more items later
    //obstacles: monster to attack, door, pitfall, monster that is scared of fire
    //obstacles are set in the map

    public static void main(String[] args){
        System.out.println("Welcome to Dungeon Crawl! Please enter the name of the dungeon you would like to use (Included in the maps folder)");
        Scanner input = new Scanner(System.in);
        String mapFile = "./maps/" + input.nextLine() + ".txt";
        input.close();
        DungeonMap map = new DungeonMap(mapFile);
        Player user = new Player(map);
        if (user.getX() == -1 || user.getY() == -1){
            System.out.println("Map has no starting position.");
            System.exit(-1);
        }
        //map.printMap();
        checkPosLoop(map, user);
        while (user.hasKey()){
            System.out.println("You find yourself in another dungeon! Please enter the name of the dungeon you would like to use (Included in the maps folder)");
            input = new Scanner(System.in);
            mapFile = String.format("./maps/%s.txt",input.nextLine());
            input.close();
            map = new DungeonMap(mapFile);
            user.newGamePlus(map);
            if (user.getX() == -1 || user.getY() == -1){
                System.out.println("Map has no starting position.");
                System.exit(-1);
            }
            //map.printMap();
            checkPosLoop(map, user);
        }
    }

    public static void checkRoom(DungeonMap map,Player user){
        switch (map.checkCurrent(user)){
            case 2: //sword
                System.out.println("You investigate the glimmer..");
                System.out.println("...");
                System.out.println("A sword! You pick it up.");
                user.getSword();
                map.removeMapElement(user);
                user.increaseScore(5);
                break;
            case 3: //torch
                System.out.println("You walk towards the flame..");
                System.out.println("...");
                System.out.println("A torch is placed on the wall, you pick it up gratefully.");
                user.getTorch();
                map.removeMapElement(user);
                user.increaseScore(5);
                break;
            case 4: //Rope
                System.out.println("You advance towards the coil carefully..");
                System.out.println("...");
                System.out.println("Lying on the ground is a long piece of rope. You grab it and move on.");
                user.getRope();
                map.removeMapElement(user);
                user.increaseScore(5);
                break;
            case 5: //Key
                System.out.println("Progressing towards the shine slowly you..");
                System.out.println("...");
                System.out.println("find a key, laying down a the ground. Its attached to some string.");
                user.getKey();
                map.removeMapElement(user);
                user.increaseScore(5);
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
                    user.setExit(true);
                    user.increaseScore(30);
                    user.printWinMessage();
                }
                break;
            case 7: //Monster
                if(user.hasSword() == false)
                {
                    System.out.println("Following the blood trails forward, you hear snarling. It grows ever louder as you creep down the way. Then, a creature jumps towards you. Bitng, gnashing, grabbing. The pain its inflicting, it hurts.");
                    System.out.println("There's no way for you to properly fight back. No sword, spear, or weapon on your person. You're helpless to the monster's attacks");
                    System.out.println("You fall to the ground, a bloody, helpless mess. There was nothing you could do...");
                    user.setExit(true);
                    user.printGameOverMessage();
                }
                else
                {
                    System.out.println("Following the blood trails forward, you hear snarling. It grows ever louder as you creep down the way");
                    System.out.println("A creature jumps towards you. Using the sword that you found, you bat it away after it scratches you.");
                    System.out.println("The monster's skull crumples, ending its life swiftly");
                    map.removeMapElement(user);
                    user.increaseScore(15);
                }
                break;
            case 8: //Monster that no like fire
                if(user.hasTorch() == false)
                {
                    System.out.println("Creeping into the blinding darkness makes you uneasy. \n...");
                    System.out.println("The sound of metal cuts through the air and you feel a sharp pain in your chest.");
                    System.out.println("You fall to the ground, not being capable of doing anything but bleeding out slowly to your death.");
                    user.setExit(true);
                    user.printGameOverMessage();
                }
                else
                {
                    System.out.println("Slowly advancing into the dark tunnel with your torch, you start to hear sounds. Grunting even.");
                    System.out.println("You move towards the sound, ever careful of what could be ahead. Just as you see a glimpse of a monster, you see their face.");
                    System.out.println("It looks scared. Terrified even. You see their eyes focus on the fire and then they just run. They're fast, and the footsteps echo down the tunnel.");
                    map.removeMapElement(user);
                    user.increaseScore(15);
                }
                break;
            case 9: //Trap
                if(user.hasRope() == false)
                {
                    System.out.println("Going to the unstable ground, you walk across it slowly. Testing each step carefully before going further");
                    System.out.println("As you are walking along, you faintly hear cracking, and notice the ground is falling at your feet."); 
                    System.out.println("You try to sprint to the end but fall short and land in a pit of spikes");
                    user.setExit(true);
                    user.printGameOverMessage();
                }
                else
                {
                    System.out.println("Going to the unstable ground, first you tie yourself to a sconce that looks sturdy. Then you walk across it slowly. Testing each step carefully before going further");
                    System.out.println("As you are walking along, you hear cracking. You start sprinting to where you estimate the end to be, but fall short.");
                    System.out.println("Thankfully the rope holds tight and you are suspended above a pit of spikes. You spot loose bricks near you and start to climb up the wall towards the other end of the pit. Not once stopping to looking below you");
                }
                break;
            case 10: //Start point
                System.out.println("This is the beginning. You're not sure how you got here. Remembering nothing but a faint voice...\n\"Go forward, push through adversity\"");
                break;
            case 11: //guantlet
                System.out.println("Moving towards the pedestal you spot a gauntlet resting on it. You go to grab it...");
                System.out.println("Picking up the gauntlet you find that its light and lets out a strange hum. Unsure of its power you don the gauntlet and move ahead.");
                user.getGauntlet();
                map.removeMapElement(user);
                user.increaseScore(5);
                break;
            case 12: //wight;
                if(user.hasGauntlet() == false)
                {
                    System.out.println("An undead creature limps toward you, striking out with a sword. You match it with yours and go for a killing blow.");
                    System.out.println("However this creature is faster than you, parrying your attack and striking you with its sword. Then it puts it's claws into your chest. It starts to feed off of your skin");
                    System.out.println("You're stunned, and slowly it feasts upon you, devouring it gratefully. You fall to the ground, lifeless. \nThen a few minutes later, your rise again, but not as yourself, but as a servant to the creature. Now unable of free will.");
                    user.setExit(true);
                    user.printGameOverMessage();
                }
                else
                {
                    System.out.println("You go towards the smell, aware of some presence ahead of you. An undead creatures strikes at you with a sword, but you're able to match it with yours.");
                    System.out.println("As you battle this undead creature you start to get exhausted, the neverending blows of the creature being an unrelenting force.");
                    System.out.println("You try to go for a killing blow to end this fight, but the wight parrys your attack and goes to sink its claws into you. \nAt that moment, your gauntlet glows brightly, filling the passageway with bright, holy light. The wight flinches and you're able to desperately slice the wights head off.");
                }
                break;
            default: 
                break;
        }
    }

    public static void checkPosLoop(DungeonMap map, Player user){
        Scanner input = new Scanner(System.in);
        while (user.getExit() == false){
            checkRoom(map,user);
            if (user.getExit() == false){
                user.checkPosition(map);
                System.out.println("Direction?");
                String direction = input.nextLine();
                user.move(direction);
            }
        }
        input.close();
        return;
    } 

}