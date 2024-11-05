package firstplugin.firstplugin.handlers;

import firstplugin.firstplugin.CampfireOnline;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import java.util.HashMap;
import java.util.UUID;


public class PlayerHandler implements Listener {

    private final HashMap<UUID, Block> playerCampfires = new HashMap<>();
    public PlayerHandler(CampfireOnline plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        Block campfire = playerCampfires.get(player.getUniqueId());

        if (campfire != null && campfire.getType() == Material.CAMPFIRE) {
            campfire.setBlockData(Bukkit.createBlockData(Material.CAMPFIRE, "[lit=true]"));
            player.sendMessage("Twoje ognisko zostało zapalone.");
            Bukkit.getLogger().info("Ognisko gracza " + player.getName() + " zostalo zapalone!");
        }

    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() == Material.CAMPFIRE) {
                Player player = event.getPlayer();
                playerCampfires.put(player.getUniqueId(), block);
                player.sendMessage("Przypisano ognisko!");
                Bukkit.getLogger().info("Ognisko gracza " + player.getName() + " zostalo przypisane!");
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Block campfire = playerCampfires.get(player.getUniqueId());
        if (campfire != null && campfire.getType() == Material.CAMPFIRE) {
            campfire.setBlockData(Bukkit.createBlockData(Material.CAMPFIRE, "[lit=false]"));
            player.sendMessage("Twoje ognisko zostało zgaszone.");
            Bukkit.getLogger().info("Ognisko gracza " + player.getName() + " zostalo zgaszone!");
        }
    }





//    @EventHandler
//    public void RightClickOnBlock(PlayerInteractEvent event) {
//
//
//        if(event.getAction() != Action.RIGHT_CLICK_BLOCK || event.hasItem() || event.getClickedBlock().getType() != Material.CAMPFIRE || event.getHand() != EquipmentSlot.HAND){
//            return;
//        }
//        if(event.getClickedBlock().getState() instanceof TileState){
//            return;
//        }
//
//        Block clickedBlock = event.getClickedBlock();
//        Player player = event.getPlayer();
//
//
//        BlockData blockData = event.getClickedBlock().getBlockData();
//        org.bukkit.block.data.type.Campfire campfireData = (org.bukkit.block.data.type.Campfire) blockData;
//        campfireData.setLit(!campfireData.isLit());
//        clickedBlock.setBlockData(campfireData);
//
//
//        TileState state = (TileState) clickedBlock.getState();
//        PersistentDataContainer container = state.getPersistentDataContainer();
//        NamespacedKey key = new NamespacedKey(CampfireOnline.getPlugin(CampfireOnline.class), "personal-campfire");
//        container.set(key, PersistentDataType.STRING, player.getUniqueId().toString());
//        state.update();
//
//        player.sendMessage(ChatColor.GREEN + "This is now your campfire");
//
//
//    }


}
