package com.caske2000.carnivores.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.caske2000.carnivores.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean value = false;

	public static void init(File configFile) {

		// Create the ConfigFile

		if (configuration == null) {

			configuration = new Configuration(configFile);
			loadConfiguration();

		}

	}

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

		if (event.modID.equalsIgnoreCase(Reference.MODID)) {

			// Resync configs
			loadConfiguration();

		}

	}

	private static void loadConfiguration() {

		value = configuration.getBoolean("Huntervalue", Configuration.CATEGORY_GENERAL, true, "Nice boolean");

		if (configuration.hasChanged()) {

			configuration.save();

		}

	}

}
