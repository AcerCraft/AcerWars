package com.acercraft.acerwars.objects;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.acercraft.acerwars.AcerWars;
import com.acercraft.acerwars.util.Util;

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
	}
	
	public void loadFromFile() {
		if(!hasFile()) createNewFile();
		
		File file = new File("plugins/AcerWars/Arenas/" + name + ".yml");
		FileConfiguration yml = YamlConfiguration.loadConfiguration(file);
		
		min = Util.parseLocation(yml.getString("min"));
		max = Util.parseLocation(yml.getString("max"));
		
		arenaTele1 = Util.parseLocation(yml.getString("tele1"));
		arenaTele2 = Util.parseLocation(yml.getString("tele2"));
		
		lobbyTele1 = Util.parseLocation(yml.getString("lobbyTele1"));
		lobbyTele2 = Util.parseLocation(yml.getString("lobbyTele2"));
	}
	
	public void saveToFile() {
		if(!hasFile()) createNewFile();
		
		File file = new File("plugins/AcerWars/Arenas/" + name + ".yml");
		FileConfiguration yml = YamlConfiguration.loadConfiguration(file);
		
		yml.set("min", Util.formatLocation(min));
		yml.set("max", Util.formatLocation(max));
		
		yml.set("tele1", Util.formatLocation(arenaTele1));
		yml.set("tele2", Util.formatLocation(arenaTele2));
		
		yml.set("lobbyTele2", Util.formatLocation(lobbyTele1));
		yml.set("lobbyTele2", lobbyTele2);
		
		try {
			yml.save(file);
		} catch (IOException e) {
			AcerWars.log.severe("Failed to save arena file for: " + name);
			e.printStackTrace();
		}
	}
	
	public boolean hasWar() {
		if(war == null) return false;
		return true;
	}
	
	public void setWar(War war) {
		this.war = war;
	}
	
	public War getWar() {
		return war;
	}
	
	public void setArenaTele1(Location loc) {
		arenaTele1 = loc;
	}
	
	public Location getArenaTele1() {
		return arenaTele1;
	}
	
	public void setArenaTele2(Location loc) {
		arenaTele2 = loc;
	}
	
	public Location getArenaTele2() {
		return arenaTele2;
	}
	
	public void setLobbyTele1(Location loc) {
		lobbyTele1 = loc;
	}
	
	public Location getLobbyTele1() {
		return lobbyTele1;
	}
	
	public void setLobbyTele2(Location loc) {
		lobbyTele2 = loc;
	}
	
	public Location getLobbyTele2() {
		return lobbyTele2;
	}
}
