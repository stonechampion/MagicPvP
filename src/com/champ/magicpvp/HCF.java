package com.champ.magicpvp;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;



public class HCF {
	
	public static HCF instance;
	
	public HCF(){
		instance = this;
	}
	
	HCFPlugin plugin;
	
	ScoreboardManager sm = Bukkit.getScoreboardManager();
	
	/**
	 - kits
	 - commands: Essential Commands, Team Commands, Party Commands.
	 - Events
	 - Scoreboard
	 - Leveling System
	
	**/
	
	public static HCF getInstance(){
		return instance;
	}
	
	
	public void setupMainScoreboard(Player player){
		
		Scoreboard sb = sm.getNewScoreboard();
		
		Objective ob = sb.registerNewObjective("dummy", "dummy");
		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ob.setDisplayName(ChatColor.RED + "PVN - Version 0.1");
		Score scoreLine = ob.getScore(ChatColor.YELLOW + "================");
		scoreLine.setScore(0);
		Score score = ob.getScore(ChatColor.GRAY + "Rank:");
		score.setScore(1);
		Score scoreSpace = ob.getScore("");
		Score score2 = ob.getScore(ChatColor.GREEN + "Gems:");
		score2.setScore(100);
		
		
		
	}
	
	public void setupRankScoreBoard(Player player){
		
		Scoreboard sb = sm.getNewScoreboard();
		
		Objective ob = sb.registerNewObjective("showRank", "rank");
		ob.setDisplaySlot(DisplaySlot.BELOW_NAME);
		ob.setDisplayName("TODO: MAKE METHOD TO GET PLAYER RANK");
		
	}
	
	
	

}
