public class Monsters {
    private String type;
    private String description;
    private int health;
    private int attack;
    private int defense;

    public Monsters(String type, String description, int health, int attack, int defense) {
        this.type = type;
        this.description = description;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getType() {
        return type;
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
        int damage = attack - player.getDefense();
        if (damage < 0) {
            damage = 0;
        }
        player.takeDamage(damage);
        System.out.println(type + " attacked " + player.getName() + " for " + damage + " damage.");
    }

    public void displayMonsterInfo() {
        System.out.println("Monster Type: " + type);
        System.out.println("Description: " + description);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }
}
