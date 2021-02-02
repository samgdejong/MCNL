package me.crazzycarot.mcnl.events;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.crazzycarot.mcnl.main;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class chat implements Listener {

	private main plugin;

	public chat(main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void ChatMessage(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		PermissionUser user = PermissionsEx.getUser(p);
		String prefix = user.getPrefix();
		String suffix = user.getSuffix();
		String oldmessage = e.getMessage() ;
		e.setCancelled(true);
		String message = plugin.getConfig().getString("chat.format").replaceAll("%prefix%", prefix).replaceAll("%suffix%", suffix).replaceAll("%name%", p.getName().replaceAll("%message%", oldmessage));

		
		Map<String, String> map = new LinkedHashMap<>();
		map.put("mcnl.tier.fifteen", plugin.getConfig().getString("tier.fifteen.prefix"));
		map.put("mcnl.tier.fourteen", plugin.getConfig().getString("tier.fourteen.prefix"));
		map.put("mcnl.tier.thirteen", plugin.getConfig().getString("tier.thirteen.prefix"));
		map.put("mcnl.tier.twelve", plugin.getConfig().getString("tier.twelve.prefix"));
		map.put("mcnl.tier.eleven", plugin.getConfig().getString("tier.eleven.prefix"));
		map.put("mcnl.tier.ten", plugin.getConfig().getString("tier.ten.prefix"));
		map.put("mcnl.tier.nine", plugin.getConfig().getString("tier.nine.prefix"));
		map.put("mcnl.tier.eight", plugin.getConfig().getString("tier.eight.prefix"));
		map.put("mcnl.tier.seven", plugin.getConfig().getString("tier.seven.prefix"));
		map.put("mcnl.tier.six", plugin.getConfig().getString("tier.six.prefix"));
		map.put("mcnl.tier.five", plugin.getConfig().getString("tier.five.prefix"));
		map.put("mcnl.tier.four", plugin.getConfig().getString("tier.four.prefix"));
		map.put("mcnl.tier.three", plugin.getConfig().getString("tier.three.prefix"));
		map.put("mcnl.tier.two", plugin.getConfig().getString("tier.two.prefix"));
		map.put("mcnl.tier.one", plugin.getConfig().getString("tier.one.prefix"));
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			  if (p.hasPermission(entry.getKey())) {
				
				String tier = ChatColor.translateAlternateColorCodes('&', entry.getValue());
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message + e.getMessage()).replaceAll("%tier%", tier));
				return;
			  }
			}
		

		}

	}

