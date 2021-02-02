package me.crazzycarot.mcnl.commands;

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

public class setprefix implements Listener, CommandExecutor {
	private main plugin;

	public setprefix(main main) {
		plugin = main;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setprefix")) {
			if (args.length == 2) {
				Player p = Bukkit.getPlayer(args[0]);

				if (p instanceof Player) {
					PermissionUser user = PermissionsEx.getUser(p);
					String prefix = args[1];
					user.setPrefix(ChatColor.DARK_GRAY + "&8[" + ChatColor.GRAY + prefix + ChatColor.DARK_GRAY + "&8] ", null);
					sender.sendMessage(ChatColor.RED + "Gelukt, " + p.getName() + " zijn prefix is nu " + " " + prefix);

				} else {
					sender.sendMessage(ChatColor.RED + "Fout, doe /setprefix user prefix");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Fout, doe /setprefix user prefix");
			}
		}
		return true;
	}
}
