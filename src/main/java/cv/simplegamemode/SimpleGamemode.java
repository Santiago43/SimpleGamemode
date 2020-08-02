package cv.simplegamemode;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import cv.commands.SimpleGamemodeCommands;

public class SimpleGamemode extends JavaPlugin{

	private PluginDescriptionFile pluginDescriptionFile;
	private String version;
	private String name;
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
		this.pluginDescriptionFile=this.getDescription();
		this.version=this.pluginDescriptionFile.getVersion();
		this.name=this.pluginDescriptionFile.getName();
		Bukkit.getConsoleSender().sendMessage("["+name+"] Iniciado ("+version+")");
		this.registerCmds();
	}
	
	/**
	 * 
	 */
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("["+name+"] Finalizado");
	}
	private void registerCmds() {
		this.getCommand("simplegamemode").setExecutor(new SimpleGamemodeCommands(this));
	}
}
