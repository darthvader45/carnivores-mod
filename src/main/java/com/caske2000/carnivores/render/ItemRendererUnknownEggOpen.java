package com.caske2000.carnivores.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;



import org.lwjgl.opengl.GL11;

import com.caske2000.carnivores.model.ModelUnknownEggOpen;
import com.caske2000.carnivores.tileentities.TileEntityUnknownEggOpen;



public class ItemRendererUnknownEggOpen implements IItemRenderer {

	TileEntitySpecialRenderer render;
	private TileEntity entity;
	
	
	public ItemRendererUnknownEggOpen(TileEntitySpecialRenderer render, TileEntity entity){
		this.entity = entity;
		this.render = render;
		
	}
	
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
	}
		
	}


