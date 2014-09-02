package com.caske2000.carnivores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.caske2000.carnivores.reference.Reference;
import com.caske2000.carnivores.tileentities.TileEntityUnknownEgg;
import com.caske2000.carnivores.tileentities.TileEntityUnknownEggOpen;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block unknownBox;
	public static Block unknownEgg;
	public static Block unknownEggOpen;

public static void init(){
	unknownBox = new UnknownBox();
	unknownEgg = new BlockUnknownEgg(Material.wood).setBlockName("UnknownEgg").setBlockTextureName(Reference.MODID + ":" + "unknownEggParticles");
	unknownEggOpen = new BlockUnknownEggOpen(Material.wood).setBlockName("UnknownEggOpen").setBlockTextureName(Reference.MODID + ":" + "unknownEggParticles");
	GameRegistry.registerBlock(unknownEgg, "unknownEgg");
	GameRegistry.registerBlock(unknownEggOpen, "unknownEggOpen");
	GameRegistry.registerTileEntity(TileEntityUnknownEgg.class, "");
	GameRegistry.registerTileEntity(TileEntityUnknownEggOpen.class, "2");
	

}
}
