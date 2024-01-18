package firstplugin.firstplugin.handlers;

import firstplugin.firstplugin.CampfireOnline;
import firstplugin.firstplugin.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerHandler implements Listener {


    public PlayerHandler(CampfireOnline plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.SHORT_GRASS, 10);
        Inventory inventory = player.getInventory();
        inventory.addItem(item);

    }


    @EventHandler
    public void RightClickOnBlock(PlayerInteractEvent event){


        if(event.getAction() != Action.RIGHT_CLICK_BLOCK || event.hasItem() || event.getClickedBlock().getType() != Material.CAMPFIRE || event.getHand() != EquipmentSlot.HAND){
            return;
        }

        Action action = event.getAction();
        Block clickedBlock = event.getClickedBlock();
        Player player = event.getPlayer();

        BlockData blockData = event.getClickedBlock().getBlockData();
        org.bukkit.block.data.type.Campfire campfireData = (org.bukkit.block.data.type.Campfire) blockData;


        campfireData.setLit(!campfireData.isLit());
        clickedBlock.setBlockData(campfireData);


        Bukkit.getLogger().info(action.toString());
        Bukkit.getLogger().info(clickedBlock.getType().toString());

        player.sendMessage(ChatColor.GREEN + "This is now your campfire");


    }

}
