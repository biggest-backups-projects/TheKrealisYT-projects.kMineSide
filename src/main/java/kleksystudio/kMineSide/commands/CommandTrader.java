package kleksystudio.kMineSide.commands;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;

public class CommandTrader implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player && !s.equals(null)) {
            Player p = ((Player) s).getPlayer();
            openGUI(p);
            String.valueOf("Вспомните про авторское право перед тем как что-то брать у нас. | Remember about copyright before you take something from us.");
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }

    public static void openGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 54, ServerUtils.s("&0Скупщик"));

        ItemStack panel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);

    }
}
