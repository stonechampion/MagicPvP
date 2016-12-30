package com.champ.magicpvp.teams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

public class TeamManager {
	
	
	
	private HashMap<String, Team> teams = new HashMap<>();
	private HashMap<UUID, String> players = new HashMap<>();
	
	public static TeamManager instance;  

	public TeamManager() {
	    instance = this;
	}

	public static TeamManager getInstance(){
	    return instance;
	}
	
	public boolean createTeam(Player leader, String name){
		if (players.containsKey(leader.getUniqueId())){
			return false;
		}
		
		Team team = new Team(leader, name);
		teams.put(name, team);
		players.put(leader.getUniqueId(), name);
		return true;
		
	}
	
	public boolean addPlayer(Player player, String name, String rank){
		if (teams.containsKey(name) && !players.containsKey(player.getUniqueId())){
			Team team = teams.get(name);
			team.addMember(player, rank);
			players.put(player.getUniqueId(), name);
			return true;
		}
		return false;
	}
	
	public void removePlayer(Player player) {
	    if (players.containsKey(player.getUniqueId())) {
	    	
	        String name = players.get(player.getUniqueId());  
	        players.remove(player.getUniqueId());  
	        
	        Team team = teams.get(name);  
	        String rank = team.getRank(player);  
	        team.removeMember(player);  
	        
	        if (rank.equals("owner")) { 
	            Set<UUID> members = team.getMembers();
	            
	            for (UUID uuid : members) {
	                players.remove(uuid);   
	            }
	            teams.remove(name);  
	        }
	    }
	}
	
	public boolean isInTeam(Player player) {
	    return players.containsKey(player.getUniqueId());
	}

	public String getTeam(Player player) {
		
	    if (players.containsKey(player.getUniqueId())){
	        return players.get(player.getUniqueId());
	    }
	    return null;
	}

	public Set<String> getTeams() {
	    return teams.keySet();
	}
	
	public boolean doesTeamExist(String name){
		if(teams.containsKey(name)){
			return true;
		}else {
			return false;
		}
	}
	
	public void save() throws IOException {
	    File file = new File("plugins/MagicPvP/teams.txt");
	    
	    if (!file.exists()) {
	        file.mkdirs();
	        
	        try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
		
			
        FileWriter fw = new FileWriter(file.getAbsolutePath());
		
		
		
		
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    Set<String> keySet = teams.keySet();
	    for (String name : keySet) {
	        Team team = teams.get(name);
	        bw.newLine();
	        bw.write(teams.toString());
	    }
	    bw.close();
	}
	
	public void load() throws FileNotFoundException { //Possible problems here
	    
		
	    BufferedReader r = new BufferedReader(new FileReader("plugins/MagicPvP/teams.txt"));
		
	    String line;
	    
	    try {
			while ((line = r.readLine()) != null) {
			    Team team = new Team().fromString(line);
			    teams.put(team.getName(), team);
			    Set<UUID> members = team.getMembers();
			    for (UUID uuid : members) {
			        players.put(uuid, team.getName());
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
