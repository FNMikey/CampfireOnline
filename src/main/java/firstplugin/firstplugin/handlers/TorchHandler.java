package firstplugin.firstplugin.handlers;

import firstplugin.firstplugin.CampfireOnline;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TorchHandler implements Listener {

    public TorchHandler(CampfireOnline plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }


    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event){
        Block block = event.getBlock();

        if(block.getType() != Material.TORCH) {
            return;
        }

        event.getBlock().setType(Material.DIAMOND_BLOCK);

    }
}
