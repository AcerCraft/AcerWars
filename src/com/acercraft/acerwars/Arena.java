package com.acercraft.acerwars;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Arena {
	AcerWars plugin;
	// Arena Information
	String name;
	Location arenaTele1; // Team one enters the arena here
	Location arenaTele2; // Team two enters the arena here
	Location lobbyTele1; // Team one teleports to this lobby
	Location lobbyTele2; // Team two teleports to this lobby
	// You think we need to store the region locations for lobbys / arenas?
	
	// Information for ongoingArena
	String status; // "Lobby" "Active" "Inactive"
	List<String> teamOne; // All players from team one
	List<String> teamTwo; // All players from team two
	
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
