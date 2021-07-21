package ultradev.pluginutilities.api.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ultradev.pluginutilities.api.util.ItemUtil;

public class InventoryUtil {

    public static void openInventory(InventoryMenu menu, Player player) {

        Inventory inventory = Bukkit.createInventory(null, menu.getRows() * 9, menu.getTitle());

        if(menu.hasCloseButton()) {
            addCloseButton(inventory);
        }

        menu.setupInventory(inventory, player);

        player.openInventory(inventory);

        menu.openInventory(player);

    }

    public static void addCloseButton(Inventory inventory) {
        inventory.setItem(inventory.getSize() - 5, new ItemUtil(Material.BARRIER)
        .setName("&cClose")
        .setButtonID("close")
        .buildItem());
    }

    public static void addCloseButton(Player player) {
        addCloseButton(player.getOpenInventory().getTopInventory());
    }

    public static void addBackArrow(Inventory inventory, InventoryMenu menu) {
        inventory.setItem(inventory.getSize() - 4, new ItemUtil(Material.ARROW)
        .setName("&eGo Back")
        .addLore("&7Return to the previous menu.")
        .addItemTag("menu", menu.getID())
        .setButtonID("go_back")
        .buildItem());
    }

    public static void addBackArrow(Player player, InventoryMenu menu) {
        addBackArrow(player.getOpenInventory().getTopInventory(), menu);
    }

}
