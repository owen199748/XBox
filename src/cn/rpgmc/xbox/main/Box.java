package cn.rpgmc.xbox.main;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Box implements Runnable {
	private Player p = null;
	private Xbox xbox = null;
	private Item item;
	private static Map<Player, Box> boxs = new HashMap<Player, Box>();

	public static Map<Player, Box> getBoxs() {
		return boxs;
	}

	public Box(Player p, Xbox xbox) {
		this.p = p;
		this.xbox = xbox;
		boxs.put(p, this);
		ItemStack it = new ItemStack(xbox.getShow());
		net.minecraft.server.v1_8_R3.ItemStack it2 = CraftItemStack.asNMSCopy(it);
		NBTTagCompound tag = it2.getTag();
		if (tag == null)
			tag = new NBTTagCompound();
		tag.setBoolean("XboxItem",true);
		it2.setTag(tag);
		it=CraftItemStack.asBukkitCopy(it2);
		item = p.getWorld().dropItem(p.getLocation(), it);
		Bukkit.getScheduler().runTaskAsynchronously(Main.getMain(), this);

	}

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		Prize nowPrize = null;
		item.setPickupDelay(Integer.MAX_VALUE);
		long max = 800;
		long start = max;
		int r = 2;
		while (start > 0) {
			if (start - r <= 0)
			nowPrize = xbox.getRandomPrize();
			else
				nowPrize = xbox.getRandomPrize(nowPrize);
			item.setItemStack(nowPrize.getShowItem());
			try {
				Thread.sleep(max - start + 1);
			} catch (InterruptedException e) {
			}
			r++;
			start = start - r;
}
		nowPrize.giveTo(p);
		item.remove();
	

	}
}
