package com.caske2000.carnivores.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCarnivoresMob extends EntityMob {

	public EntityCarnivoresMob(World world) {

		super(world);
		this.setSize(1.0F, 1.0F);

		this.tasks.addTask(0, new EntityAIWander(this, 0.2D));

		/*
		 * this.tasks.addTask(1, new EntityAINearestAttackableTarget(this,
		 * EntityMob.class, 0, true)); this.tasks.addTask(2, new
		 * EntityAINearestAttackableTarget(this, EntityAnimal.class, 0, true));
		 * this.tasks.addTask(3, new EntityAINearestAttackableTarget(this,
		 * EntityPlayer.class, 0, true));
		 */

		this.tasks.addTask(4, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAILeapAtTarget(this, 0.2F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, 0, true));

	}

	public EnumCreatureAttribute getCreatureAttribute() {

		return EnumCreatureAttribute.UNDEFINED;

	}

	protected double getAttackStrenght() {
		return 2.0D;
	}

	protected double getMovementSpeed() {
		return 0.2D;
	}

	public boolean isAIEnabled() {

		return true;

	}

	protected void applyEntityAttributes() {

		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		// this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);

	}

	protected Entity findPlayerToAttack() {

		float f = this.getBrightness(1.0F);

		if (f < 0.5F) {

			double d0 = 30.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);

		} else {

			return null;

		}

	}

	/*
	 * protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
	 * 
	 * float f1 = this.getBrightness(1.0F);
	 * 
	 * if (f1 > 0.5F && this.rand.nextInt(100) == 0) {
	 * 
	 * this.entityToAttack = null;
	 * 
	 * } else {
	 * 
	 * if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0)
	 * {
	 * 
	 * if (this.onGround) {
	 * 
	 * double d0 = p_70785_1_.posX - this.posX; double d1 = p_70785_1_.posZ -
	 * this.posZ; float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
	 * this.motionX = d0 / (double) f2 * 0.5D * 0.800000011920929D +
	 * this.motionX * 0.20000000298023224D; this.motionZ = d1 / (double) f2 *
	 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
	 * this.motionY = 0;
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * super.attackEntity(p_70785_1_, p_70785_2_);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public boolean attackEntityAsMob(Entity p_70652_1_) {
		boolean flag = super.attackEntityAsMob(p_70652_1_);

		if (flag) {
			int i = this.worldObj.difficultySetting.getDifficultyId();

			if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float) i * 0.3F) {
				p_70652_1_.setFire(2 * i);
			}
		}

		return flag;
	}

}
