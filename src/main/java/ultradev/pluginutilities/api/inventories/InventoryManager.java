package ultradev.pluginutilities.api.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class InventoryManager {

    public abstract void setupInventory(Inventory inventory);

    public abstract void onClick(InventoryClickEvent event, Player player, String buttonID);

}
