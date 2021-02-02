package me.crazzycarot.mcnl.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.crazzycarot.mcnl.main;

public class deaths implements Listener {

	private main plugin;

	public deaths(main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}
	
	
	@EventHandler
	public void DeathMessage(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {

		Player attacker = e.getEntity().getPlayer().getKiller();
		Player victim = e.getEntity().getPlayer();
		Player p = e.getEntity().getPlayer();
		if (!(plugin.getConfig().getString("death.enabled").contentEquals("true"))) {
			
		}
		else {
			
			String message = plugin.getConfig().getString("death.deathmessage")
					.replaceAll("%attacker%", attacker.getName()).replaceAll("%victim%", victim.getName());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
		}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (plugin.kills.get(e.getPlayer().getUniqueId()) == null) {
			plugin.kills.put(e.getPlayer().getUniqueId(), 1);
		}
		if (plugin.deaths.get(e.getPlayer().getUniqueId()) == null) {
			plugin.deaths.put(e.getPlayer().getUniqueId(), 1);
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				@SuppressWarnings("unused")
				Player killer = e.getEntity().getKiller();
				Player death = e.getEntity().getPlayer();
				if (plugin.deaths.get(death.getUniqueId()) == null) {
					plugin.deaths.put(death.getUniqueId(), 1);
				} else {
					int currentDeaths = plugin.deaths.get(death.getUniqueId());
					
					plugin.deaths.replace(death.getUniqueId(), currentDeaths+1);

				}

			}
		}

	}

	@EventHandler
	public void onDeaths(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player killer = e.getEntity().getKiller();
				Player death = e.getEntity().getPlayer();
				if (plugin.kills.get(killer.getUniqueId()) == null) {
					plugin.kills.put(killer.getUniqueId(), 1);
				} else {
					int currentKills = plugin.kills.get(killer.getUniqueId());
					
					plugin.kills.replace(killer.getUniqueId(), currentKills+1);

				}

			}
		}

	}
	
	

}
