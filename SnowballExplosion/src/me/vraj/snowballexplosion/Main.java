package me.vraj.snowballexplosion;

import org.bukkit.plugin.java.JavaPlugin;

import me.vraj.snowballexplosion.explosion.SnowballBlockListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new SnowballBlockListener(this);
	}

}
