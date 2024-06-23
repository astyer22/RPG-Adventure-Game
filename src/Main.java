import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Welcome message and start prompt
        System.out.println("Welcome to a world of adventure.");
        System.out.println("You will be entering into this realm as a whimp but leaving as a hero!");
        System.out.print("Do you wish to begin? (yes/no): ");
        String startGame = scanner.nextLine();

        if (startGame.equalsIgnoreCase("yes")) {
            System.out.println("Great! Let's embark on this epic journey.");

            // Prompt user for character name
            System.out.print("Enter name for player: ");
            String name = scanner.nextLine();

            // Create character
            Character character = new Character(name, "Human", "A former farmer wanting to prove they are the best warrior in the land.", 200, 20, 8, 5);

            // Game levels
            Levels[] levels = {
                    new Levels("Laufin's Moon Conquest",
                            "In the shadowed lands where the moon's silver light weaves through the ancient trees, Laufin, the Lycan Lord, prowls. With fur as black as midnight and eyes that gleam with feral hunger, he seeks to claim the moon's power as his own. From his fortress of shadow and bone, he commands a pack of savage werewolves and twisted creatures of the night. Will you challenge Laufin's dominion, or be consumed by the moon's dark embrace?"),
                    new Levels("The Goblin Queen's Groom",
                            "Amidst the treacherous depths of Goblin Wood, Amtha, the mighty Goblin Queen, with skin as green as emerald and eyes ablaze with arcane fire, hungers for a new consort after devouring her last. Legends echo through the gnarled trees of treasures untold and dangers unspoken. Will you brave the Queen's wrath to claim glory, or fall prey to her insatiable hunger?"),
                    new Levels("The Demon's Revenge",
                            "In the fiery pits of the Abyss, Belthar, the Demon Lord, broods. With horns that pierce the heavens and wings that cast shadows over the sun, he seeks vengeance against the forces of light that cast him down. From his citadel of flame and brimstone, he commands a legion of infernal creatures and damned souls. Will you defy Belthar's wrath, or be consumed by the fires of his fury?"),
                    new Levels("The Reign of the Dead",
                            "In the shadow-draped realms where darkness intertwines with the essence of decay, Rogar, the Dread Necromancer, reigns supreme. Clad in robes woven from the threads of mortal fear and arcane mastery, he seeks to harvest humanity to bolster his ever-growing legion of undead horrors. From his fortress of bone and soul-shackled stone, he whispers forbidden incantations that echo through the abyss, beckoning souls to join his spectral army. Will you defy Rogar's unholy ambitions, or be consumed by the relentless tide of his undead horde?")
            };

            // Main game loop
            for (int levelIndex = 0; levelIndex < levels.length; levelIndex++) {
                Levels currentLevel = levels[levelIndex];

                // Display level title and description
                System.out.println("\nWelcome to " + currentLevel.getTitle());
                System.out.println(currentLevel.getDescription());

                // Encounter 8 monsters (fixed number)
                int numMonsters = 8; // Fixed number of monsters to encounter
                System.out.println("Prepare to face " + numMonsters + " monsters before confronting the boss!");

                for (int i = 1; i <= numMonsters; i++) {
                    Monsters monster = getRandomMonster(random);
                    System.out.println("\nYou encounter a " + monster.getType() + "!");
                    simulateBattle(character, monster, scanner);
                    if (character.getHealth() <= 0) {
                        System.out.println("Game Over. You were defeated by the " + monster.getType() + ".");
                        return; // End game loop
                    }
                }

                // Prompt user to continue to next level or end the game
                if (levelIndex < levels.length - 1) {
                    System.out.print("\nDo you wish to continue to the next level? (yes/no): ");
                    String continueGame = scanner.nextLine();
                    if (!continueGame.equalsIgnoreCase("yes")) {
                        System.out.println("Thank you for playing!");
                        return;
                    }
                } else {
                    System.out.println("Congratulations! You have defeated all levels and completed the game as a hero!");
                }
            }

        } else {
            System.out.println("Perhaps another time. Farewell!");
        }

        scanner.close();
    }

    private static Monsters getRandomMonster(Random random) {
        Monsters[] monsters = {
                new Monsters("Goblin", "A small, green creature that is known for its mischievous behavior.", 10, 5, 2),
                new Monsters("Orc", "A large, brutish creature that is known for its strength and aggression.", 20, 10, 7),
                new Monsters("Dragon", "A massive, fire-breathing creature that is known for its power and intelligence.", 50, 20, 10),
                new Monsters("Giant", "A huge, lumbering creature that is known for its size and strength.", 40, 15, 7),
                new Monsters("Troll", "A large, regenerating creature that is known for its durability and regenerative abilities.", 30, 18, 8),
                new Monsters("Witch", "A magical creature that is known for its spellcasting abilities and potions.", 15, 8, 4),
                new Monsters("Zombie", "A reanimated corpse that is known for its undead nature and infectious bite.", 25, 12, 6),
                new Monsters("Vampire", "An undead creature that is known for its blood-sucking abilities and immortality.", 35, 16, 9),
                new Monsters("Beholder", "A large, floating creature that is known for its many eyes and magical abilities.", 45, 19, 10),
                new Monsters("Giant Spider", "A large, eight-legged creature that is known for its web-spinning abilities and venomous bite.", 25, 12, 6),
                new Monsters("Giant Scorpion", "A large, stinger-tailed creature that is known for its venomous sting and armored exoskeleton.", 30, 15, 7),
                new Monsters("Skeleton", "A reanimated skeleton that is known for its undead nature and swordsmanship.", 20, 10, 5)
        };
        return monsters[random.nextInt(monsters.length)];
    }

    private static void simulateBattle(Character character, Monsters monsters, Scanner scanner) {
        System.out.println("Prepare for battle against " + monsters.getType() + "!");
        while (character.getHealth() > 0 && monsters.getHealth() > 0) {
            // Player's turn
            System.out.println("\nYour turn:");
            System.out.println("1. Attack");
            System.out.println("2. Use Potion");
            System.out.print("Choose your action: ");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (action) {
                case 1:
                    int damageDealt = character.getAttack();
                    monsters.takeDamage(damageDealt);
                    System.out.println("You attack the " + monsters.getType() + " for " + damageDealt + " damage.");
                    break;
                case 2:
                    if (!character.getPotions().isEmpty()) {
                        Potion potion = character.getPotions().get(0); // Example: use the first potion
                        character.usePotion(potion);
                    } else {
                        System.out.println("No potions left!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            // Monsters's turn
            if (monsters.getHealth() > 0) {
                int damageTaken = monsters.getAttack();
                character.takeDamage(damageTaken);
                System.out.println("The " + monsters.getType() + " attacks you for " + damageTaken + " damage.");
            }

            // Display current health status
            System.out.println("Your HP: " + character.getHealth() + " / monsters HP: " + monsters.getHealth());
        }

        // Determine battle outcome
        if (character.getHealth() > 0) {
            System.out.println("You defeated the " + monsters.getType() + "!");
        } else {
            System.out.println("Game Over. You were defeated by the " + monsters.getType() + ".");
        }
    }
}
