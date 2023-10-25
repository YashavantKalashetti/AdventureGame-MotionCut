package yash.AdventureGame.src;

import java.util.Scanner;
import java.util.Random;

public class AdventureGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

class Game {
    private int playerHP;
    private String playerName;
    private String playerWeapon,playerArmor;
    private int choice;
    private int monsterHP;
    private int silverRing;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        playerSetUp();
        townGate();
    }

    private void playerSetUp() {
        playerHP = 10;
        monsterHP = 15;

        System.out.println("The land of Mystoria awaits, brave adventurer.");
        System.out.println("You've arrived on this mysterious Kingdom, shrouded in secrets and peril.");
        System.out.println("With a weapon in your hand and a choice in your heart, you must decide your fate.");
        System.out.println("Survival, discovery, and perhaps even glory await your every decision.");

        System.out.println("\nPlease enter your name:");
        playerName = scanner.nextLine();

        System.out.println("Choose your weapon:");
        System.out.println("1: Dagger (3-5 damage)");
        System.out.println("2: Sword (4-7 damage)");
        System.out.println("3: Axe (5-8 damage)");
        System.out.print("Enter the number of your choice: ");

        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                playerWeapon = "Dagger";
                break;
            case 2:
                playerWeapon = "Sword";
                break;
            case 3:
                playerWeapon = "Axe";
                break;
            default:
                playerWeapon = "Boning knife";
                break;
        }

        System.out.println("\nChoose your armor:");
        System.out.println("1: Leather Armor (+1 HP)");
        System.out.println("2: Iron Armor (+2 HP)");
        System.out.println("3: Full plate Armor (+3 HP)");
        System.out.print("Enter the number of your choice: ");

        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                playerArmor = "Leather Armor";
                playerHP += 1;
                break;
            case 2:
                playerArmor = "Iron Armor";
                playerHP += 2;
                break;
            case 3:
                playerArmor = "Full plate Armor";
                playerHP += 3;
                break;
            default:
                playerArmor = "No Armor";
                break;
        }

        System.out.println("\nHello " + playerName + ", let's start the game!");
        System.out.println("Your HP: " + playerHP);
        System.out.println("Your Weapon: " + playerWeapon);
        System.out.println("Your Armor: " + playerArmor);
    }

    private void townGate() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at the gate of the town.");
        System.out.println("A guard is standing in front of you.\n");

        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Leave");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            if (silverRing == 1) {
                ending();
            } else {
                System.out.println("Guard: Hello there, stranger. So your name is " + playerName
                        + "?\nSorry, but we cannot let a stranger enter our town.");
                scanner.nextLine();
                townGate();
            }

        } else if (choice == 2) {
            playerHP--;
            System.out.println("Guard: Hey, don't be stupid.\n\nThe guard hit you, and you gave up.\n(You receive 1 damage)\n");
            System.out.println("Your HP: " + playerHP);
            scanner.nextLine();
            townGate();
        } else if (choice == 3) {
            crossRoad();
        } else {
            townGate();
        }
    }

    private void crossRoad() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n");

        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            north();
        } else if (choice == 2) {
            east();
        } else if (choice == 3) {
            townGate();
        } else if (choice == 4) {
            west();
        } else {
            crossRoad();
        }
    }

    private void north() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("There is a river. You drink the water and rest at the riverside.");
        System.out.println("Your HP is recovered.");
        if (playerHP < 25){
            playerHP++;
            System.out.println("Your HP: " + playerHP);
        }else {
            System.out.println("You already have a Full HP");
        }
        System.out.println("\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            crossRoad();
        } else {
            north();
        }
    }

    private void east() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You venture south and find a hidden treasure!");

        // Generate a random scenario for the treasure
        int treasureScenario = random.nextInt(6);

        switch (treasureScenario) {
            case 0:
                System.out.println("You found a chest of gold coins!");
                int goldCoinsFound = random.nextInt(50) + 1;
                System.out.println("You gained " + goldCoinsFound + " gold coins!");
                break;
            case 1:
                System.out.println("You discover a valuable gemstone!");
                System.out.println("It sparkles with radiant beauty.");
                break;
            case 2:
                System.out.println("You find an old, dusty book filled with ancient knowledge.");
                System.out.println("Reading it might grant you wisdom.");
                break;
            case 3:
                System.out.println("You uncover a hidden passage to a secret chamber.");
                System.out.println("Inside, you find a powerful enchanted weapon!");
                System.out.println("You Found a Long Sword (Katana)");
                playerWeapon = "Long Sword";
                System.out.println("Your Weapon: " + playerWeapon);
                break;
            case 4:
                System.out.println("You stumble upon a friendly forest spirit.");
                System.out.println("The spirit offers you a choice: a special ability or a magical potion.");
                System.out.println("1: Gain a special ability");
                System.out.println("2: Take the magical potion");
                int spiritChoice = scanner.nextInt();
                if (spiritChoice == 1) {
                    System.out.println("The spirit grants you the ability to 'Invisibility'.");
                    System.out.println("You can now use this ability to sneak past enemies.");
                } else if (spiritChoice == 2) {
                    System.out.println("You drink the magical potion and feel a surge of energy.");
                    System.out.println("Your HP is fully restored!");
                    playerHP = 25;
                }
                break;
            default:
                System.out.println("You just found a empty box of Skeletons!");
                break;
        }

        System.out.println("\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            crossRoad();
        } else {
            east();
        }
    }

    private void west() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            crossRoad();
        } else {
            west();
        }
    }

    private void fight() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Your HP: " + playerHP);
        System.out.println("Monster HP: " + monsterHP);
        System.out.println("\n1: Attack");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            attack();
        } else if (choice == 2) {
            crossRoad();
        } else {
            fight();
        }
    }

    private void attack() {
        int playerDamage = 0;

        if (playerWeapon.equals("Knife")) {
            playerDamage = random.nextInt(5);
        } else if (playerWeapon.equals("Long Sword")) {
            playerDamage = random.nextInt(8);
        }

        System.out.println("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP -= playerDamage;

        System.out.println("Monster HP: " + monsterHP);

        if (monsterHP < 1) {
            win();
        } else if (monsterHP > 0) {
            int monsterDamage = random.nextInt(4);
            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");
            playerHP -= monsterDamage;
            System.out.println("Player HP: " + playerHP);

            if (playerHP < 1) {
                dead();
            } else if (playerHP > 0) {
                fight();
            }
        }
    }

    private void dead() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are dead!!!");
        System.out.println("\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    private void win() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtained a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n------------------------------------------------------------------\n");

        silverRing = 1;

        choice = scanner.nextInt();
        if (choice == 1) {
            crossRoad();
        } else {
            win();
        }
    }

    private void ending() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh, you killed that goblin!?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
        System.out.println("\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}
