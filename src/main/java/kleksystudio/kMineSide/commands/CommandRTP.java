package kleksystudio.kMineSide.commands;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import kleksystudio.kMineSide.*;
import kleksystudio.kMineSide.utils.*;

public class CommandRTP implements CommandExecutor {

    private static Main plugin = Main.getPlugin();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if(args.length == 0) {
                SafeLocation(p);
                return true;
            }else if(args.length == 1 && args[0].equals("pvp")) {
                if(p.hasPermission(plugin.getConfig().getString("settings.perms.rtp", "rtp.pvp"))) {
                    PlayerLocation(p);
                    return true;
                }
                SafeLocation(p);
                return true;
            }
            SafeLocation(p);
            return true;
        }
        s.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.usePlayers", "&c&lMINE&f&lSIDE&8&l: &fТолько для игроков!")));
        return true;
    }

    public void PlayerLocation(Player p) {
        int coords = plugin.getConfig().getInt("settings.rtp.coords", 3000);
        String world = plugin.getConfig().getString("settings.rtp.world", "world");
        String nearby = plugin.getConfig().getString("messages.rtp.pvp", "&c&lРТП: &fВы были телепортироаны на координаты &a$x&f, &a$y&f, &a$z&f. Игроков поблизости: &a$nearPlayers");
        String online = plugin.getConfig().getString("messages.rtp.online", "&c&lРТП: &fВы один!");
        if (coords <= 0 || coords > 50000000) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cКоординаты должны быть не меньше/не равны 0 и не больше 50 миллионов!");
        }
        if (Bukkit.getServer().getWorld(world.replace("$worldPlayer", p.getWorld().getName())).equals(null)) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cМир не найден!");
        }
        if(nearby.equals(null)) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cСообщение рандомной телепортации не найдено!");
        }
        if(online.equals(null)) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cСообщений об онлайне не найдено!");
        }
        World worldTeleport = Bukkit.getServer().getWorld(world.replace("$worldPlayer", p.getWorld().getName()));
        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().equals(worldTeleport) && !player.equals(p)) {
                players.add(player);
            }
        }
        if(players.size() <= 1) {
            p.sendMessage(ServerUtils.s(online));
        }
        Random random = new Random();
        Player randomPlayer = players.get(random.nextInt(players.size()));
        int x = (int)randomPlayer.getLocation().getX() + random.nextInt(200);
        int z = (int)randomPlayer.getLocation().getZ() + random.nextInt(200);
        int y = randomPlayer.getWorld().getHighestBlockYAt(x, z);
        int nearbyPlayers = 0;
        for (Player near : Bukkit.getOnlinePlayers()) {
            if (!p.equals(near) && near.getWorld().equals(worldTeleport)) {
                Double locX, locZ, distance;
                if (near.getLocation().getX() > p.getLocation().getX()) {
                    locX = Double.valueOf(near.getLocation().getX() - p.getLocation().getX());
                } else {
                    locX = Double.valueOf(p.getLocation().getX() - near.getLocation().getX());
                }
                if (near.getLocation().getZ() > p.getLocation().getZ()) {
                    locZ = Double.valueOf(near.getLocation().getZ() - p.getLocation().getZ());
                } else {
                    locZ = Double.valueOf(p.getLocation().getZ() - near.getLocation().getZ());
                }
                distance = Double.valueOf(Math.sqrt(Math.pow(locX.doubleValue(), 2.0D) + Math.pow(locZ.doubleValue(), 2.0D)));
                if (distance <= 100) {
                    nearbyPlayers += 1;
                }
            }
        }
        p.teleport(new Location(worldTeleport, x, y, z));
        p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.rtp.pvp")
                .replace("$x", String.valueOf(x))
                .replace("$y", String.valueOf(y))
                .replace("$z", String.valueOf(z))
                .replace("$world", worldTeleport.toString())
                .replace("$nearbyPlayers", String.valueOf(nearbyPlayers))
        ));
    }

    public void SafeLocation(Player p) {
        int coords = plugin.getConfig().getInt("settings.rtp.coords", 3000);
        String world = plugin.getConfig().getString("settings.rtp.world", "world");
        String nearby = plugin.getConfig().getString("messages.rtp.pvp", "&c&lРТП: &fВы были телепортироаны на координаты &a$x&f, &a$y&f, &a$z&f. Игроков поблизости: &a$nearPlayer");
        if (coords <= 0 || coords > 50000000) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cКоординаты должны быть не меньше/не равны 0 и не больше 50 миллионов!");
        }
        if (Bukkit.getServer().getWorld(world.replace("$worldPlayer", p.getWorld().getName())).equals(null)) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cМир не найден!");
        }
        if(nearby.equals(null)) {
            ServerUtils.Logger("error", "&7При рандомной телепортации игроком &e" + p.getName() + " &7произошла ошибка: &cСообщение телепортации к игрокам не найдено!");
        }
        Random random = new Random();
        int x = TypeCoords(random.nextInt(plugin.getConfig().getInt("settings.rtp.coords")));
        int y = 255;
        int z = TypeCoords(random.nextInt(plugin.getConfig().getInt("settings.rtp.coords")));
        World worldTeleport = Bukkit.getServer().getWorld(world.replace("$worldPlayer", p.getWorld().getName()));
        Location loc = new Location(worldTeleport, x, y, z);
        loc.setY(loc.getWorld().getHighestBlockYAt(loc));
        p.teleport(loc);
        p.sendMessage(ServerUtils.s(plugin.getConfig().getString("messages.rtp.safe")
                .replace("$x", String.valueOf(x))
                .replace("$y", String.valueOf(y))
                .replace("$z", String.valueOf(z))
                .replace("$world", worldTeleport.toString())
        ));
    }

    public static int TypeCoords(int i) {
        Random random = new Random();
        int r = random.nextInt(2);
        switch (r) {
            case 0:
                return i *= -1;
            case 1:
                return i;
        }
        return i *= -1;
    }
}
