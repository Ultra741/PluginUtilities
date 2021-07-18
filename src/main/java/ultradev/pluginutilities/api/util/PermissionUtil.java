package ultradev.pluginutilities.api.util;

import org.bukkit.entity.Player;
import ultradev.pluginutilities.Main;

public class PermissionUtil {

    public static boolean hasPermission(Player player, String permission) {
        return player.hasPermission(Main.pluginName.toLowerCase() + "." + permission);
    }

}
