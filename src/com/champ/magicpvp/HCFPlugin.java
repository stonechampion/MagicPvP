package com.champ.magicpvp;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.champ.magicpvp.commands.Hologram;
import com.champ.magicpvp.commands.Kit;
import com.champ.magicpvp.commands.TeamCommand;
import com.champ.magicpvp.teams.Team;
import com.champ.magicpvp.teams.TeamManager;



public class HCFPlugin extends JavaPlugin {
	
	
	TeamManager tm;
	Team team;
	
	public static HCFPlugin instance;
	
	public void onEnable(){
		instance = this;
		
		getCommand("kit").setExecutor(new Kit());
		getCommand("holo").setExecutor(new Hologram());
		getCommand("team").setExecutor(new TeamCommand());
		
		
		
		try {
			tm.getInstance().load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saveDefaultConfig();
		
	}
	
	public void onDisable(){
		try {
			tm.getInstance().save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static HCFPlugin getInstance(){
		return instance;
	}

}
