package com.champ.magicpvp;


import java.util.UUID;
import org.bukkit.scoreboard.Scoreboard;

import com.champ.magicpvp.teams.TeamConfig;

public class HCF {
	
	HCFPlugin plugin;
	

	
	/**
	 - kits
	 - commands: Essential Commands, Team Commands, Party Commands.
	 - Events
	 - Scoreboard
	 - Leveling System
	
	**/
	
	
	public Scoreboard sb;
	
	public void setupScoreboard(){
		
		sb.registerNewObjective("dummy", "");
	}
	
	public TeamConfig generateConfig(String name, UUID leader){
		return new TeamConfig(name, leader);
		
	}
	

}