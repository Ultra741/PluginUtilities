package ultradev.pluginutilities.api.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ultradev.pluginutilities.api.nbt.NBTEditor;

import java.util.ArrayList;
import java.util.List;

public class ItemUtil {

    private ItemStack item;

    public ItemUtil(Material material, int amount) {
        item = new ItemStack(material, amount);
    }

    public ItemUtil(Material material) {
        this(material, 1);
    }

    public String getName() {

        try {
            return item.getItemMeta().getDisplayName();
        } catch(NullPointerException npe) {
            return "";
        }

    }

    public List<String> getLore() {

        List<String> lore = new ArrayList<>();

        try {
            lore.addAll(getItemMeta().getLore());
        } catch(Exception e) { }

        return lore;

    }

    public Material getMaterial() {
        return item.getType();
    }

    public int getAmount() {
        return item.getAmount();
    }

    public ItemMeta getItemMeta() {
        return item.getItemMeta();
    }

    public ItemUtil setName(String name) {

        ItemMeta meta = getItemMeta();
        meta.setDisplayName(ColorUtil.toColor(name));
        item.setItemMeta(meta);

        return this;

    }

    public ItemUtil setLore(List<String> lore) {

        ItemMeta meta = getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);

        return this;

    }

    public ItemUtil addLore(String line) {

        List<String> lore = getLore();
        lore.add(ColorUtil.toColor(line));
        setLore(lore);

        return this;

    }

    public ItemUtil setLoreLine(int index, String line) {

        List<String> lore = getLore();
        lore.set(index, ColorUtil.toColor(line));
        setLore(lore);

        return this;

    }

    public ItemUtil insertLoreLine(int index, String line) {

        List<String> lore = getLore();
        lore.add(index, ColorUtil.toColor(line));
        setLore(lore);

        return this;

    }

    public ItemUtil removeLoreLine(int index) {

        List<String> lore = getLore();
        lore.remove(index);
        setLore(lore);

        return this;

    }

    public ItemUtil clearLore() {

        List<String> lore = new ArrayList<>();
        setLore(lore);

        return this;

    }

    public ItemUtil setMaterial(Material material) {

        item.setType(material);
        return this;

    }

    public ItemUtil setAmount(int amount) {

        item.setAmount(amount);
        return this;

    }

    public ItemUtil addItemTag(String key, String value) {

        item = NBTEditor.addString(item, key, value);
        return this;

    }

    public ItemUtil addItemTag(String key, int value) {

        item = NBTEditor.addInteger(item, key, value);
        return this;

    }

    public ItemUtil setButtonID(String id) {

        addItemTag("button_id", id);
        return this;

    }

    public ItemUtil hideFlags() {

        ItemMeta meta = getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        item.setItemMeta(meta);

        return this;

    }

    public ItemStack buildItem() {
        return item;
    }

}
