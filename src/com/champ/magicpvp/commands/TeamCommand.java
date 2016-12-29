package com.champ.magicpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.champ.magicpvp.HCF;
import com.champ.magicpvp.teams.Team;
import com.champ.magicpvp.teams.TeamManager;

import net.md_5.bungee.api.ChatColor;

public class TeamCommand implements CommandExecutor {
	
	HCF hcf;
	
	private TeamManager tm;
	private Team team;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("team")){
			if (args.length == 0){
				player.sendMessage(ChatColor.GRAY + "_-_-_-_-_-_-" + " Help " + "_-_-_-_-_-_-");
				player.sendMessage("");
				player.sendMessage(ChatColor.AQUA + "/team create <name>");
				player.sendMessage(ChatColor.AQUA + "/team disband <name>");
				player.sendMessage(ChatColor.AQUA + "/team display <name>");
				return true;
			}
			
			else if(args[0].equals("create")){
				
				if(args.length == 1){
					player.sendMessage(ChatColor.RED + "Please name your team");
					return true;
					
				}
				
				else if (args.length == 3){
					
					player.sendMessage(ChatColor.RED + "Your team can only have one name");
					return true;
				} 
				
				else {
					
					String teamName = args[2];
					
					//TODO: Test Create Team Command. (Fingers Crossed :D)
					tm.createTeam(player, teamName);
					
				}
			} 
			
			else if (args[0].equals("join")){
				
				if(args.length == 1){
					
					player.sendMessage(ChatColor.RED + "Please choose a Team name");
					
					
				} else if (args.length == 2) {
					
					//TODO: Test Join Team Command
					team.addMember(player, "member");
					
				}
			}
		}
		return false;
	}

}
