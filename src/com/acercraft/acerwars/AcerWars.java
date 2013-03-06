package com.acercraft.acerwars;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.acercraft.objects.Arena;
import com.acercraft.objects.ObjectHandler;

public class AcerWars extends JavaPlugin {
	
	public static Logger log;
	
	HashMap<String, Arena> arenas = new HashMap<String, Arena>();
	
	ObjectHandler objects = new ObjectHandler();
	public void onEnable() {
		saveDefaultConfig();
		log = getServer().getLogger();
		getServer().getPluginManager().registerEvents(objects, this);
	}
}
