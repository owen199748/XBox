package cn.rpgmc.xbox.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Prize {
	// 几率
	private int chance = 0;
	// 显示的物品
	private ItemStack showItem = null;
	// 奖励物品
	private List<ItemStack> toItem = null;
	// 奖励经验
	private int exp = 0;
	// 奖励指令
	private String cmd = null;
	// 公告
	private String notice = null;
	// 给随机时显示的内容
	private String show = null;
	// 中奖信息
	private String prompt = null;

	public ItemStack getShowItem() {
		return showItem;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setShowItem(ItemStack showItem) {
		this.showItem = showItem;
	}

	public void setToItem(ItemStack... toItem) {
		this.toItem = new ArrayList<ItemStack>(Arrays.asList(toItem));
	}
	public void giveTo(Player p) {
		if(this.cmd!=null)
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
					this.cmd.replaceAll("%p%", p.getName()));

		if(this.exp!=0)
			p.giveExp(this.exp);

		if (this.toItem != null)
			p.getInventory().addItem(
					this.toItem.toArray(new ItemStack[this.toItem.size()]));

		if (this.notice != null)
			Bukkit.broadcastMessage(this.notice.replaceAll("%p%", p.getName()));

		if (this.prompt != null)
			p.sendMessage(prompt.replaceAll("%p%", p.getName()));

	}

	public String getShow() {
		return show;
	}

	public int getChance() {
		return chance;
	}

}
