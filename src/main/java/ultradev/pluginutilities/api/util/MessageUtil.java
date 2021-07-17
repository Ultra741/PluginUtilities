package ultradev.pluginutilities.api.util;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ultradev.pluginutilities.api.commands.CommandError;

public class MessageUtil {

    public static void success(Player player, String message) {
        player.sendMessage(ColorUtil.toColor("&a" + message));
    }

    public static void success(CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.toColor("&a" + message));
    }

    public static void error(Player player, String message) {
        player.sendMessage(ColorUtil.toColor("&c" + message));
    }

    public static void error(Player player, CommandError error) {
        error(player, error.getError());
    }

    public static void error(CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.toColor("&c" + message));
    }

    public static void error(CommandSender sender, CommandError error) {
        error(sender, error.getError());
    }

    public static void sendHover(Player player, String message, String hoverMessage) {

        TextComponent hoverComponent = new ComponentUtil(
                ColorUtil.toColor(message), "", ColorUtil.toColor(message))
                .buildComponent();

        player.spigot().sendMessage(hoverComponent);

    }

}
