package ultradev.pluginutilities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ultradev.pluginutilities.api.commands.CommandUtil;
import ultradev.pluginutilities.api.util.MessageUtil;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(CommandUtil.checkCommand("test", sender))) {
            return false;
        }

        Player player = CommandUtil.getPlayerFromSender(sender);

        // Open menu

        MessageUtil.success(player, "Successfully opened menu.");

        return true;

    }
}
