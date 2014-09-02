package com.caske2000.carnivores.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.caske2000.carnivores.Hunter;
import com.caske2000.carnivores.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CarnivoresItem extends Item {

	public CarnivoresItem() {

		super();
		setCreativeTab(Hunter.carnivoresTab);
		setMaxStackSize(64);

	}

	@Override
	public String getUnlocalizedName() {

		return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));

	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);

	}

}
