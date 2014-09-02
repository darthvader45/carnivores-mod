package com.caske2000.carnivores.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.caske2000.carnivores.Carnivores;

import com.caske2000.carnivores.entity.EntityRifleBullet;
import com.caske2000.carnivores.reference.Reference;


public class ItemRifle extends CarnivoresItem {

	public ItemRifle() {

		super();
		setCreativeTab(Carnivores.carnivoresTab);
		setUnlocalizedName("rifle");
		this.maxStackSize = 1;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.ammo2)) {

			world.playSoundAtEntity(player, Reference.MODID + ":" + "rifle_sound_1", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote) {

				world.spawnEntityInWorld(new EntityRifleBullet(world, player));

			}

		}
		return itemStack;

	}

}
