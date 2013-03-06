package com.acercraft.acerwars.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Util {
	
	public String formatLocation(Location loc) {
		return "x" + loc.getX() + "y" + loc.getY() + "z" + loc.getZ() + "pitch" + loc.getPitch() + "yaw" + loc.getYaw() + "world" + loc.getWorld().getName();
	}
	
	public Location parseLocation(String s) {
		String xs = s.substring(1, s.indexOf("y"));
		String ys = s.substring(s.indexOf("y"), s.indexOf("z"));
		String zs = s.substring(s.indexOf("z"), s.indexOf("pitch"));
		String pitchs = s.substring(s.indexOf("pitch"), s.indexOf("yaw"));
		String yaws = s.substring(s.indexOf("yaw"), s.indexOf("world"));
		String worlds = s.substring(s.indexOf("world"));
		
		double x = Double.parseDouble(xs);
		double y = Double.parseDouble(ys);
		double z = Double.parseDouble(zs);
		float pitch = Float.parseFloat(pitchs);
		float yaw = Float.parseFloat(yaws);
		World world = Bukkit.getServer().getWorld(worlds);
		
		return new Location(world, x, y, z, yaw, pitch);
	}
}
