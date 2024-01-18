package firstplugin.firstplugin.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Menu implements CommandExecutor {

    private String invName = "Server Selector";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] array) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        Inventory inventory = Bukkit.createInventory(player, 9 * 3, invName);

        inventory.setItem(11, getItem(new ItemStack(Material.DIAMOND_SWORD), "&9PVP", "&aClick to Join", "&aBattle it out in our PVP arena")) ;

        player.openInventory(inventory);

        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore){

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();

        for (String s : lore){
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;


    }
}
