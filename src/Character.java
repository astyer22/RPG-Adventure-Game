import java.util.ArrayList;

public class Character {
    private String name;
    private String race;
    private String description;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int gold;
    private ArrayList<Weapons> weapons;
    private ArrayList<Armor> armors;
    private ArrayList<Potion> potions;
    private int battlesSinceRepair;
    private int totalBattles;

    public Character(String name, String race, String description, int health, int attack, int defense, int speed) {
        this.name = name;
        this.race = race;
        this.description = description;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.gold = 50; // Initial gold for purchasing items
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.battlesSinceRepair = 0;
        this.totalBattles = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getDescription() {
        return description;
    }

    public String getRace() {
        return race;
    }

    public int getTotalBattles() {
        return totalBattles;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void useWeapon(Weapons weapon) {
        int damage = weapon.getAttackBonus();
        System.out.println(name + " used " + weapon.getType() + ": " + damage);
        // Implement logic to apply this damage to the opponent (e.g., Monsters)
        // For simplicity, let's assume the Monsters class has a method takeDamage(int damage)
        // Example: target.takeDamage(damage); // Implement this in your Monsters class
    }

    public void useArmor(Armor armor) {
        System.out.println(name + " used " + armor.getType() + ": " + armor.getDefenseBonus());
        // Implement logic to apply armor bonus if needed
    }

    public void usePotion(Potion potion) {
        System.out.println(name + " used " + potion.getType() + ": " + potion.getPotionBonus());
        // Apply potion effect if needed
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void endTurn() {
        totalBattles++;
        battlesSinceRepair++;
    }

    public boolean canRepair() {
        return battlesSinceRepair >= 5;
    }

    public void repair() {
        if (canRepair()) {
            gold -= 25;
            battlesSinceRepair = 0;
            System.out.println("Armor and weapon repaired.");
        } else {
            System.out.println("Not enough battles fought to repair.");
        }
    }

    public void buyWeapon(Weapons weapon) {
        if (gold >= weapon.getCost()) {
            weapons.add(weapon);
            gold -= weapon.getCost();
            System.out.println("Bought " + weapon.getType() + " for " + weapon.getCost() + " gold.");
        } else {
            System.out.println("Not enough gold to buy " + weapon.getType() + ".");
        }
    }

    public void buyArmor(Armor armor) {
        if (gold >= armor.getCost()) {
            armors.add(armor);
            gold -= armor.getCost();
            System.out.println("Bought " + armor.getType() + " for " + armor.getCost() + " gold.");
        } else {
            System.out.println("Not enough gold to buy " + armor.getType() + ".");
        }
    }

    public void buyPotion(Potion potion) {
        if (gold >= potion.getCost()) {
            potions.add(potion);
            gold -= potion.getCost();
            System.out.println("Bought " + potion.getType() + " for " + potion.getCost() + " gold.");
        } else {
            System.out.println("Not enough gold to buy " + potion.getType() + ".");
        }
    }

    public void subtractGold(int amount) {
        if (amount > 0) {
            if (amount <= gold) {
                gold -= amount;
            } else {
                gold = 0;
            }
        } else {
            System.out.println("Invalid amount to subtract.");
        }
    }

    public void displayCharacter() {
        System.out.println("Name: " + name);
        System.out.println("Race: " + race);
        System.out.println("Description: " + description);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Gold: " + gold);
    }

}
