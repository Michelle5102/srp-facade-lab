import java.util.List;
import java.util.ArrayList;

public class DamageCalculator {

    private RpgPlayer player;
    private Inventory inventory;

    public DamageCalculator(RpgPlayer player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

public void takeDamage(int damage) {
    if (damage < player.getArmour) {
        gameEngine.playSpecialEffect("parry");
    }

    int damageToDeal = damage - player.getArmour;
    
    if (inventory.calculateInventoryWeight() <= player.getWeight()) {
        damageToDeal -= damageToDeal * 0.25;
    }

    player.setHealth() = player.getHealth() - damageToDeal;

    gameEngine.playSpecialEffect("lots_of_gore");
}