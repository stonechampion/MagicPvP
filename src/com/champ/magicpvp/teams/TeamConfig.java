package com.champ.magicpvp.teams;

import java.util.UUID;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;


public class TeamConfig extends FileConfiguration {
	
	public String name;
	public UUID leader;
	
	public TeamConfig(String name, UUID leader){
		this.name = name;
		this.leader = leader;
		
		makeConfig(name, leader);
		
	}

	@Override
	protected String buildHeader() {
		return null;
	}

	@Override
	public void loadFromString(String arg0) throws InvalidConfigurationException {
		
	}

	@Override
	public String saveToString() {
		return null;
	}
	
	public void makeConfig(String name, UUID leader){
		//TODO: GENERATE CONFIG SO THAT EVERY NEW INSTANCE OF THIS OBJECT MADE HAS A CONFIG.
	}
	
	
	
	

	
	
	
	

}
