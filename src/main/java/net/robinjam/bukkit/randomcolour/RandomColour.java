package net.robinjam.bukkit.randomcolour;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomColour extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Random random = new Random(player.getName().hashCode());
		ChatColor colour = ChatColor.getByChar(Integer.toHexString(random.nextInt(15)));
		player.setDisplayName(colour + player.getDisplayName() + ChatColor.WHITE);
	}
	
}
