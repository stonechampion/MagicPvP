package com.champ.magicpvp;


import org.bukkit.plugin.java.JavaPlugin;

import com.champ.magicpvp.commands.Hologram;
import com.champ.magicpvp.commands.Kit;
import com.champ.magicpvp.commands.Team;



public class HCFPlugin extends JavaPlugin {
	
	
	HCFPlugin instance;
	
	public void onEnable(){
		instance = this;
		getCommand("kit").setExecutor(new Kit());
		getCommand("holo").setExecutor(new Hologram());
		getCommand("team").setExecutor(new Team());
		
		saveDefaultConfig();
		
	}
	
	public void onDisable(){
		
	}
	
	public HCFPlugin getInstance(){
		return instance;
	}

}
