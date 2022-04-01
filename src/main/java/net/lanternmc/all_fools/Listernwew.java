package net.lanternmc.all_fools;

import net.lanternmc.bungeemanager.BungeeManager;
import net.lanternmc.bungeemanager.Motd.MOTDListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import javax.tools.Tool;

import java.net.SocketAddress;

import static net.md_5.bungee.event.EventPriority.HIGHEST;

public class Listernwew implements Listener {

    @EventHandler(priority = HIGHEST)
    public void aVoid(ProxyPingEvent e) {
        System.out.println(e.getConnection().getSocketAddress());
        for (String s: All_Fools.getinstance().fools) {
            System.out.println(s);
        }
        if (All_Fools.getinstance().fools.contains(All_Fools.getNum(String.valueOf(e.getConnection().getSocketAddress())))) {
            All_Fools.getinstance().getLogger().info("有个傻瓜被困住了");
            All_Fools.getinstance().getProxy().getPluginManager().unregisterListener(new MOTDListener());

            ServerPing response = e.getResponse();
            ServerPing.Players players = response.getPlayers();
            players.setMax(-1);
            TextComponent Motds = new TextComponent(ChatColor.translateAlternateColorCodes('&', "§4Can't connect to server."));
            response.setDescriptionComponent(new TextComponent(Motds));

            huanyuan();
        }
    }

    private void huanyuan() {
        All_Fools.getinstance().getProxy().getScheduler().runAsync(All_Fools.getinstance(), () -> {
            for (int i = 0; i >= 5000; i++) {
                BungeeManager.instance.getProxy().getPluginManager().registerListener(BungeeManager.instance, new MOTDListener());
            }
        });
    }


    @EventHandler(priority = HIGHEST)
    public void aVoid(PlayerHandshakeEvent e) {
        if (All_Fools.getinstance().fools.contains(e.getConnection().getName())){
            TextComponent Motds = new TextComponent(ChatColor.translateAlternateColorCodes('&', "§cCan't connect to server."));
            e.getConnection().disconnect(Motds);
        }
    }



}
