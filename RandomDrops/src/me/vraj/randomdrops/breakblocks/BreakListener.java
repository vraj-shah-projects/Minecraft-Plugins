package me.vraj.randomdrops.breakblocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.vraj.randomdrops.Main;

public class BreakListener implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public BreakListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	public int maxDroppedItemAmount = 5;	
	
	//hash map for storing previously broken blocks and their item drops
	HashMap<Material, ItemStack> brokenBlocks = new HashMap<Material, ItemStack>();
	
	//list of all droppable items in the game 
	List<Material> materials = Arrays.stream(Material.values()).filter(Material::isItem).collect(Collectors.toList());
	
	public int getRandom(int a,int b) {
	  return (int) Math.round((Math.random()*b)+a);
	}
	
	//get random material from the list
	public Material getRandomItem() {		
		Material randomItem = materials.get(getRandom(0, materials.size() - 1));
	  
		return randomItem;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		//turn the block's original drops off
		e.setDropItems(false);
		
		Player p = e.getPlayer();
		World w = p.getWorld();
		
		Material brokenBlock = e.getBlock().getType();
		ItemStack returnedItems;
		
		Location blockLocation = e.getBlock().getLocation();

		//if the block is already in the hash map (broken before)
		if (brokenBlocks.containsKey(brokenBlock)) {
			
			returnedItems = brokenBlocks.get(brokenBlock);
		}
		
		//if this is a new block (has not been broken before)
		else {
			
			int randomAmount = getRandom(1, maxDroppedItemAmount);
			ItemStack randomItem = new ItemStack(getRandomItem(), randomAmount);
			
			brokenBlocks.put(brokenBlock, randomItem);
			
			returnedItems = randomItem;
		}
		w.dropItem(blockLocation, returnedItems);
		
		System.out.println("Broken block: " + brokenBlock.toString());
		System.out.println("Returned Item: " + returnedItems.getType().toString() + ", Amount: " + returnedItems.getAmount());
	} 
}

