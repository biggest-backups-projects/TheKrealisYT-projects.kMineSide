package kleksystudio.kMineSide.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Menus {

    public static void QuestMenu(Player p) {
        Inventory gui = Bukkit.createInventory(p, 54, ServerUtils.s("&0Выбор квестов"));

        ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
        ItemStack coal = new ItemStack(Material.COAL, 1);
        ItemStack wheat = new ItemStack(Material.WHEAT, 1);
        ItemStack iron_axe = new ItemStack(Material.IRON_AXE, 1);
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemStack gold_sword = new ItemStack(Material.GOLD_SWORD, 1);
        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);

        gui.setItem(0, ServerUtils.setItem(panel, null, null));
        gui.setItem(1, ServerUtils.setItem(panel, null, null));
        gui.setItem(7, ServerUtils.setItem(panel, null, null));
        gui.setItem(8, ServerUtils.setItem(panel, null, null));
        gui.setItem(9, ServerUtils.setItem(panel, null, null));
        gui.setItem(17, ServerUtils.setItem(panel, null, null));
        gui.setItem(18, ServerUtils.setItem(panel, null, null));
        gui.setItem(26, ServerUtils.setItem(panel, null, null));
        gui.setItem(27, ServerUtils.setItem(panel, null, null));
        gui.setItem(35, ServerUtils.setItem(panel, null, null));
        gui.setItem(36, ServerUtils.setItem(panel, null, null));
        gui.setItem(44, ServerUtils.setItem(panel, null, null));
        gui.setItem(45, ServerUtils.setItem(panel, null, null));
        gui.setItem(46, ServerUtils.setItem(panel, null, null));
        gui.setItem(52, ServerUtils.setItem(panel, null, null));
        gui.setItem(53, ServerUtils.setItem(panel, null, null));

        gui.setItem(20, ServerUtils.setItem(coal, "&c&lКвест Шахтёра",
                ServerUtils.stringToList("\n\n&c&l⧫ &fСуть квеста заключаеться\n&c&l⧫ &fВ добыче руды в шахтах!\n\n&a&nНажми, чтобы пройти дальше")
        ));
        gui.setItem(21, ServerUtils.setItem(wheat, "&c&lКвест Фермера",
                ServerUtils.stringToList("\n\n&c&l⧫ &fСобирай урожай и повышай\n&c&l⧫ &fНавыки фермерства\n\n&a&nНажми, чтобы пройти дальше")
        ));
        gui.setItem(22, ServerUtils.setItem(iron_axe, "&c&lКвест Дровосека",
                ServerUtils.stringToList("\n\n&c&l⧫ &fРуби дерево и &aполучай призы\n&c&l⧫ &fЗа свою &c&lработу\n\n&a&nНажми, чтобы пройти дальше")
        ));
        gui.setItem(23, ServerUtils.setItem(bow, "&c&lКвест Охотника",
                ServerUtils.stringToList("\n\n&c&l⧫ &fУбивай животных, чтобы\n&c&l⧫ &fПолучать крутые плюшки\n\n&a&nНажми, чтобы пройти дальше")
        ));
        gui.setItem(24, ServerUtils.setItem(gold_sword, "&c&lКвест Киллера",
                ServerUtils.stringToList("\n\n&c&l⧫ &fСтановись киллером и\n&c&l⧫ &fПобеждай своих &c&lврагов!\n\n&a&nНажми, чтобы пройти дальше")
        ));
        gui.setItem(40, ServerUtils.setItemSkull(
                Head.getHeadByTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQ5ZDI3MWM1ZGY4NGY4YTNjOGFhNWQxNTQyN2Y2MjgzOTM0MWRhYjUyYzYxOWE1OTg3ZDM4ZmJlMThlNDY0In19fQ=="),
                "&c&lНАЗАД В МЕНЮ",
                ServerUtils.stringToList("\n\n&c&l⧫ &fПерейти в меню\n&a&nНажми, чтобы перейти в меню")
        ));

        p.openInventory(gui);
    }

    public static void QuestMineMenu(Player p) {
        Inventory gui = Bukkit.createInventory(p, 54, ServerUtils.s("&0Квест шахтёра"));

        ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
        ItemStack coal = new ItemStack(Material.COAL, 1);
        ItemStack iron_ingot = new ItemStack(Material.IRON_INGOT, 1);
        ItemStack gold_ingot = new ItemStack(Material.GOLD_INGOT, 1);
        ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        ItemStack diamond_pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);

        gui.setItem(0, ServerUtils.setItem(panel, null, null));
        gui.setItem(1, ServerUtils.setItem(panel, null, null));
        gui.setItem(7, ServerUtils.setItem(panel, null, null));
        gui.setItem(8, ServerUtils.setItem(panel, null, null));
        gui.setItem(9, ServerUtils.setItem(panel, null, null));
        gui.setItem(17, ServerUtils.setItem(panel, null, null));
        gui.setItem(18, ServerUtils.setItem(panel, null, null));
        gui.setItem(26, ServerUtils.setItem(panel, null, null));
        gui.setItem(27, ServerUtils.setItem(panel, null, null));
        gui.setItem(35, ServerUtils.setItem(panel, null, null));
        gui.setItem(36, ServerUtils.setItem(panel, null, null));
        gui.setItem(44, ServerUtils.setItem(panel, null, null));
        gui.setItem(45, ServerUtils.setItem(panel, null, null));
        gui.setItem(46, ServerUtils.setItem(panel, null, null));
        gui.setItem(52, ServerUtils.setItem(panel, null, null));
        gui.setItem(53, ServerUtils.setItem(panel, null, null));

        gui.setItem(11, ServerUtils.setItem(coal, "&c&lПервый Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c100 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l550 $\n  &7► &fОПЫТ - &c&l15xp give\n&a&nНажми, чтобы взять вашу награду  ")
        ));
        gui.setItem(12, ServerUtils.setItem(coal, "&c&lВторой Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c500 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l2600 $\n  &7► &fОПЫТ - &c&l35xp give\n&a&nНажми, чтобы взять вашу награду  ")
        ));
        gui.setItem(13, ServerUtils.setItem(coal, "&c&lТретий Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c1000 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l3300 $\n  &7► &fОПЫТ - &c&l60xp give\n&a&nНажми, чтобы взять вашу награду  ")
        ));
        gui.setItem(14, ServerUtils.setItem(coal, "&c&lЧетвёртый Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c2500 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l5200 $\n  &7► &fОПЫТ - &c&l150xp give\n&a&nНажми, чтобы взять вашу награду  ")
        ));
        gui.setItem(15, ServerUtils.setItem(coal, "&c&lПятный Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c5000 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l13000 $\n  &7► &fОПЫТ - &c&l250xp give\n&a&nНажми, чтобы взять вашу награду  ")
        ));
        gui.setItem(21, ServerUtils.setItem(coal, "&c&lШестой Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c10000 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l15000 $\n  &7► &fОПЫТ - &c&l300xp give\n  &7► &fКирка - &cАлмазная э5 п3\n&a&nНажми, чтобы взять вашу награду    ")
        ));
        gui.setItem(23, ServerUtils.setItem(coal, "&c&lСедьмой Квест",
                ServerUtils.stringToList("\n\n&c&l⧫ &fНужно добыть &c15000 &fлюбой руды\n&c&l⧫ &fВперёд в шахту за добычей!\n &fВаша награда:\n  &7► &fВалюта - &c&l18000 $\n  &7► &fОПЫТ - &c&l400xp give\n  &7► &fДоступ - &cОткрывается &lСТРЕЛЫ ЛЕВИТАЦИИ &cза &a$   \n&a&nНажми, чтобы взять вашу награду")
        ));
        gui.setItem(40, ServerUtils.setItemSkull(
                Head.getHeadByTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQ5ZDI3MWM1ZGY4NGY4YTNjOGFhNWQxNTQyN2Y2MjgzOTM0MWRhYjUyYzYxOWE1OTg3ZDM4ZmJlMThlNDY0In19fQ=="),
                "&c&lНАЗАД В МЕНЮ",
                ServerUtils.stringToList("\n\n&c&l⧫ &fПерейти в меню\n&a&nНажми, чтобы перейти в меню")
        ));

        p.openInventory(gui);
    }

    public static void QuestFermerMenu(Player p) {

    }

    public static void QuestAxeMenu(Player p) {
    }

    public static void QuestBowMenu(Player p) {
    }

    public static void QuestKillMenu(Player p) {
    }
}
