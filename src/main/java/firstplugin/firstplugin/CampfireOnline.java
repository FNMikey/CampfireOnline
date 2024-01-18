package firstplugin.firstplugin;

import firstplugin.firstplugin.commands.Fly;
import firstplugin.firstplugin.commands.Menu;
import firstplugin.firstplugin.handlers.PlayerHandler;
import firstplugin.firstplugin.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CampfireOnline extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getLogger().info("Serwer dziala");

//        new TorchHandler(this);

        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu());

        new PlayerHandler(this);

        ConfigUtil config = new ConfigUtil(this, "campfires.yml");


    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Wylaczanie serwera");

        ConfigUtil config = new ConfigUtil(this, "campfires.yml");

    }
}
