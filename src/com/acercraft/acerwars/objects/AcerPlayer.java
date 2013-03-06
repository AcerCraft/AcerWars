package com.acercraft.acerwars.objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;

public class AcerPlayer {
	private String name;
	private Faction faction;
	private War war;
	public AcerPlayer(String name) {
		this.name = name;
	}
	
	public void setFaction(Faction f) {
		this.faction = f;
	}
	
	public Faction getFaction() {
		return faction;
	}
	
	public War getWar() {
		return war;
	}
	
	public void setWar(War war) {
		this.war = war;
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayerExact(name);
	}
	
	public FPlayer getFactionPlayer() {
		return FPlayers.i.get(Bukkit.getPlayerExact(name));
	}
	
	public boolean hasFaction() {
		if(faction == null) return false;
		return true;
	}
}
