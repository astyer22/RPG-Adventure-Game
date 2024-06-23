public class Potion {
    private String type;
    private int potionBonus;
    private int cost;

    public Potion(String type, int potionBonus, int cost) {
        this.type = type;
        this.potionBonus = potionBonus;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public int getPotionBonus() {
        return potionBonus;
    }

    public int getCost() {
        return cost;
    }

    public void use(Character player) {
        player.usePotion(this);
    }

    public void displayPotions() {
        System.out.println("Potion: " + type + " Bonus: " + potionBonus);
    }
}
