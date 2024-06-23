import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class BattleSystem {
    private Character player;
    private Monsters monster;
    private Scanner scanner;
    private Random random;

    public BattleSystem(Character player, Monsters monster) {
        this.player = player;
        this.monster = monster;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void startBattle() {
        System.out.println("Battle Start!");
        System.out.println(player.getName() + " vs " + monster.getType());

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            playerTurn();
            if (monster.getHealth() > 0) {
                monsterTurn();
            }
        }

        if (player.getHealth() > 0) {
            System.out.println(player.getName() + " wins!");
            player.addGold(10); // Reward player with gold
            System.out.println("You earned 10 gold. Total gold: " + player.getGold());
            player.endTurn();
        } else {
            System.out.println(monster.getType() + " wins!");
            player.endTurn();
        }
    }

    private void playerTurn() {
        System.out.println("Player's Turn:");
        System.out.println("1. Attack");
        System.out.println("2. Use Weapon");
        System.out.println("3. Use Armor");
        System.out.println("4. Use Potion");
        System.out.println("5. Run");
        System.out.print("Choose an action: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playerAttack();
                break;
            case 2:
                chooseWeapon();
                break;
            case 3:
                chooseArmor();
                break;
            case 4:
                choosePotion();
                break;
            case 5:
                attemptToRun();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to attack.");
                playerAttack();
                break;
        }
    }

    private void playerAttack() {
        int damage = player.getAttack() - monster.getDefense();
        if (damage < 0) damage = 0;
        monster.takeDamage(damage);
        System.out.println("You attacked the " + monster.getType() + " for " + damage + " damage.");
    }

    private void chooseWeapon() {
        System.out.println("Choose a weapon to use:");
        ArrayList<Weapons> weapons = player.getWeapons();
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getType());
        }
        System.out.print("Enter weapon choice (1-" + weapons.size() + "): ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= weapons.size()) {
            Weapons weapon = weapons.get(choice - 1);
            weapon.use(player); // Correct usage: use(player) method expects a Character
        } else {
            System.out.println("Invalid choice. Weapon not used.");
        }
    }

    private void chooseArmor() {
        // Implement logic to choose and use armor
        System.out.println("Choose an armor to use:");
        // Placeholder for choosing from player's armors
    }

    private void choosePotion() {
        // Implement logic to choose and use potion
        System.out.println("Choose a potion to use:");
        // Placeholder for choosing from player's potions
    }

    private void attemptToRun() {
        System.out.println("Attempting to run...");
        int chanceToRun = random.nextInt(100); // Simulate a 0-99 range
        if (chanceToRun < 50) { // 50% chance to successfully run
            System.out.println("You successfully ran away!");
            player.endTurn();
        } else {
            System.out.println("You failed to run away!");
            monsterTurn();
        }
    }

    private void monsterTurn() {
        System.out.println("Monster's Turn:");
        monster.attack(player);
    }

    public void runBattle(Character player, Monsters monster) {
        this.player = player;
        this.monster = monster;
        startBattle();
    }
}
