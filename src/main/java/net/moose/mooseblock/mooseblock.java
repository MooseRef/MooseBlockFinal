package net.moose.mooseblock;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.block.custom.ModFlammableBlock;
import net.moose.mooseblock.block.custom.ModStrippableBlock;
import net.moose.mooseblock.enchantment.ModEnchantments;
//import net.moose.mooseblock.entity.ModEntities;
//import net.moose.mooseblock.entity.custom.MooseEntity;
//import net.moose.mooseblock.entity.custom.RaccoonEntity;
//import net.moose.mooseblock.entity.custom.RedPandaEntity;
import net.moose.mooseblock.entity.ModEntities;
import net.moose.mooseblock.entity.custom.MooseEntity;
import net.moose.mooseblock.entity.custom.RaccoonEntity;
import net.moose.mooseblock.entity.custom.RedPandaEntity;
import net.moose.mooseblock.fluid.ModFluids;
import net.moose.mooseblock.item.ModItemGroups;
import net.moose.mooseblock.item.ModItems;
import net.moose.mooseblock.painting.ModPaintings;
import net.moose.mooseblock.particle.ModParticles;
import net.moose.mooseblock.registries.ModRegistries;
import net.moose.mooseblock.util.ModLootTableModifiers;
import net.moose.mooseblock.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class mooseblock implements ModInitializer {
	public static final String MOD_ID = "mooseblock";
	public static final Logger LOGGER = LoggerFactory.getLogger("mooseblock");



	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModFuels();

		ModParticles.registerModParticles();

		ModEnchantments.registerModEnchantments();

		ModPaintings.registerPaintings();

		ModFluids.register();

		ModLootTableModifiers.modifyLootTableModifiers();

		ModWorldGeneration.generateModWorldGen();

		ModFlammableBlock.registerFlammableBlock();
		ModStrippableBlock.registerStrippableBlocks();

		FabricDefaultAttributeRegistry.register(ModEntities.RED_PANDA, RedPandaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOOSE, MooseEntity.setAttributes());

	}

}