package com.jlgm.chatbox.main;

import com.jlgm.chatbox.block.ChatBoxBlock;
import com.jlgm.chatbox.tileentity.ChatBoxTileEntity;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent preInitEvent){
		super.preInit(preInitEvent);
	}
	
	@Override
	public void init(FMLInitializationEvent initEvent){
		super.init(initEvent);
		ChatBoxBlock.renderBlock();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent postInitEvent){
		super.postInit(postInitEvent);
	}
}