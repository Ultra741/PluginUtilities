package ultradev.pluginutilities.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ultradev.pluginutilities.api.inventories.InventoryManager;

public class PreviousMenu extends InventoryManager {


    @Override
    public void setupInventory(Inventory inventory) {

    }

    @Override
    public void onClick(InventoryClickEvent event, Player player, String buttonID) {
        event.setCancelled(true);
    }
}
