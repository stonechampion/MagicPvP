package com.champ.magicpvp.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("kit")){
			if (args.length == 0){
				player.sendMessage(ChatColor.GREEN + "/kit basic");
				return true;
			}
			
			if(args[0].equals("basic")){
				player.sendMessage(ChatColor.GREEN + "Giving kit" + ChatColor.AQUA + " basic");
				
				player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
				player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
				player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
				player.getInventory().addItem(new ItemStack(Material.STONE_SPADE));
				player.getInventory().addItem(new ItemStack(Material.APPLE));
				
			}
		}
		
		return false;
	}
	
	

}
