import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Weapons> weaponsForSale;
    private List<Armor> armorForSale;
    private List<Potion> potionsForSale;

    public Shop() {
        this.weaponsForSale = new ArrayList<>(); 
        this.armorForSale = new ArrayList<>();
        this.potionsForSale = new ArrayList<>();

        // Adding some items to the shop
        weaponsForSale.add(new Weapons("Sword", 8, 15));
        weaponsForSale.add(new Weapons("Bow", 3, 10));
        weaponsForSale.add(new Weapons("Flaming Arrows", 2, 5));
        weaponsForSale.add(new Weapons("Plain Arrows", 1, 2));
        weaponsForSale.add(new Weapons("Club", 4, 3));

        armorForSale.add(new Armor("Helm", 4 , 10));
        armorForSale.add(new Armor("Chainmail Breast Plate", 6, 15));
        armorForSale.add(new Armor("Gloves", 1, 3));

        potionsForSale.add(new Potion("Health Potion", 25, 10));
        potionsForSale.add(new Potion("Defense Potion", 10, 15));
        potionsForSale.add(new Potion("Attack Potion", 10, 20));
    }

    public void displayItems() {
        System.out.println("Weapons for sale:");
        for (Weapons weapon : weaponsForSale) {
            System.out.println(weapon.getType() + ": " + weapon.getAttackBonus() + " Cost: " + weapon.getCost());
        }

        System.out.println("\nArmor for sale:");
        for (Armor armor : armorForSale) {
            System.out.println(armor.getType() + ": " + armor.getDefenseBonus() + " Cost: " + armor.getCost());
        }

        System.out.println("\nPotions for sale:");
        for (Potion potion : potionsForSale) {
            System.out.println(potion.getType() + ": " + potion.getPotionBonus() + " Cost: " + potion.getCost());
        }
    }

    public void sellWeapon(Character character, String weaponType) {
        for (Weapons weapon : weaponsForSale) {
            if (weapon.getType().equalsIgnoreCase(weaponType)) {
                if (character.getGold() >= weapon.getCost()) {
                    character.buyWeapon(weapon);
                    return;
                } else {
                    System.out.println("Not enough gold to buy " + weapon.getType() + ".");
                    return;
                }
            }
        }
        System.out.println("Weapon not found.");
    }

    public void sellArmor(Character character, String armorType) {
        for (Armor armor : armorForSale) {
            if (armor.getType().equalsIgnoreCase(armorType)) {
                if (character.getGold() >= armor.getCost()) {
                    character.buyArmor(armor);
                    return;
                } else {
                    System.out.println("Not enough gold to buy " + armor.getType() + ".");
                    return;
                }
            }
        }
        System.out.println("Armor not found.");
    }

    public void sellPotion(Character character, String potionType) {
        for (Potion potion : potionsForSale) {
            if (potion.getType().equalsIgnoreCase(potionType)) {
                if (character.getGold() >= potion.getCost()) {
                    character.buyPotion(potion);
                    return;
                } else {
                    System.out.println("Not enough gold to buy " + potion.getType() + ".");
                    return;
                }
            }
        }
        System.out.println("Potion not found.");
    }
}
