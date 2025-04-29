package me.vraj.snowballexplosion.explosion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.vraj.snowballexplosion.Main;

public class SnowballBlockListener implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SnowballBlockListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		
		if (e.getEntityType().equals(EntityType.SNOWBALL)) {
			
			if (e.getHitBlock() != null) {
				
				Location loc = e.getHitBlock().getLocation();
				e.getHitBlock().getWorld().createExplosion(loc, 10, false, true);
				
			}
		}
	}
}
