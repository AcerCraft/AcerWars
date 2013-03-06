package com.acercraft.acerwars.objects;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.acercraft.acerwars.AcerWars;

public class Arena {
	AcerWars plugin;
	// Arena Information
	String name;
	private Location arenaTele1; // Team one enters the arena here
	private Location arenaTele2; // Team two enters the arena here
	private Location lobbyTele1; // Team one teleports to this lobby
	private Location lobbyTele2; // Team two teleports to this lobby
	
	private Location min; // One corner
	private Location max; // Other corner
	
	private War war; // The war going on in the arena, or null if arena is open
	
	public Arena(AcerWars plugin, String name) {
		this.plugin = plugin;
		this.name = name;
	}
	
	public boolean hasFile() {
		File file = new File("plugins/AcerWars/Arenas/" + name + ".yml");
		if(file.exists()) return true;
		return false;
	}
	
	public void createNewFile() {
		if(hasFile()) return;
		File file = new File("plugins/AcerWars/Arenas/" + name + ".yml");
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileConfiguration yml = YamlConfiguration.loadConfiguration(file);
		
		// Set defaults for arena file
	}
	
	public void loadFromFile() {
		if(!hasFile()) createNewFile();
		
		File file = new File("plugins/AcerWars/Arenas/" + name + ".yml");
		FileConfiguration yml = YamlConfiguration.loadConfiguration(file);
		
		 // Set all variables in equal to those retrieved from config
	}
	
	// Add set / get methods for each variable
}
