package com.acercraft.acerwars;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public class AcerWars extends JavaPlugin {
	HashMap<String, Arena> arenas = new HashMap<String, Arena>();
	public void onEnable() {
		saveDefaultConfig();
	}
}
