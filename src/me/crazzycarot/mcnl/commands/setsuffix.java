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

public class setsuffix implements Listener, CommandExecutor {
	private main plugin;

	public setsuffix(main main) {
		plugin = main;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setsuffix")) {
			if (args.length == 2) {
				Player p = Bukkit.getPlayer(args[0]);

				if (p instanceof Player) {
					PermissionUser user = PermissionsEx.getUser(p);
					String suffix = args[1];
					user.setSuffix(ChatColor.DARK_GRAY + "&8[" + ChatColor.GRAY + suffix + ChatColor.DARK_GRAY + "&8] ", null);
					sender.sendMessage(ChatColor.RED + "Gelukt, " + p.getName() + " zijn suffix is nu " + " " + suffix);

				} else {
					sender.sendMessage(ChatColor.RED + "Fout, doe /setsuffix user suffix");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Fout, doe /setsuffix user suffix");
			}
		}
		return true;
	}
}
