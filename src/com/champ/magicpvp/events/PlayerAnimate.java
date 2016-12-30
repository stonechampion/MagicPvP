package com.champ.magicpvp.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;


import com.champ.magicpvp.pvp.Magic;


public class PlayerAnimate implements Listener {
	
	Magic magic;
	
	@EventHandler
	public void onPlayerSwing(PlayerAnimationEvent event){
		Player player = event.getPlayer();
		
		if (player.getInventory().getItemInMainHand() != null){
			if(player.getInventory().getItemInHand().getType() == Material.STICK){
				
				magic.castStickBeam(player);
				
			}
		}
		
	}

}
