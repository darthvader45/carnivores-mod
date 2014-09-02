package com.caske2000.carnivores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.caske2000.carnivores.handler.ConfigurationHandler;
import com.caske2000.carnivores.handler.EntityHandler;
import com.caske2000.carnivores.handler.KeyHandler;
import com.caske2000.carnivores.items.ModItems;
import com.caske2000.carnivores.proxy.IProxy;
import com.caske2000.carnivores.reference.Reference;
import com.caske2000.carnivores.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY_CLASS)
public class Hunter {

	@Mod.Instance(Reference.MODID)
	public static Hunter instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY_CLASS, serverSide = Reference.COMMONPROXY_CLASS)
	public static IProxy proxy;

	public static CreativeTabs carnivoresTab = new CreativeTabs("carnivoresTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.gun;
		}
	};

	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent event) {

		System.out.println(KeyHandler.points);

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		FMLCommonHandler.instance().bus().register(new KeyHandler());

		ModItems.init();

		/*
		 * Handlers
		 */
		EntityHandler.init();

		/*
		 * Proxy
		 */
		proxy.registerRenderers();

		LogHelper.info("Pre Initialization Completed!");

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		LogHelper.info("Initialization Completed!");

	}

	@Mod.EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

		LogHelper.info("Post Initialization Completed!");

	}

}