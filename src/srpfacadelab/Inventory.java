import java.util.List;
import java.util.ArrayList;

public class Inventory {

    private RpgPlayer player;

    public Inventory(RpgPlayer player) {
        this.player = player;
    }

private int calculateInventoryWeight(List<Item> inventory) {
    int sum=0;
    for (Item i: inventory) {
        sum += i.getWeight();
    }
    return sum;
}

private boolean checkIfItemExistsInInventory(Item item, List<Item> inventory) {
    for (Item i: inventory) {
        if (i.getId() == item.getId())
            return true;
    }
    return false;
}

public boolean pickUpItem(Item item, List<Item> inventory, int carryingCapacity) {
    int weight = calculateInventoryWeight();
    if (weight + item.getWeight() > carryingCapacity)
        return false;

    if (item.isUnique() && checkIfItemExistsInInventory(item))
        return false;

    // Don't pick up items that give health, just consume them.
    if (item.getHeal() > 0) {
        int health = player.getHealth() + item.getHeal();

        if (health > maxHealth)
            health = maxHealth;

        player.setHealth(health);

        if (item.getHeal() > 500) {
            gameEngine.playSpecialEffect("green_swirly");
        }

        return true;
    }

    if (item.isRare() && !item.isUnique) {
        gameEngine.playSpecialEffect("cool_swirly_particles");
    }

    if (item.isRare() && item.isUnique) {
        gameEngine.playSpecialEffect("blue_swirly");
    }

    player.addToInventory(item);

    calculateStats();

    return true;
}

public void useItem(Item item) {
    if (item.getName().equals("Stink Bomb"))
    {
        List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

        for (IEnemy enemy: enemies){
            enemy.takeDamage(100);
        }
    }
}