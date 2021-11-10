package kleksystudio.kMineSide.commands;

import kleksystudio.kMineSide.utils.ServerUtils;
import org.bukkit.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class CommandLeave implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s.hasPermission(plugin.getConfig().getString("settings.perms.leave", "kleksystudio.leave"))) {
            if(args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target.equals(null)) {
                    s.sendMessage(ServerUtils.s(plugin.getConfig().getString("settings.noPlayer", "&c&lMINE&f&lSIDE&8&l: &fИгрок не найден!")));
                    return true;
                }
                s.sendMessage(ServerUtils.s(plugin.getConfig().getString("settings.leave.gived", "&c&lMINE&f&lSIDE&8&l: &fИгроку &e$target &fбыло выдано перо телепортации").replace("$target", target.getName())));
                ItemStack item = new ItemStack(Material.FEATHER);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ServerUtils.s("&fПеро телепортации"));
                meta.setLore(null);
                item.setItemMeta(meta);
                target.getInventory().addItem(new ItemStack[] { item });
                return true;
            }
            s.sendMessage(ServerUtils.s(plugin.getConfig().getString("settings.leave.usage", "&c&lMINE&f&lSIDE&8&l: &fИспользуйте &e/leave <Ник игрока>")));
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("settings.noPermission", "&c&lMINE&f&lSIDE&8&l: &fУ вас &cнедостаточно &fправ")));
        return true;
    }
}
