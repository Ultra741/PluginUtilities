package ultradev.pluginutilities;

import org.bukkit.plugin.java.JavaPlugin;
import ultradev.pluginutilities.api.commands.CommandUtil;
import ultradev.pluginutilities.api.inventories.InventoryClick;
import ultradev.pluginutilities.api.util.EventUtil;
import ultradev.pluginutilities.commands.TestCommand;

public final class Main extends JavaPlugin {

    private static Main main;

    public static final String pluginName = "PluginUtilities";

    @Override
    public void onEnable() {
        // Plugin startup logic

        main = this;

        EventUtil.registerEvent(new InventoryClick());
        CommandUtil.registerCommand("test", new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return main;
    }

}
