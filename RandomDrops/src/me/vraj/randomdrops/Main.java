package me.vraj.randomdrops;

import org.bukkit.plugin.java.JavaPlugin;

import me.vraj.randomdrops.breakblocks.BreakListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new BreakListener(this);
	}
}
