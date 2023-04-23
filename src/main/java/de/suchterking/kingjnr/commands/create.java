package de.suchterking.kingjnr.commands;

import de.suchterking.kingjnr.KingJNR;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import de.suchterking.kingjnr.KingJNR.*;

import java.util.ArrayList;
import java.util.List;

public class create implements CommandExecutor, TabCompleter {

    FileConfiguration config = KingJNR.config();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (args.length == 2) {
            if (args[0].equals("create")) {
                config.set("jnr", args[1]);
                config.set("jnr." + args[1] + ".name", args[2]);
            }
        }else {
            player.sendMessage("§4[KINGJNR] Bitte nutze /kingjnr <create / delete> <name>");
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> list = new ArrayList<>();
        list.add("create");
        list.add("delete");
        return list;
    }
}
