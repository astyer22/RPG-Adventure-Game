public class Armor {
    private String type;
    private int defenseBonus;
    private int cost;

    public Armor(String type, int defenseBonus, int cost) {
        this.type = type;
        this.defenseBonus = defenseBonus;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getCost() {
        return cost;
    }

    public void use(Character player) {
        player.useArmor(this);
    }

    public void displayArmors() {
        System.out.println("Armor: " + type + " Defense: " + defenseBonus);
    }
}
