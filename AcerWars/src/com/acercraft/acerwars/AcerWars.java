package com.acercraft.acerwars;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class AcerWars extends JavaPlugin {
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	HashMap<String, Arena> arenas = new HashMap<String, Arena>();
	public void onEnable() {
		saveDefaultConfig();
	}
}
