package com.acercraft.objects;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.factions.Faction;

public class War {
	private Faction f1;
	private Faction f2;
	private int playersPerSide;
	
	private String status; // "Inactive" OR "Lobby" OR "Active"
	
	private Arena arena;
	
	private List<AcerPlayer> f1Players = new ArrayList<AcerPlayer>();
	private List<AcerPlayer> f2Players = new ArrayList<AcerPlayer>();
	
	public War(Faction f1, Faction f2, int perSide, Arena arena) {
		f1 = this.f1;
		f2 = this.f2;
		perSide = this.playersPerSide;
		this.arena = arena;
	}
	
	public boolean addPlayer(AcerPlayer player) {
		if(player.hasFaction()) { // Not factionless
			if(player.getFaction() == f1) { // In faction 1
				f1Players.add(player);
				return true;
			}
			else if(player.getFaction() == f2) { // In faction 2
				f2Players.add(player);
				return true;
			}
		}
		return false; // Either no faction or not one of the two in the war
	}
	
	public boolean removePlayer(AcerPlayer player) {
		if(player.hasFaction()) { // Not factionless
			if(f1Players.contains(player)) { // In faction 1
				f1Players.remove(player);
				return true;
			}
			else if(f2Players.contains(player)) { // In faction 2
				f2Players.remove(player);
				return true;
			}
		}
		return false; // Either no faction or not one of the two in the war
	}
	
	public Arena getArena() {
		return arena;
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public Faction getFactionOne() {
		return f1;
	}
	
	public Faction getFactionTwo() {
		return f2;
	}
	
	public int getPlayersPerSide() {
		return playersPerSide;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
