package nl.martenm.servertutorialplus.reflection.V1_8;

import nl.martenm.servertutorialplus.helpers.Color;
import nl.martenm.servertutorialplus.reflection.IProtocol;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

    /**
     * @author Didnt_
     * @since 16-04-2024.
     */
public class Protocol_1_8 implements IProtocol {

   @Override
   public void playRedstoneParticle(Player player, Location location, Color color) {
       // Convert color values from 0-255 to 0-1
       float red = color.getRed() / 255.0F;
       float green = color.getGreen() / 255.0F;
       float blue = color.getBlue() / 255.0F;
       int rgb = ((int) (red * 255) << 16) | ((int) (green * 255) << 8) | (int) (blue * 255);
       // Play the redstone dust effect
       player.playEffect(location, Effect.valueOf("REDSTONE"), rgb);
    }
}
