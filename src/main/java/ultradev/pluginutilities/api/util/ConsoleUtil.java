package ultradev.pluginutilities.api.util;

import ultradev.pluginutilities.Main;

public class ConsoleUtil {

    public static void log(String message) {
        System.out.println("[" + Main.pluginName + "] " + message);
    }

}
