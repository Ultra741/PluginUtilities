package ultradev.pluginutilities.api.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ultradev.pluginutilities.Main;

public abstract class InventoryMenu {

    private final String id;
    private final String title;
    private final int rows;
    private final boolean closeButton;

    public InventoryMenu(String id, String title, int rows, boolean closeButton) {

        this.id = id;
        this.title = title;
        this.rows = rows;
        this.closeButton = closeButton;

        if(!(Main.getMenus().contains(this))) {
            Main.getMenus().add(this);
        }

    }

    public InventoryMenu(String id, String title, int rows) {
        this(id, title, rows, true);
    }

    public InventoryMenu(String id, String title, boolean closeButton) {
        this(id, title, 3, closeButton);
    }

    public InventoryMenu(String id, String title) {
        this(id, title, 3, true);
    }

    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRows() {
        return rows;
    }

    public boolean hasCloseButton() {
        return closeButton;
    }

    public abstract void setupInventory(Inventory inventory, Player player);

    public abstract void onClick(InventoryClickEvent event, Player player, String buttonID);

    public abstract void openInventory(Player player);

}
