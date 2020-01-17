import java.util.List;
import java.util.ArrayList;

public class RpgPlayerFacade {

    private Inventory inventory;
    private DamageCalculator damageCalc;

    public RpgPlayerFacade(Inventory inventory, DamageCalculator damageCalc) {
        this.inventory = inventory;
        this.damageCalc = damageCalc;
    }

    public void takeDamage(int amount) {
        this.damageCalc.takeDamage(amount);
    }