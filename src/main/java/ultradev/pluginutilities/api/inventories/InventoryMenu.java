package ultradev.pluginutilities.api.inventories;

import ultradev.pluginutilities.menus.PreviousMenu;
import ultradev.pluginutilities.menus.TestingMenu;

public enum InventoryMenu {

    TESTING_MENU(new TestingMenu(), "testing_menu", "Testing Menu"),
    PREVIOUS_MENU(new PreviousMenu(), "previous_menu", "Previous Menu", 4);

    private final InventoryManager manager;

    private final String id;
    private final String title;
    private final int rows;
    private final boolean closeButton;

    InventoryMenu(InventoryManager manager, String id, String title, int rows, boolean closeButton) {
        this.manager = manager;
        this.id = id;
        this.title = title;
        this.rows = rows;
        this.closeButton = closeButton;
    }

    InventoryMenu(InventoryManager manager, String id, String title, int rows) {
        this(manager, id, title, rows, true);
    }

    InventoryMenu(InventoryManager manager, String id, String title, boolean closeButton) {
        this(manager, id, title, 3, closeButton);
    }

    InventoryMenu(InventoryManager manager, String id, String title) {
        this(manager, id, title, 3, true);
    }

    public InventoryManager getManager() {
        return manager;
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

}
