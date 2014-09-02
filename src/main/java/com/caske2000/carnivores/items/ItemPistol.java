package com.caske2000.carnivores.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.caske2000.carnivores.Carnivores;
import com.caske2000.carnivores.entity.EntityPistolBullet;
import com.caske2000.carnivores.reference.Reference;


public class ItemPistol extends CarnivoresItem {

	public ItemPistol() {

		super();
		setCreativeTab(Carnivores.carnivoresTab);
		setUnlocalizedName("pistol");
		this.maxStackSize = 1;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.ammo)) {

			world.playSoundAtEntity(player, Reference.MODID + ":" + "pistolFire", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote) {

				world.spawnEntityInWorld(new EntityPistolBullet(world, player));

			}

		}
		return itemStack;

	}

}
