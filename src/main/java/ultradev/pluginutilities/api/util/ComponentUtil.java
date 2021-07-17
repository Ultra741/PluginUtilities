package ultradev.pluginutilities.api.util;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class ComponentUtil {

    private final TextComponent component;

    public ComponentUtil(String message, String clickCommand, ClickEvent.Action clickAction, String hoverMessage) {

        component = new TextComponent(message);

        if(!(clickCommand.equals(""))) {
            component.setClickEvent(new ClickEvent(clickAction, clickCommand));
        }

        if(!(hoverMessage.equals(""))) {
            component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverMessage)));
        }

    }

    public ComponentUtil(String message, String clickCommand, String hoverMessage) {
        this(message, clickCommand, ClickEvent.Action.RUN_COMMAND, hoverMessage);
    }

    public ComponentUtil(String message, String clickCommand, ClickEvent.Action clickAction) {
        this(message, clickCommand, clickAction, "");
    }

    public ComponentUtil(String message, String clickCommand) {
        this(message, clickCommand, ClickEvent.Action.RUN_COMMAND, "");
    }

    public TextComponent buildComponent() {
        return component;
    }

}
