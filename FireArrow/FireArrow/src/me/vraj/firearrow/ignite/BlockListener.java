package me.vraj.firearrow.ignite;

import me.vraj.firearrow.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BlockListener implements Listener {

    public boolean arrowEnchantments = false;

    Material fire = Material.FIRE;

    private Main plugin;

    public BlockListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event) {

        if (event.getEntity() instanceof Player) {

            if (event.getBow().getEnchantments().containsKey(Enchantment.ARROW_FIRE)) {

                arrowEnchantments = true;
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        Location blockLocation = event.getHitBlock().getLocation();
        BlockFace hitBlockFace = event.getHitBlockFace();

        if (event.getEntity() instanceof Arrow) {

            if (arrowEnchantments) {

                blockLocation.getWorld().getBlockAt(blockLocation).getRelative(hitBlockFace).setType(fire);

                arrowEnchantments = false;
            }
        }
    }
}

