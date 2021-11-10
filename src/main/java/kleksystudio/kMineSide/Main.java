package kleksystudio.kMineSide;

import org.bukkit.*;
import org.bukkit.plugin.java.*;
import kleksystudio.kMineSide.utils.*;
import kleksystudio.kMineSide.commands.*;

public class Main extends JavaPlugin {

    private static Main plugin;
    public static boolean noConnection = false;

    @Override
    public void onEnable() {
        plugin = this;
        ServerUtils.Logger("info", "&7Запуск плагина &eKleksyMineSide &7версии &e" + getDescription().getVersion() + " &7от &evk.com/kleksystudio");
        ServerUtils.Logger("warning", "&7Проверка на наличие обновлений плагина...");
        new ServerUtils().getLatestVersion(version -> {
            if(!getDescription().getVersion().equals("2.0")) {
                ServerUtils.Logger("error", "&7Была обнаружена попытка взлома обновлений! Плагин выключается!");
                Bukkit.getServer().getPluginManager().disablePlugin(this);
            }else{
                if(!noConnection) {
                    if (!getDescription().getVersion().equals(version)) {
                        ServerUtils.Logger("warning", "&7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        ServerUtils.Logger("warning", "&7Ваша версия: &e" + getDescription().getVersion());
                        ServerUtils.Logger("warning", "&7Версия обновления: &e" + version);
                        ServerUtils.Logger("warning", "&7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        ServerUtils.Logger("warning", "&7Купить обновлённую версию плагина: &6https://vk.me/kleksystudio");
                        String.valueOf("Изменения кода категорически запрещены! | Code changes are strictly prohibited!");
                        Bukkit.getServer().getPluginManager().disablePlugin(this);
                    } else {
                        ServerUtils.Logger("info", "&7Вы используете последнюю версию плагина! Версия: &e" + version);
                        saveDefaultConfig();
                        //   getCommand("grant").setExecutor(new CommandGrant());
                        if(plugin.getConfig().getBoolean("settings.advancements")) {
                            for (World w : Bukkit.getServer().getWorlds()) {
                                w.setGameRuleValue("announceAdvancements", "false");
                            }
                        }
                        saveDefaultConfig();
                        getCommand("case").setExecutor(new CommandCase());
                        getCommand("log").setExecutor(new CommandLog());
                        getCommand("mine").setExecutor(new CommandMine());
                        getCommand("portals").setExecutor(new CommandPortals());
                        getCommand("pvp").setExecutor(new CommandPvp());
                        getCommand("quest").setExecutor(new CommandQuest());
                        getCommand("rtp").setExecutor(new CommandRTP());
                        getCommand("shops").setExecutor(new CommandShops());
                        getCommand("soul").setExecutor(new CommandSoul());
                        getCommand("tops").setExecutor(new CommandTops());
                        getCommand("trader").setExecutor(new CommandTrader());
                        getCommand("wood").setExecutor(new CommandWood());
                    }
                }
            }
        });
    }

    @Override
    public void onDisable() {}

    public static Main getPlugin() {
        return plugin;
    }
}