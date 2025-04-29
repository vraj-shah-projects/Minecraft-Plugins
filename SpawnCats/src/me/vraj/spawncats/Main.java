package me.vraj.spawncats;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.vraj.spawncats.tame.TameListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new TameListener(this);
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (event.getEntityType() == EntityType.CREEPER) {
			
		}
	}
}
