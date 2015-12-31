package pw.owen.xbox.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Xbox {
	private List<Prize> prizes = new ArrayList<Prize>();
	private ItemStack show = null;
	private static List<Xbox> xboxs = new ArrayList<Xbox>();

	private Xbox() {
		// TODO 自动生成的构造函数存根
	}

	public void setShow(ItemStack show) {
		this.show = show;
	}
	public Xbox(ItemStack show, Prize... prizes) {
		this.prizes = new ArrayList<Prize>(Arrays.asList(prizes));
		this.show = show;
		xboxs.add(this);
	}

	public static List<Xbox> getXboxs() {
		return xboxs;
	}
	public List<Prize> getPrizes() {
		return prizes;
	}

	public ItemStack getShow() {
		return show;
	}
	public boolean run(Player p) {
		if (Box.getBoxs().get(p) == null)
			new Box(p, this);
		else
			return false;

		return true;
	}


	public Prize getRandomPrize() {
		if(prizes==null||prizes.size()==0)
			return null;
		int max = 0;
		for (int i = 0; i < prizes.size(); i++)
			max += prizes.get(i).getChance();
		int random = (int) (Math.random() * max);
		max=0;
		int i = -1;
		while (max < random && i + 1 < prizes.size()) {
			i++;
			max += prizes.get(i).getChance();
		}
		return prizes.get(i);
	}

	public Prize getRandomPrize(Prize nowPrize) {
		Prize pz = getRandomPrize();
		if (nowPrize == pz)
			return getRandomPrize(nowPrize);
		return pz;
	}

}
