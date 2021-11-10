package kleksystudio.kMineSide.listeners;

import kleksystudio.kMineSide.Main;
import kleksystudio.kMineSide.commands.CommandLog;
import kleksystudio.kMineSide.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.*;

public class EventListener implements Listener {

    private static Main plugin = Main.getPlugin();

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        for(Player logPlayer : Bukkit.getOnlinePlayers()) {
            if(CommandLog.logPlayers.contains(logPlayer.getName())) {
                logPlayer.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.log.logged").replace("$player", p.getName()).replace("$cmd", e.getMessage())));
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(plugin.getConfig().getBoolean("settings.join")) {
            e.setJoinMessage(null);
        }
        String.valueOf("Вспомните про авторское право перед тем как что-то брать у нас. | Remember about copyright before you take something from us.");
        /*
        Player p = e.getPlayer();
        if((p.isOp() || p.hasPermission("*")) && plugin.update && plugin.getConfig().getBoolean("settings.msgUpdate")) {
            p.sendMessage(ServerUtils.s("&6KleksyStudio &fсообщает вам об устаревшей версии сборки сервера! Подробней в консоли."));
            ServerUtils.Logger("info", "&7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            ServerUtils.Logger("info", "&7Ваша версия: &e" + plugin.getDescription().getVersion());
            ServerUtils.Logger("info", "&7Версия обновления: &e" + plugin.updateVersion);
            ServerUtils.Logger("info", "&7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            ServerUtils.Logger("info", "&7Купить обновлённую версию сборки сервера: &6https://vk.me/kleksystudio");
        } */
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(plugin.getConfig().getBoolean("settings.quit")) {
            e.setQuitMessage(null);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(plugin.getConfig().getBoolean("settings.death")) {
            e.setDeathMessage(null);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMenuClick(InventoryClickEvent e) {
        if(!e.getWhoClicked().equals(null) && e.getWhoClicked() instanceof Player && !((Player) e.getWhoClicked()).getPlayer().equals(null) && !e.getInventory().getTitle().equals(null) && !e.getClick().equals(null)) {
            if(e.getInventory().getTitle().equals(ServerUtils.s("&0Выбор квестов"))) {
                int slot = e.getRawSlot();
                Player p = ((Player) e.getWhoClicked()).getPlayer();
                if(slot == 20) {
                    Menus.QuestMineMenu(p);
                }else if(slot == 21) {
                    Menus.QuestFermerMenu(p);
                }else if(slot == 22) {
                    Menus.QuestAxeMenu(p);
                }else if(slot == 23) {
                    Menus.QuestBowMenu(p);
                }else if(slot == 24) {
                    Menus.QuestKillMenu(p);
                }else if(slot == 40) {
                    p.chat("/menu");
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPistonRetract(BlockPistonRetractEvent e) {
        if(plugin.getConfig().getBoolean("settings.pistons")) {
            List<Block> blocks = e.getBlocks();
            if (blocks != null) {
                for (Block b : blocks) {
                    e.setCancelled(false);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPistonExtend(BlockPistonExtendEvent e) {
        if(plugin.getConfig().getBoolean("settings.pistons")) {
            List<Block> blocks = e.getBlocks();
            if (blocks != null) {
                for (Block b : blocks) {
                    e.setCancelled(false);
                }
            }
        }
    }
}
