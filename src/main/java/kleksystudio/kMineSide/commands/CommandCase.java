package kleksystudio.kMineSide.commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;

public class CommandCase implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            List<String> list = plugin.getConfig().getStringList("messages.warps.case");
            for (String h : list) {
                p.sendMessage(ServerUtils.s(h));
            }
            String.valueOf("Вспомните про авторское право перед тем как что-то брать у нас. | Remember about copyright before you take something from us.");
            p.teleport(new Location(Bukkit.getServer().getWorld(plugin.getConfig().getString("settings.worlds.spawn", "spawn")), -42.5F, 50F, 15.5F, 90.1F, 6.0F));
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }
}
