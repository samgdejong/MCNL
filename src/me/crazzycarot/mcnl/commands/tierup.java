package me.crazzycarot.mcnl.commands;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.crazzycarot.mcnl.main;

public class tierup implements Listener, CommandExecutor {
	private main plugin;

	public tierup(main main) {
		plugin = main;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tierup")) {

			Player p = (Player) sender;

			Map<String, String> bal = new LinkedHashMap<>();
			Map<String, String> kills = new LinkedHashMap<>();

		// -> 15
			bal.put("mcnl.tier.fourteen", "fifteen");
			kills.put("mcnl.tier.fifteen", "fifteen");
		// -> 14
			bal.put("mcnl.tier.thirteen", "fourteen");
			kills.put("mcnl.tier.fourteen", "fourteen");
		// -> 13
			bal.put("mcnl.tier.twelve", "thirteen");
			kills.put("mcnl.tier.thirteen", "thirteen");
		// -> 12
			bal.put("mcnl.tier.eleven", "twelve");
			kills.put("mcnl.tier.twelve", "twelve");
		// -> 11
			bal.put("mcnl.tier.ten", "eleven");
			kills.put("mcnl.tier.eleven", "eleven");
		// -> 10
			bal.put("mcnl.tier.nine", "ten");
			kills.put("mcnl.tier.ten", "ten");
		// -> 9
			bal.put("mcnl.tier.eight", "nine");
			kills.put("mcnl.tier.nine", "nine");
		// -> 8
			bal.put("mcnl.tier.seven", "eight");
			kills.put("mcnl.tier.eight", "eight");
		// -> 7
			bal.put("mcnl.tier.six", "seven");
			kills.put("mcnl.tier.seven", "seven");
		// -> 6
			bal.put("mcnl.tier.five", "six");
			kills.put("mcnl.tier.six", "six");
		// -> 5
			bal.put("mcnl.tier.four", "five");
			kills.put("mcnl.tier.five", "five");
		// -> 4
			bal.put("mcnl.tier.three", "four");
			kills.put("mcnl.tier.four", "four");
		// -> 3
			bal.put("mcnl.tier.two", "three");
			kills.put("mcnl.tier.three", "three");
		// -> 2
			bal.put("mcnl.tier.one", "two");
			kills.put("mcnl.tier.two", "two");

			

			for (Map.Entry<String, String> entrybal : bal.entrySet()) {
				
				for (Map.Entry<String, String> entrykills : kills.entrySet()) {
					
					if (p.hasPermission("mcnl.tier.fifteen")) {
						sender.sendMessage(ChatColor.RED + "Je bent al de hoogste tier");
						return true;
					}

					if (p.hasPermission(entrybal.getKey())) {

						if (entrybal.getValue() == entrykills.getValue()) {
							

							
						Integer minbal = plugin.getConfig().getInt("tier." + entrybal.getValue() + ".balance");
						Integer minkills = plugin.getConfig().getInt("tier." + entrybal.getValue() + ".kills");

						
						if (plugin.econ.getBalance(p) > minbal) {

							if (plugin.kills.get(p.getUniqueId()) > minkills) { 

								Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										"&7" + p.getName() + " &cis een tier omhoog gegaan! &7&lGG!"));

								plugin.econ.withdrawPlayer(p, minbal);
								return true;

							} else {
								sender.sendMessage(ChatColor.RED + "Je hebt hier niet genoeg kills voor! Je hebt minimaal " + ChatColor.GRAY + minkills  + " kills nodig");
								return true;
							}

						} else {
							sender.sendMessage(ChatColor.RED + "Je hebt hier niet genoeg geld voor! Je hebt minimaal " + ChatColor.GRAY + minbal + ChatColor.RED + " euro nodig");
							return true;
						}
					}
					}
				}

			}
		}

		return true;

	}
}