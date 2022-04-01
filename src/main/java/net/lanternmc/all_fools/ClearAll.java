package net.lanternmc.all_fools;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ClearAll extends Command {
    public ClearAll() {
        super("Clearallfools", "bungee.fools");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        All_Fools.getinstance().fools.clear();
    }
}
