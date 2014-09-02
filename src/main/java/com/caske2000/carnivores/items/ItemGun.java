package com.caske2000.carnivores.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.caske2000.carnivores.entity.EntityBullet;
import com.caske2000.carnivores.reference.Sounds;

public class ItemGun extends HunterItem {

	public ItemGun() {

		super();
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("gun");

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(ModItems.ammo)) {

			world.playSoundAtEntity(player, Sounds.pistolFire, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote) {

				world.spawnEntityInWorld(new EntityBullet(world, player));

			}

		}
		return itemStack;

	}

}
