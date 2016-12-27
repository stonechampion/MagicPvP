package com.champ.magicpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;



public class Hologram implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("holo")){
			if (args.length == 0){
				player.sendMessage(ChatColor.GREEN + "/holo set <name>");
			} 
			
			if (args[0].equals("set")){
				if (args.length == 1){
					player.sendMessage(ChatColor.RED + "Please name the Hologram");
					return true;
				} else{
					String message = "";
					for(int i = 1; i < args.length; i++){
						message += args[i] + " ";
					}
					
					message = message.trim();
					
					createHologram(player.getLocation(), ChatColor.translateAlternateColorCodes('&', message));
					
				}
			}
		}
		return false;
	}
	
	public void createHologram(Location l, String name){
		ArmorStand am = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
		
		am.setVisible(false);
		am.setGravity(false);
		am.setCustomName(name);
		am.setCustomNameVisible(true);
	}
	
	

}
