package com.jlgm.chatbox.event;

import com.jlgm.chatbox.main.ChatBoxMain;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ChatBoxEventHandler {
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerTickEvent(PlayerTickEvent event){
		if(!ChatBoxMain.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote && !ChatBoxMain.versionChecker.isLatestVersion()){
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge.com/projects/chatbox");
			Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent).setColor(TextFormatting.GREEN);
			TextComponentString versionWarningChatComponent = new TextComponentString("ChatBox is outdated! Click here to update to ");
			TextComponentString versionComponent = new TextComponentString(ChatBoxMain.versionChecker.getLatestVersionInfo().get(0));
			versionComponent.setStyle(new Style().setColor(TextFormatting.RED).setBold(true).setUnderlined(true));
			versionWarningChatComponent.setStyle(clickableChatStyle);
			versionWarningChatComponent.appendSibling(versionComponent);
			event.player.addChatMessage(versionWarningChatComponent);
			event.player.addChatComponentMessage(new TextComponentString("Changelog: ").setStyle(new Style().setColor(TextFormatting.YELLOW)));
			for(int i = 1; i < ChatBoxMain.versionChecker.getLatestVersionInfo().size(); i++){
				event.player.addChatMessage(new TextComponentString("- " + ChatBoxMain.versionChecker.getLatestVersionInfo().get(i)).setStyle(new Style().setColor(TextFormatting.YELLOW)));
			}
			ChatBoxMain.haveWarnedVersionOutOfDate = true;
		}
	}
}