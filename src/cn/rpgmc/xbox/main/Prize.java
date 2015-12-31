package cn.rpgmc.xbox.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Prize {
	// ����
	private int chance = 0;
	// ��ʾ����Ʒ
	private ItemStack showItem = null;
	// ������Ʒ
	private List<ItemStack> toItem = null;
	// ��������
	private int exp = 0;
	// ����ָ��
	private String cmd = null;
	// ����
	private String notice = null;
	// �����ʱ��ʾ������
	private String show = null;
	// �н���Ϣ
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
