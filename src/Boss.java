public class Boss {
    private String name;
    private String description;
    private int health;
    private int attack;
    private int defense;

    public Boss(String name, String description, int health, int attack, int defense) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void attack(Character player) {
        int damage = calculateDamage(player);
        player.takeDamage(damage);
        System.out.println(name + " attacked " + player.getName() + " for " + damage + " damage.");
    }

    private int calculateDamage(Character player) {
        int baseDamage = attack - player.getDefense();
        if (baseDamage < 0) {
            baseDamage = 0;
        }

        // Applying random damage variation
        double variation = 0.1 * baseDamage;
        int randomVariation = (int) ((Math.random() * (2 * variation)) - variation);
        int finalDamage = baseDamage + randomVariation;

        return finalDamage;
    }

    public void displayBoss() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }

    public boolean isAlive() {
        return health > 0;
    }
}
