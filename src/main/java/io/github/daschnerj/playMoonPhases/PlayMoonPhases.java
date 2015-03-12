package io.github.daschnerj.playMoonPhases;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayMoonPhases extends JavaPlugin 
{
	public static long phaseTime = 0;
	public static int day = 0;
	public static int phase = 0;
	public static World w = null;
	
	public static String[] moonPhases = {"(Day) New Moon", "New Moon", "(Day) Waxing Crescent", "Waxing Crescent", "(Day) First Quarter", "First Quarter", "(Day) Waxing Gibbous", "Waxing Gibbous", "(Day) Full Moon", "Full Moon", "(Day) Waning Gibbous", "Waning Gibbous", "(Day) Last Quarter", "Last Quarter", "(Day) Waning Crescent", "Waning Crescent"};
	public static String currentPhase = moonPhases[0];
	@Override
	public void onEnable() 
	{	
		for (World world : getServer().getWorlds()) {
            getLogger().info("Play Moon Phases Possible World: " + world.getName());
        }
		getLogger().info("Play Moon Phases has been enabled!");
		this.getServer().getScheduler().runTaskTimer(this, new Runnable()
	      {
	        @Override
	        public void run()
	        {
	        	w = Bukkit.getWorld("Haven");
	        	phaseTime = w.getFullTime();
	    		day = Math.abs(((int)(phaseTime/12000))-8);
	    		phase = day%16;
	    		if(!currentPhase.equalsIgnoreCase(moonPhases[phase]))
	    		{
	    			for(Player p : Bukkit.getServer().getOnlinePlayers())
	    			{
	    				if(p.getWorld().equals(w))
						p.sendMessage(ChatColor.BLUE + "The current phase of the moon is now " + ChatColor.WHITE + moonPhases[phase] + ChatColor.BLUE + "!");
	    			}
	    			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The current phase of the moon is now " + ChatColor.WHITE + moonPhases[phase] + ChatColor.BLUE + "!");
	    			currentPhase = moonPhases[phase];
	    		}	        
	    	}
	      }, (20*10L), 20*1);
	}
 
	@Override
	public void onDisable() 
	{
		getLogger().info("Play Moon Phases has been disabled!");
	}
}
