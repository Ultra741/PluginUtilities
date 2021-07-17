package ultradev.pluginutilities.api.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ultradev.pluginutilities.Main;

public class EventUtil {

    public static void registerEvent(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, Main.getInstance());
    }

    public static Player getWhoClicked(InventoryClickEvent event) {
        return (Player) event.getWhoClicked();
    }

}
