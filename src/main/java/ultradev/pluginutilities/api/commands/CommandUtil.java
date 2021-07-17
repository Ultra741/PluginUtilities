package ultradev.pluginutilities.api.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ultradev.pluginutilities.Main;
import ultradev.pluginutilities.api.util.MessageUtil;

public class CommandUtil {

    public static boolean checkPlayer(CommandSender sender, boolean sendError) {

        if(sendError) {
            if(!(sender instanceof Player)) {
                MessageUtil.error(sender, CommandError.NOT_A_PLAYER);
            }
        }

        return sender instanceof Player;

    }

    public static boolean checkPermission(Player player, String permission, boolean sendError) {

        boolean hasPermission = player.hasPermission(Main.pluginName.toLowerCase() + "." + permission);

        if(sendError && !(hasPermission)) {
            MessageUtil.error(player, CommandError.NO_PERMISSION);
        }

        return hasPermission;

    }

    public static Player getPlayerFromSender(CommandSender sender) {
        return (Player) sender;
    }

    public static boolean checkCommand(String command, CommandSender sender, boolean checkPlayer, boolean checkPermission) {

        if(checkPlayer) {
            if(!(checkPlayer(sender, true))) {
                return false;
            }
        }

        if(checkPermission) {
            return checkPermission(getPlayerFromSender(sender), command.toLowerCase(), true);
        }

        return true;

    }

    public static boolean checkCommand(String command, CommandSender sender) {
        return checkCommand(command, sender, true, true);
    }

    public static void registerCommand(String command, CommandExecutor executor) {
        Main.getInstance().getCommand(command).setExecutor(executor);
    }

}
