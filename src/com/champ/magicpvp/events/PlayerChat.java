package com.champ.magicpvp.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.champ.magicpvp.teams.Team;
import com.champ.magicpvp.teams.TeamManager;


public class PlayerChat implements Listener {
	
	TeamManager tm;
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		
		Player player = event.getPlayer();
		
		if(tm.isInTeam(player)){
			Team team = new Team();
			
			event.getMessage().format(ChatColor.GRAY + "[" + team.getInstance().getName() + "]" + " " + player.getName(), event.getMessage());
			
		} else {
			
			event.getMessage().format(ChatColor.GRAY + player.getName(), event.getMessage());
			
		}
		
	}

}
