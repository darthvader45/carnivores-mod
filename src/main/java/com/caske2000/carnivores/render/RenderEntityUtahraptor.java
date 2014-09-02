package com.caske2000.carnivores.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.caske2000.carnivores.entity.EntityUtahraptor;
import com.caske2000.carnivores.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityUtahraptor extends RenderLiving {

	private static final ResourceLocation utahTextures = new ResourceLocation(Reference.MODID + ":textures/entity/utahRaptor.png");
	private static final String __OBFID = "CL_00000984";

	public RenderEntityUtahraptor(ModelBase mobelBase, float var2) {

		super(mobelBase, var2);

	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityUtahraptor utah) {

		return utahTextures;

	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity entity) {

		return this.getEntityTexture((EntityUtahraptor) entity);

	}

}