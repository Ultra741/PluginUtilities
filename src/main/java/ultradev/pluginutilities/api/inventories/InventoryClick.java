package ultradev.pluginutilities.api.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ultradev.pluginutilities.Main;
import ultradev.pluginutilities.api.nbt.NBTEditor;
import ultradev.pluginutilities.api.util.EventUtil;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = EventUtil.getWhoClicked(event);

        ItemStack item = event.getCurrentItem();
        String title = player.getOpenInventory().getTitle();

        for(int i = 0; i < Main.getMenus().size(); i++) {

            InventoryMenu menu = Main.getMenus().get(i);

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

                    for(int x = 0; x < Main.getMenus().size(); x++) {

                        InventoryMenu element = Main.getMenus().get(x);

                        if(element.getID().equals(menuID)) {
                            InventoryUtil.openInventory(element, player);
                            break;
                        }

                    }

                }

                menu.onClick(event, player, buttonID);
                break;

            }

        }

    }

}
