package pw.owen.xbox.main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	private static Main main;

	public static Main getMain() {
		return main;
	}
@Override
public void onEnable() {
		this.main = this;
		getServer().getPluginManager().registerEvents(new AutoListener(), this);

		Prize[] pz = { new Prize(), new Prize(), new Prize() };
		pz[0].setChance(200);
		pz[1].setChance(200);
		pz[2].setChance(500);

		pz[0].setCmd("fly %p%");
		pz[1].setToItem(new ItemStack(Material.EGG));
		pz[2].setExp(500);

		pz[0].setShowItem(new ItemStack(166));
		pz[1].setShowItem(new ItemStack(Material.EGG));
		pz[2].setShowItem(new ItemStack(384));
		new Xbox(new ItemStack(1), pz);

}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {


		if (!(sender instanceof Player)) {
			sender.sendMessage("本命令只能由玩家执行");
			return true;
		} else {
			Player p = (Player) sender;
			Xbox.getXboxs().get(0).run(p);
		}
		return false;

	}

}


