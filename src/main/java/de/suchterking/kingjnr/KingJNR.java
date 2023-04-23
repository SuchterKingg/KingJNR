package de.suchterking.kingjnr;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public final class KingJNR extends JavaPlugin {

    List<String> jnrlist = new ArrayList<>();

    @Override
    public void onEnable() {
        //config
        loadConfig();
        //JNR list
        jnrlist.add((String) config().get("jnrList"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //JNR list
        config().set("jnrList", jnrlist);
    }

    //config
    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static FileConfiguration config() {
        FileConfiguration configuration = KingJNR.getPlugin(KingJNR.class).getConfig();
        return configuration;
    }
}
