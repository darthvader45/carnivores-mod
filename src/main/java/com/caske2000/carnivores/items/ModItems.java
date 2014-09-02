package com.caske2000.carnivores.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static final CarnivoresItem ammo = new ItemPistolAmmo();
	public static final CarnivoresItem pistol = new ItemPistol();
	public static final CarnivoresItem ammo2 = new ItemRifleAmmo();
	public static final CarnivoresItem rifle = new ItemRifle();
	public static void init() {

		GameRegistry.registerItem(ammo, "ammo");
		GameRegistry.registerItem(ammo2, "ammo2");
		GameRegistry.registerItem(pistol, "pistol");		
		GameRegistry.registerItem(rifle, "rifle");
	}

}
