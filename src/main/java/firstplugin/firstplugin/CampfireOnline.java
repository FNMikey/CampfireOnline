package firstplugin.firstplugin;

import firstplugin.firstplugin.handlers.RightClickOnCampfireHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CampfireOnline extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getLogger().info("Serwer dziala");

//        new TorchHandler(this);

        new RightClickOnCampfireHandler(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Wylaczanie serwera");
    }
}
