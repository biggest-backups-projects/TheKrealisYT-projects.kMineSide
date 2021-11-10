package kleksystudio.kMineSide.commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;

public class CommandTops implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            List<String> list = plugin.getConfig().getStringList("messages.warps.tops");
            for (String h : list) {
                p.sendMessage(ServerUtils.s(h));
            }
            p.teleport(new Location(Bukkit.getServer().getWorld(plugin.getConfig().getString("settings.worlds.spawn", "spawn")), -46.5F, 55F, -36.5F, -179.9F, -2F));
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }
}
