package com.acercraft.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ObjectHandler implements Listener {
	
	HashMap<String, AcerPlayer> acerPlayers = new HashMap<String, AcerPlayer>();
	
	HashMap<String, Arena> arenas = new HashMap<String, Arena>();
	
	public AcerPlayer getAcerPlayer(String name) {
		if(acerPlayers.containsKey(name)) {
			return acerPlayers.get(name);
		}
		return new AcerPlayer(name);
	}
	
	public Arena getArena(String name) {
		if(arenas.containsKey(name)) {
			return arenas.get(name);
		}
		return null; // Arena doesn't exist
	}
	
	public List<Arena> getAllArenas() {
		List<Arena> arenas = new ArrayList<Arena>();
		for(Arena a : this.arenas.values()) {
			arenas.add(a);
		}
		return arenas;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		// Create AcerPlayer objects as players join
		if(!acerPlayers.containsKey(event.getPlayer().getName())) {
			acerPlayers.put(event.getPlayer().getName(), new AcerPlayer(event.getPlayer().getName()));
		}
	}
}
