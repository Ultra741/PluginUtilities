package ultradev.pluginutilities.api.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ultradev.pluginutilities.api.nbt.NBTEditor;
import ultradev.pluginutilities.api.util.EventUtil;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = EventUtil.getWhoClicked(event);

        ItemStack item = event.getCurrentItem();
        String title = player.getOpenInventory().getTitle();

        InventoryMenu[] menus = InventoryMenu.values();

        for(InventoryMenu menu : menus) {
            if(menu.getTitle().equals(title)) {

                String buttonID = "";

                if(NBTEditor.hasString(item, "button_id")) {
                    buttonID = NBTEditor.getString(item, "button_id");
                }

                if(buttonID.equals("close")) {

                    player.closeInventory();
                    player.updateInventory();

                } else if(buttonID.equals("go_back")) {

                    String menuID = "";

                    if(NBTEditor.hasString(item, "menu")) {
                        menuID = NBTEditor.getString(item, "menu");
                    }

                    for(InventoryMenu previousMenu : menus) {
                        if(previousMenu.getID().equals(menuID)) {
                            InventoryUtil.openInventory(previousMenu, player);
                            break;
                        }
                    }

                }

                menu.getManager().onClick(event, player, buttonID);
                break;

            }
        }

    }

}
