package me.crazzycarot.mcnl.scoreboard;


import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.crazzycarot.mcnl.main;


public class scoreboard implements Listener {



	private main plugin;

	public scoreboard(main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		@SuppressWarnings("unused")
		final Scoreboard board = manager.getNewScoreboard();
		final Player p = e.getPlayer();

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {

				String scoreboardtitle = plugin.getConfig().getString("scoreboard.title");
				String scoreboardline1 = plugin.getConfig().getString("scoreboard.line1");
				String scoreboardline2 = plugin.getConfig().getString("scoreboard.line2");
				String scoreboardline3 = plugin.getConfig().getString("scoreboard.line3");
				String scoreboardline4 = plugin.getConfig().getString("scoreboard.line4");
				String scoreboardline5 = plugin.getConfig().getString("scoreboard.line5");
				String scoreboardline6 = plugin.getConfig().getString("scoreboard.line6");
				String scoreboardline7 = plugin.getConfig().getString("scoreboard.line7");
				String scoreboardline8 = plugin.getConfig().getString("scoreboard.line8");
				String scoreboardline9 = plugin.getConfig().getString("scoreboard.line9");
				String scoreboardline10 = plugin.getConfig().getString("scoreboard.line10");
				String scoreboardline11 = plugin.getConfig().getString("scoreboard.line11");
					
				OfflinePlayer pl = p;
				String bal = "" + plugin.econ.getBalance(pl.getName());

				String name = e.getPlayer().getName();
				String deaths= "" + plugin.deaths.get(e.getPlayer().getUniqueId());
				String kills= "" + plugin.kills.get(e.getPlayer().getUniqueId());

				
				
				Map<String, String> map = new LinkedHashMap<>();
				map.put("mcnl.tier.one", plugin.getConfig().getString("tier.one.prefix"));
				map.put("mcnl.tier.two", plugin.getConfig().getString("tier.two.prefix"));
				map.put("mcnl.tier.three", plugin.getConfig().getString("tier.three.prefix"));
				map.put("mcnl.tier.four", plugin.getConfig().getString("tier.four.prefix"));
				map.put("mcnl.tier.five", plugin.getConfig().getString("tier.five.prefix"));
				map.put("mcnl.tier.six", plugin.getConfig().getString("tier.six.prefix"));
				map.put("mcnl.tier.seven", plugin.getConfig().getString("tier.seven.prefix"));
				map.put("mcnl.tier.eight", plugin.getConfig().getString("tier.eight.prefix"));
				map.put("mcnl.tier.nine", plugin.getConfig().getString("tier.nine.prefix"));
				map.put("mcnl.tier.ten", plugin.getConfig().getString("tier.ten.prefix"));
				map.put("mcnl.tier.eleven", plugin.getConfig().getString("tier.eleven.prefix"));
				map.put("mcnl.tier.twelve", plugin.getConfig().getString("tier.twelve.prefix"));
				map.put("mcnl.tier.thirteen", plugin.getConfig().getString("tier.thirteen.prefix"));
				map.put("mcnl.tier.fourteen", plugin.getConfig().getString("tier.fourteen.prefix"));
				map.put("mcnl.tier.fifteen", plugin.getConfig().getString("tier.fifteen.prefix"));













				
				for (Map.Entry<String, String> entry : map.entrySet()) {
					  if (p.hasPermission(entry.getKey())) {
						
						String tier = ChatColor.translateAlternateColorCodes('&', entry.getValue());
				
				
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				final Scoreboard board = manager.getNewScoreboard();
				final Objective objective = board.registerNewObjective("test", "dummy");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName(ChatColor.WHITE + "§lCityDam");
				Score score1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline1).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score1.setScore(16);
				Score score2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline2).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score2.setScore(15);
				Score score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline3).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score3.setScore(14);
				Score score4 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline4).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score4.setScore(13);
				Score score5 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline5).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score5.setScore(12);
				Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline6).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score6.setScore(11);
				Score score7 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline7).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score7.setScore(10);
				Score score8 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline8).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score8.setScore(9);
				Score score9 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline9).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score9.setScore(8);
				Score score10 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline10).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths).replaceAll("%balance%", bal).replaceAll("%tier%", tier));
				score10.setScore(6);
				Score score11 = objective.getScore(formatLine(scoreboardline11, name, kills, deaths, bal, tier, deaths, tier)); //scoreboardline11
				p.setScoreboard(board);
					  }
				}
			}
		}, 0, 20 * 10);

	}
	
	private String formatLine(String line, String name, String kills, String bal, String tier, String deaths){
	    String nl = ChatColor.translateAlternateColorCodes('&', line)
	    .replaceAll("%player%", name)
	    .replaceAll("%kills%", kills)
	    .replaceAll("%deaths%", deaths)
	    .replaceAll("%balance%", bal)
	    .replaceAll("%tier%", tier);
	    return nl;
	}
	
	
	
	

}
