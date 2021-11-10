package kleksystudio.kMineSide.commands;

import kleksystudio.kMineSide.Main;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.utils.*;

import java.util.*;

public class CommandLog implements CommandExecutor {

    private static Main plugin = Main.getPlugin();
    public static List<String> logPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            if(args.length == 1 && args[0].equals("on")) {
                if (p.hasPermission(plugin.getConfig().getString("messages.perms.log", "kleksymineside.log"))) {
                    if(logPlayers.contains(p.getName())) {
                        p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.log.enableAlready", "&c&lИНФОРМАЦИЯ: &fЛоги уже были &aвключены&f!")));
                        return true;
                    }
                    p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.log.enable", "&c&lИНФОРМАЦИЯ: &fЛоги были &aвключены&f!")));
                    logPlayers.add(p.getName());
                    return true;
                }
                p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.noPermission", "&c&lMINE&f&lSIDE&8&l: &fУ вас &cнедостаточно &fправ")));
                return true;
            }else if(args.length == 1 && args[0].equals("off")) {
                if (p.hasPermission(plugin.getConfig().getString("messages.perms.log", "kleksymineside.log"))) {
                    if(!logPlayers.contains(p.getName())) {
                        p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.log.disableAlready", "&c&lИНФОРМАЦИЯ: &fЛоги уже были &cвыключены&f!")));
                        return true;
                    }
                    p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.log.disable", "&c&lИНФОРМАЦИЯ: &fЛоги были &cвыключены&f")));
                    logPlayers.remove(p.getName());
                    return true;
                }
                p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.noPermission", "&c&lMINE&f&lSIDE&8&l: &fУ вас &cнедостаточно &fправ")));
                return true;
            }
            List<String> list = plugin.getConfig().getStringList("messages.log.usage");
            for (String h : list) {
                p.sendMessage(ServerUtils.s(h));
            }
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }

}
