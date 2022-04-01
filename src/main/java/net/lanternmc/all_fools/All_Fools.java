package net.lanternmc.all_fools;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.protocol.packet.ClearTitles;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class All_Fools extends Plugin {
    public static All_Fools instance;
    public List<String> fools = new ArrayList<>();


    public static All_Fools getinstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("§1你§2被§3耍§4到§5了 ");
        getLogger().info("§6骗玩家输入/closeserver去吧");
        getLogger().info("§7/Clearallfools 清理所有傻瓜");
        getProxy().getPluginManager().registerCommand(this, new CloseServer());
        getProxy().getPluginManager().registerCommand(this, new ClearAll());
        getProxy().getPluginManager().registerListener(this, new Listernwew());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static String getNum(String s) {
        Pattern r = Pattern.compile(":[\\S]+");
        Matcher m = r.matcher(s);

        if (m.find()) {
            return m.replaceAll("");
        }

        return null;
    }



    /**
     * 删除方法一
     * @param str
     * @param delChar
     * @return
     */
    public static String deleteString0(String str, char delChar){
        String delStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != delChar){
                delStr += str.charAt(i);
            }
        }
        return delStr;
    }

    /**
     * 删除方法一
     * @param str
     * @param delChar
     * @return
     */
    public static String deleteString2(String str, char delChar) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != delChar) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
