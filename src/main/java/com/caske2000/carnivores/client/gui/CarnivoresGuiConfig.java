package com.caske2000.carnivores.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.caske2000.carnivores.handler.ConfigurationHandler;
import com.caske2000.carnivores.reference.Reference;

import cpw.mods.fml.client.config.GuiConfig;

public class CarnivoresGuiConfig extends GuiConfig {

	public CarnivoresGuiConfig(GuiScreen guiScreen) {

		super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));

	}

}
