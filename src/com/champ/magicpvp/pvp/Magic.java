package com.champ.magicpvp.pvp;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.champ.magicpvp.utils.ParticleEffect;

public class Magic {
	
	public void castStickBeam(Player player){
		
		Location loc = player.getLocation();
		Vector direction = loc.getDirection();
		
		player.getLocation().getWorld().playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, 2);
		outerloop: for(double t = 0; t < 16; t+=1){
			
			loc.add(direction);
			loc.add(0,1.5, 0);
			
			ParticleEffect.CLOUD.display(0, 0, 0, 0.05F, 2, loc, 30);
			
			
			
			if (loc.getBlock().getType().isSolid()){
                ParticleEffect.CLOUD.display(0, 0, 0, 0.13F, 50, loc, 30);
                break outerloop;
            }
			
			
			
			for (Entity e : loc.getChunk().getEntities()) {
				if (e.getLocation().distance(loc) < 1.5) {
					if (e != (player)){
						if(e.getType().isAlive()) {
							Damageable d = (Damageable) e;
                            d.damage(5, player);
                            ParticleEffect.CLOUD.display(0, 0, 0, 0.13F, 50, loc, 30);
                            break outerloop;
						}
					}
				}
			}
			loc.subtract(0, 1.5, 0);
			 
		}
	}
	

	public void castBlazeBeam(Player player){
		
		Location loc = player.getLocation();
		Vector direction = loc.getDirection();
		
		player.getLocation().getWorld().playSound(loc, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, 2);
		outerloop: for(double t = 0; t < 16; t+=1){
			
			loc.add(direction);
			loc.add(0,1.5, 0);
			
			ParticleEffect.FLAME.display(0, 0, 0, 0.05F, 2, loc, 30);
			
			
			
			if (loc.getBlock().getType().isSolid()){
                ParticleEffect.FLAME.display(0, 0, 0, 0.13F, 50, loc, 30);
                break outerloop;
            }
			
			
			
			for (Entity e : loc.getChunk().getEntities()) {
				if (e.getLocation().distance(loc) < 1.5) {
					if (e != (player)){
						if(e.getType().isAlive()) {
							Damageable d = (Damageable) e;
                            d.damage(5, player);
                            ParticleEffect.FLAME.display(0, 0, 0, 0.13F, 50, loc, 30);
                            break outerloop;
						}
					}
				}
			}
			loc.subtract(0, 1.5, 0);
			 
		}
		
	}
	
	
	
	

}
