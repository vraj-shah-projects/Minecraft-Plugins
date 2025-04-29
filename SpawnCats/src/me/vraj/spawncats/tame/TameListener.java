package me.vraj.spawncats.tame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

import me.vraj.spawncats.Main;

public class TameListener implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public TameListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityTame(EntityTameEvent e) {
		if (e.getEntityType() == EntityType.CAT) {
			Player p = (Player) e.getOwner();
			Location loc = p.getLocation();
			World w = p.getWorld();
			
			for (int i = 0; i < 10; i++) {
				w.spawnEntity(loc, EntityType.CAT);
			}
		}
	}
}