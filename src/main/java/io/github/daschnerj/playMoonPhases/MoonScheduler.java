package io.github.daschnerj.playMoonPhases;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class MoonScheduler extends BukkitRunnable 
{
	 
	private final PlayMoonPhases plugin;
	 
	public MoonScheduler(PlayMoonPhases plugin) 
	{
		this.plugin = plugin;
	}
	 
	public void run() 
	{
		PlayMoonPhases.phaseTime = Bukkit.getWorld("Haven").getFullTime();
		PlayMoonPhases.day = (int)(PlayMoonPhases.phaseTime/12000);
		PlayMoonPhases.phase = PlayMoonPhases.day%16;
		if(!PlayMoonPhases.currentPhase.equalsIgnoreCase(PlayMoonPhases.moonPhases[PlayMoonPhases.phase]))
		{
			Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "The current phase of the moon is now " + ChatColor.WHITE + PlayMoonPhases.moonPhases[PlayMoonPhases.phase] + ChatColor.BLUE + "!");
			PlayMoonPhases.currentPhase = PlayMoonPhases.moonPhases[PlayMoonPhases.phase];
		}
	}
}
