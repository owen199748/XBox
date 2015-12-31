package cn.rpgmc.xbox.main;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;




public class AutoListener implements Listener {


	@EventHandler
	public void ler(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

}

