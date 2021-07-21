package ultradev.pluginutilities;

import org.bukkit.plugin.java.JavaPlugin;
import ultradev.pluginutilities.api.inventories.InventoryClick;
import ultradev.pluginutilities.api.inventories.InventoryMenu;
import ultradev.pluginutilities.api.util.EventUtil;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private static Main main;

    public static final String pluginName = "PluginUtilities";

    private static final List<InventoryMenu> menus = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        main = this;

        EventUtil.registerEvent(new InventoryClick());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return main;
    }

    public static List<InventoryMenu> getMenus() {
        return menus;
    }

}
