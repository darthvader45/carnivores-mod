package com.caske2000.carnivores.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

/*
 * Thanks to coolAlias, http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/1571571-1-7-2-sobiohazardouss-forge-keybinding-tutorial
 */
public class KeyHandler {

	public static int points;

	/** Key index for easy handling */
	public static final int CUSTOM_INV = 0;
	/** Key descriptions; use a language file to localize the description later */
	private static final String[] pointsKey = { "key.caske2000.points" };
	/** Default key values */
	private static final int[] keyValues = { Keyboard.KEY_P };
	private final KeyBinding[] keys;

	public KeyHandler() {
		keys = new KeyBinding[pointsKey.length];
		for (int i = 0; i < pointsKey.length; ++i) {
			keys[i] = new KeyBinding(pointsKey[i], keyValues[i], "key.caske2000.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}

	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event
	 * bus
	 */
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {

			if (keys[CUSTOM_INV].isPressed()) {

				ChatComponentText test = new ChatComponentText("Your Points: "
						+ Minecraft.getMinecraft().thePlayer.getEntityData().getInteger("Points"));

				Minecraft.getMinecraft().thePlayer.addChatMessage(test);
				Minecraft.getMinecraft().thePlayer.getEntityData().setInteger("Points",
						Minecraft.getMinecraft().thePlayer.getEntityData().getInteger("Points") + 1);

			}

		}

	}

}
