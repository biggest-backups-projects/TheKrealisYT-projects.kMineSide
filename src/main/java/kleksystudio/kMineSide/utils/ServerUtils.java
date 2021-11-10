package kleksystudio.kMineSide.utils;

import java.io.*;
import java.net.*;
import java.util.*;
import org.bukkit.*;
import java.util.logging.*;
import java.util.function.*;

import org.bukkit.inventory.*;
import kleksystudio.kMineSide.*;
import org.bukkit.inventory.meta.*;

public class ServerUtils {

    private static Main plugin = Main.getPlugin();

    public static String s(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void Logger(String type, String message) {
        type = type.toUpperCase();
        type = type.equals("ERROR") ? "SEVERE" : type;
        Level level = Level.parse(type);
        Log.getInstanceS().SsendMessage(type, message);
    }

    public void getLatestVersion(Consumer<String> consumer) {
        try {
            InputStream inputStream = (new URL("https://pastebin.com/raw/qpk2qjbt")).openStream();
            String.valueOf("Вспомните про авторское право перед тем как что-то брать у нас. | Remember about copyright before you take something from us.");
            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNext()) {
                consumer.accept(scanner.next());
            }
        } catch (IOException | NullPointerException e) {
            plugin.noConnection = true;
            ServerUtils.Logger("error", "&7Проверить обновление не удалось! Плагин выключается.");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }

    public static ItemStack setItem(ItemStack itemStack, String displayName, List<String> lores) {
        ItemMeta itemStack_meta = itemStack.getItemMeta();
        itemStack_meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_UNBREAKABLE });
        itemStack_meta.setDisplayName(s(displayName));
        ArrayList<String> itemStack_lore = new ArrayList<>();
        for (String lore : lores) {
            itemStack_lore.add(s(lore));
        }
        itemStack_meta.setLore(itemStack_lore);
        itemStack.setItemMeta(itemStack_meta);
        return itemStack;
    }

    public static ItemStack setItemSkull(ItemStack itemStack, String displayName, List<String> lores) {
        SkullMeta head_owner = (SkullMeta) itemStack.getItemMeta();
        head_owner.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_UNBREAKABLE });
        itemStack.setItemMeta(head_owner);
        head_owner.setDisplayName(s(displayName));
        ArrayList<String> head_lore = new ArrayList<>();
        for (String head_lores : lores) {
            head_lore.add(s(head_lores));
        }
        head_owner.setLore(head_lore);
        itemStack.setItemMeta(head_owner);
        return itemStack;
    }

    public static List<String> stringToList(String string) {
        List<String> list = new ArrayList<>();
        list.add(string);
        return list;
    }
}
