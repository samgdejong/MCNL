package me.crazzycarot.mcnl.commands;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.crazzycarot.mcnl.main;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class settier implements Listener, CommandExecutor {
	private main plugin;

	public settier(main main) {
		plugin = main;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("settier")) {
			if (args.length == 2) {
				Player p = Bukkit.getPlayer(args[0]);

				Map<String, String> map = new LinkedHashMap<>();
				map.put("mcnl.tier.fifteen", plugin.getConfig().getString("fifteen"));
				map.put("mcnl.tier.fourteen", plugin.getConfig().getString("fourteen"));
				map.put("mcnl.tier.thirteen", plugin.getConfig().getString("thirteen"));
				map.put("mcnl.tier.twelve", plugin.getConfig().getString("twelve"));
				map.put("mcnl.tier.eleven", plugin.getConfig().getString("eleven"));
				map.put("mcnl.tier.ten", plugin.getConfig().getString("ten"));
				map.put("mcnl.tier.nine", plugin.getConfig().getString("nine"));
				map.put("mcnl.tier.eight", plugin.getConfig().getString("eight"));
				map.put("mcnl.tier.seven", plugin.getConfig().getString("seven"));
				map.put("mcnl.tier.six", plugin.getConfig().getString("six"));
				map.put("mcnl.tier.five", plugin.getConfig().getString("five"));
				map.put("mcnl.tier.four", plugin.getConfig().getString("four"));
				map.put("mcnl.tier.three", plugin.getConfig().getString("three"));
				map.put("mcnl.tier.two", plugin.getConfig().getString("two"));
				map.put("mcnl.tier.one", plugin.getConfig().getString("one"));
				
				
				
				
				if (p instanceof Player) {
					PermissionUser user = PermissionsEx.getUser(p);

		
							
							user.addPermission("mcnl.tier." + args[1]);
							sender.sendMessage(ChatColor.RED + "Gelukt, " + p.getName() + " is nu tier " + " " + args[1]);

						
					
				} else {
					sender.sendMessage(ChatColor.RED + "Fout, doe /settier user one/two etc...");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Fout, doe /settier user one/two etc...");
			}
		}
		return true;
	}
}
