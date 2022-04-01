package net.lanternmc.all_fools;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ServerConnectRequest;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Command;

public class CloseServer extends Command {
    /**
     * Construct a new command with no permissions or aliases.
     *
     */
    public CloseServer() {
        super("closeserver");
    }

    /**
     * Execute this command with the specified sender and arguments.
     *
     * @param sender the executor of this command
     * @param args   arguments used to invoke this command
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        All_Fools.getinstance().getLogger().info(p.getName() + "变成了傻瓜");

        All_Fools.getinstance().fools.add(All_Fools.getNum(String.valueOf(p.getSocketAddress())));
        TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', "[Proxy] Proxy restarting."));
        p.disconnect(component);
    }
}
