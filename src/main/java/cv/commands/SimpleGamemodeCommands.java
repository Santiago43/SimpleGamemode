package cv.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cv.simplegamemode.SimpleGamemode;
import org.bukkit.ChatColor;

/**
 * Command class
 * 
 * @author santiago4
 * @version 1.0
 * @since 2020-07-17
 */
public class SimpleGamemodeCommands implements CommandExecutor {

	private SimpleGamemode instance;

	/**
	 * Plug-in instance
	 * 
	 * @param instance
	 */
	public SimpleGamemodeCommands(SimpleGamemode instance) {
		this.instance = instance;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("spectator")|| args[0].equalsIgnoreCase("3")) {
					if (player.hasPermission("simplegamemode.spectator")) {
						GameMode gamemode = player.getGameMode();
						player.setGameMode(gamemode.SPECTATOR);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"Se ha cambiado el modo de juego a &aespectador"));
						return true;
					} else {
						player.sendMessage(
								ChatColor.translateAlternateColorCodes('&', "&cNo tienes permisos para esto"));
						return false;
					}
				} else if (args[0].equalsIgnoreCase("survival")|| args[0].equalsIgnoreCase("0")) {
					if (player.hasPermission("simplegamemode.survival")) {
						GameMode gamemode = player.getGameMode();
						player.setGameMode(gamemode.SURVIVAL);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"Se ha cambiado el modo de juego a &asupervivencia"));
						return true;
					} else {
						player.sendMessage(
								ChatColor.translateAlternateColorCodes('&', "&cNo tienes permisos para esto"));
					}

				} else if (args[0].equalsIgnoreCase("creative")|| args[0].equalsIgnoreCase("1")) {
					if (player.hasPermission("simplegamemode.creative")) {
						GameMode gamemode = player.getGameMode();
						player.setGameMode(gamemode.CREATIVE);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"Se ha cambiado el modo de juego a &acreativo"));
						return true;
					} else {
						player.sendMessage(
								ChatColor.translateAlternateColorCodes('&', "&cNo tienes permisos para esto"));
					}
				} 
				else if (args[0].equalsIgnoreCase("adventure")|| args[0].equalsIgnoreCase("2")) {
					if (player.hasPermission("simplegamemode.adventure")) {
						GameMode gamemode = player.getGameMode();
						player.setGameMode(gamemode.ADVENTURE);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"Se ha cambiado el modo de juego a &aaventura"));
						return true;
					} else {
						player.sendMessage(
								ChatColor.translateAlternateColorCodes('&', "&cNo tienes permisos para esto"));
					}
				}
				else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&b[SimpleGamemode] &eBy &6Craft&eVilla &a(" + instance.getDescription().getVersion())
							+ ")");
				}

			} else {
				Bukkit.getConsoleSender()
						.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&b[SimpleGamemode] &eBy &6Craft&eVilla &a(" + instance.getDescription().getVersion())
								+ ")");
			}
			return true;
		}
		return false;
	}
}
