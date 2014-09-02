package com.caske2000.carnivores.handler;

import net.minecraft.entity.EntityList;

import com.caske2000.carnivores.Carnivores;
import com.caske2000.carnivores.entity.EntityPistolBullet;
import com.caske2000.carnivores.entity.EntityUtahraptor;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

	public static void init() {

		registerEntity();

	}

	public static void registerEntity() {

		int id;

		EntityRegistry.registerGlobalEntityID(EntityPistolBullet.class, "Bullet", id = EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityPistolBullet.class, "Bullet", id, Carnivores.instance, 120, 1, true);

		createEntity(EntityUtahraptor.class, "Utahraptor", 64, 1, true, 0x7C7062, 0x584A3D);

	}

	public static void createEntity(Class entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendVelocityUpdates,
			int solidColour, int spotColour) {

		int randomID = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, Carnivores.instance, trackingRange, updateFrequency, sendVelocityUpdates);

		createEgg(solidColour, spotColour, randomID);

	}

	// Use: createEgg(0x + HexCode, 0x + HexCode);
	public static void createEgg(int solidColour, int spotColour, int randomID) {

		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColour, spotColour));
	}
}
