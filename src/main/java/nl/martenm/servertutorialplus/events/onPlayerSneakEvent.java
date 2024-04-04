package nl.martenm.servertutorialplus.events;

import nl.martenm.servertutorialplus.ServerTutorialPlus;
import nl.martenm.servertutorialplus.objects.TutorialController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class onPlayerSneakEvent implements Listener {

    private final ServerTutorialPlus plugin;
    public onPlayerSneakEvent(ServerTutorialPlus plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void playerSneakEvent(PlayerToggleSneakEvent event) {
        ServerTutorialPlus plugin = ServerTutorialPlus.getInstance();

        Player player = event.getPlayer();

        if (player.isSneaking()) {
            if (plugin.inTutorial.containsKey(player.getUniqueId())) {
                TutorialController tc = plugin.inTutorial.get(player.getUniqueId());
                tc.cancel(true);
            }
        }
    }
}
