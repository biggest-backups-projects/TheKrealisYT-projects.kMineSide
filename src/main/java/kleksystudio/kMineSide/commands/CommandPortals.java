package kleksystudio.kMineSide.commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;

public class CommandPortals implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            List<String> list = plugin.getConfig().getStringList("messages.warps.portals");
            for (String h : list) {
                p.sendMessage(ServerUtils.s(h));
            }
            p.teleport(new Location(Bukkit.getServer().getWorld(plugin.getConfig().getString("settings.worlds.spawn", "spawn")), 7.5F, 56F, 84F, -89.9F, 0F));
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }
}
