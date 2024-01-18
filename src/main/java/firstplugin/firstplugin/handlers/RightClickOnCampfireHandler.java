package firstplugin.firstplugin.handlers;
import firstplugin.firstplugin.CampfireOnline;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class RightClickOnCampfireHandler implements Listener {

    public RightClickOnCampfireHandler(CampfireOnline plugin){

        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void RightClickOnBlock(PlayerInteractEvent interactEvent){

        Bukkit.getLogger().info(interactEvent.getAction().toString());

    }
}
