package kleksystudio.kMineSide.commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;
import org.bukkit.craftbukkit.v1_12_R1.entity.*;

public class CommandPing implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.ping", "&c&lMINE&f&lSIDE&8&l: &fВаш пинг на сервере &e&l$ping").replace("$ping", String.valueOf(((CraftPlayer)p).getHandle().ping))));
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }
}