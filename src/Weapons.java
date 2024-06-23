public class Weapons {
    private String type;
    private int attackBonus;
    private int cost;

    public Weapons(String type, int attackBonus, int cost) {
        this.type = type;
        this.attackBonus = attackBonus;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getCost() {
        return cost;
    }

    public void use(Character player) {
        player.useWeapon(this); // Calls the useWeapon method in Character
    }

    public void displayWeapons() {
        System.out.println("Weapon: " + type + " Attack: " + attackBonus);
    }
}
