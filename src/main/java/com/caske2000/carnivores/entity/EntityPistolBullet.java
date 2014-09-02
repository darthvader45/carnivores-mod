package com.caske2000.carnivores.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityPistolBullet extends EntityThrowable {

	private int lifeTime = 100;
	private double speed = 1.001;
	private final int damage = 6;

	public EntityPistolBullet(World world) {

		super(world);
		setSize(0.5F, 0.5F);

	}

	public EntityPistolBullet(World world, EntityLivingBase entity) {

		super(world, entity);

	}

	public EntityPistolBullet(World world, double var2, double var3, double var4) {

		super(world, var2, var3, var4);

	}

	@Override
	protected void onImpact(MovingObjectPosition movObjPos) {

		if (movObjPos.typeOfHit == MovingObjectType.ENTITY) {

			movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);

		} else if (movObjPos.typeOfHit == MovingObjectType.BLOCK) {

		}

		this.setDead();

	}

	/*
	 * @Override protected float getGravityVelocity() {
	 * 
	 * this.motionX *= speed; this.motionY *= speed; this.motionZ *= speed;
	 * return 0;
	 * 
	 * }
	 */

	public int getMaxLifetime() {
		return 200;
	}

	public float getAirResistance() {
		return 0.98F;
	}

	public float getGravity() {
		return getGravityVelocity() < 3.0D ? 0.07F : 0.0F;
	}

	public int getMaxArrowShake() {
		return 0;
	}

}
