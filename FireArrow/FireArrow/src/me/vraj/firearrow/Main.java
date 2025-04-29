package me.vraj.firearrow;

import me.vraj.firearrow.ignite.BlockListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        new BlockListener(this);
    }
}
