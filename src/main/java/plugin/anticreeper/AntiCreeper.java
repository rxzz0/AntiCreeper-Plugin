package plugin.anticreeper;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCreeper extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("AntiCreeper enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiCreeper disabled!");
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent event) {

        if (event.getEntity() instanceof Creeper) {
            event.blockList().clear();
            event.setYield(0f);
        }
    }

    @EventHandler
    public void onItemDamage(EntityDamageEvent event) {

        if (event.getEntity() instanceof Item) if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            event.setCancelled(true);
        }
    }
}