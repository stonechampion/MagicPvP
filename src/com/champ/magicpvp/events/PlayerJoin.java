package com.champ.magicpvp.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.champ.magicpvp.HCF;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		
		HCF.getInstance().setupMainScoreboard(player);
		HCF.getInstance().setupRankScoreBoard(player);
		
	}

}
