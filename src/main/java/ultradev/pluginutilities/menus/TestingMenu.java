package ultradev.pluginutilities.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ultradev.pluginutilities.api.inventories.InventoryManager;
import ultradev.pluginutilities.api.inventories.InventoryMenu;
import ultradev.pluginutilities.api.inventories.InventoryUtil;
import ultradev.pluginutilities.api.util.ItemUtil;

public class TestingMenu extends InventoryManager {


    @Override
    public void setupInventory(Inventory inventory) {
        inventory.setItem(0, new ItemUtil(Material.DIAMOND_AXE)
        .setName("&6&lEpic Gamer Dirt")
                .addLore("&6line 1!")
        .hideFlags()
        .buildItem());

        InventoryUtil.addBackArrow(inventory, InventoryMenu.PREVIOUS_MENU);

    }

    @Override
    public void onClick(InventoryClickEvent event, Player player, String buttonID) {
        event.setCancelled(true);
    }

}
