package me.crazzycarot.mcnl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.crazzycarot.mcnl.commands.setprefix;
import me.crazzycarot.mcnl.commands.setsuffix;
import me.crazzycarot.mcnl.commands.settier;
import me.crazzycarot.mcnl.commands.tierup;
import me.crazzycarot.mcnl.events.chat;
import me.crazzycarot.mcnl.events.deaths;
import me.crazzycarot.mcnl.scoreboard.scoreboard;
import net.milkbowl.vault.economy.Economy;

public class main extends JavaPlugin implements Listener, CommandExecutor {

	public HashMap<UUID, Integer> kills = new HashMap<>();
	public HashMap<UUID, Integer> deaths = new HashMap<>();

	public void onEnable() {
		getServer().getLogger().info("MCNL loaded. Plugin made by crazzycarot.");
		saveDefaultConfig();
		

		new deaths(this);
		new scoreboard(this);
		new chat(this);
		
		getCommand("tierup").setExecutor(new tierup(this));
		getCommand("setprefix").setExecutor(new setprefix(this));
		getCommand("setsuffix").setExecutor(new setsuffix(this));
		getCommand("settier").setExecutor(new settier(this));


		if (!setupEconomy()) {
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		Set<String> configSectionKills = customConfig.getConfigurationSection("kills").getKeys(true);
		Set<String> configSectionDeaths = customConfig.getConfigurationSection("deaths").getKeys(true);

		for (String key : configSectionKills) {
			int kill = customConfig.getInt("kills." + key);
			kills.put(UUID.fromString(key), kill);

		}
		for (String key : configSectionDeaths) {
			int death = customConfig.getInt("deaths." + key);
			deaths.put(UUID.fromString(key), death);

		}

	}

	public void onDisable() {
		if (kills != null) {
			for (Map.Entry<UUID, Integer> killMap : kills.entrySet()) {
				customConfig.set("kills." + killMap.getKey(), killMap.getValue());
				savereclaimYml(this.customConfig, this.reclaimYml);

			}
			savereclaimYml(this.customConfig, this.reclaimYml);
			
		}

		if (deaths != null) {
			for (Map.Entry<UUID, Integer> deathMap : deaths.entrySet()) {
				customConfig.set("deaths." + deathMap.getKey(), deathMap.getValue());
				savereclaimYml(this.customConfig, this.reclaimYml);

			}
			savereclaimYml(this.customConfig, this.reclaimYml);


		}

	}
	
	//plugin.stats.getString("reclaimG.name");
	public File reclaimYml = new File(this.getDataFolder() + "/stats.yml");
	public FileConfiguration customConfig = YamlConfiguration.loadConfiguration(reclaimYml);

	public void savereclaimYml(FileConfiguration ymlConfig, File ymlFile) {
		try {
			ymlConfig.save(ymlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Economy econ = null;

	public boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		org.bukkit.plugin.RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

}