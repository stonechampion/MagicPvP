package com.champ.magicpvp.teams;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Team {
	
	private String name;
	private HashMap<UUID, String> members = new HashMap<UUID, String>();
	
	public static Team instance;
	
	public Team(Player leader, String name){
		instance = this;
		this.name = name;
		members.put(leader.getUniqueId(), "leader");
	}
	
	public Team(){
		
	}
	
	public static Team getInstance(){
		return instance;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isInTeam(Player player){
		return members.containsKey(player.getUniqueId());
	}
	
	public Set<UUID> getMembers(){
		return members.keySet();
	}
	
	public UUID getLeader(){
		Set<UUID> keySet = members.keySet();
		for(UUID uuid : keySet){
			if (members.get(uuid).equals("leader")){
				return uuid;
			}
		}
		return null;
	}
	
	public void addMember(Player player, String rank){
		members.put(player.getUniqueId(), rank);
	}
	
	public void removeMember(Player player){
		if (members.containsKey(player.getUniqueId())){
			members.remove(player.getUniqueId());
		}
	}
	
	public String getRank(Player player) {
	    if (members.containsKey(player.getUniqueId())){
	    	return members.get(player.getUniqueId());
	    }
	    return null;
	    
	    
	}
	
	
	
	@Override 
	public String toString() { 
	    StringBuilder builder = new StringBuilder();
	    builder.append(name + ";");
	    Set<UUID> keySet = members.keySet();
	    for (UUID uuid : keySet) {
	        builder.append(uuid.toString() + ":" + members.get(uuid) + "|");
	    }
	    builder.setLength(builder.length() - 1);
	    return builder.toString();
	}
	
	public Team fromString(String rawTeam) {
	    String[] s1 = rawTeam.split(";");
	    this.name = s1[0];
	    String[] players = s1[1].split("|");
	    for (String player : players) {
	        String[] information = player.split(":");
	        members.put(UUID.fromString(information[0]), information[1]);
	    }
	    return this;
	}

}
