package nl.martenm.servertutorialplus.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BlockInteractEvent implements Listener{

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();
            World world = attacker.getWorld();
            // Supongamos que el nombre del mundo es "tutorial".
            if (world.getName().equalsIgnoreCase("tutorial")) {
                // Cancelar el evento si el jugador intenta dañar a otro jugador en el mundo "tutorial".
                event.setCancelled(true);
            }
        }
    }
}
