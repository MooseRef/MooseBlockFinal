package net.moose.mooseblock.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.moose.mooseblock.block.custom.*;
import net.moose.mooseblock.item.ModItemGroups;
import net.moose.mooseblock.mooseblock;
import net.moose.mooseblock.world.tree.MoodSaplingGenerator;
import net.moose.mooseblock.world.tree.SatinSaplingGenerator;

public class ModBlocks {

    public static final Block MOOD_LOG = registerBlock("mood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)),ModItemGroups.MOOSITE);
    public static final Block MOOD_WOOD = registerBlock("mood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)),ModItemGroups.MOOSITE);
    public static final Block STRIPPED_MOOD_LOG = registerBlock("stripped_mood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)),ModItemGroups.MOOSITE);
    public static final Block STRIPPED_MOOD_WOOD = registerBlock("stripped_mood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)),ModItemGroups.MOOSITE);
    public static final Block MOOD_LEAVES = registerBlock("mood_leaves",
            new MoodLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.2f).requiresTool()),ModItemGroups.MOOSITE);

    public static final Block MOOD_PLANKS = registerBlock("mood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block MOOD_STAIRS = registerBlock("mood_stairs",
            new StairsBlock(MOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block MOOD_SLAB = registerBlock("mood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block MOOD_FENCE = registerBlock("mood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block MOOD_FENCE_GATE = registerBlock("mood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f,3.0f).requiresTool(),
                    WoodType.OAK), ModItemGroups.MOOSITE);
    public static final Block MOOD_BUTTON = registerBlock("mood_button",
            new ButtonBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD), BlockSetType.OAK, 30, true), ModItemGroups.MOOSITE);
    public static final Block MOOD_PRESSURE_PLATE = registerBlock("mood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD,
                    MOOD_PLANKS.getDefaultMapColor()).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD),
                    BlockSetType.OAK),ModItemGroups.MOOSITE);
    public static final Block MOOD_DOOR = registerBlock("mood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f,3.0f).requiresTool().nonOpaque(),
                    BlockSetType.OAK), ModItemGroups.MOOSITE);
    public static final Block MOOD_TRAPDOOR = registerBlock("mood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f,3.0f).requiresTool().nonOpaque(),
                   BlockSetType.OAK), ModItemGroups.MOOSITE);
    public static final Block MOOD_REDSTONE_LAMP = registerBlock("mood_redstone_lamp",
            new MoodRedstoneLampBlock(FabricBlockSettings.of(Material.METAL).strength(4).requiresTool()
                    .luminance(state -> state.get(MoodRedstoneLampBlock.LIT) ? 15 : 0)),ModItemGroups.MOOSITE);

    public static final Block MOOD_SAPLING = registerBlock("mood_sapling",
            new SaplingBlock(new MoodSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).noCollision().breakInstantly().requiresTool().sounds(BlockSoundGroup.GRASS)),ModItemGroups.MOOSITE);
    public static final Block POTTED_MOOD_SAPLING = registerBlockWithoutItem("potted_mood_sapling",
            new FlowerPotBlock(MOOD_SAPLING, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);

    public static final Block SATIN_LOG = registerBlock("satin_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)),ModItemGroups.MOOSITE);
    public static final Block SATIN_WOOD = registerBlock("satin_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)),ModItemGroups.MOOSITE);
    public static final Block STRIPPED_SATIN_LOG = registerBlock("stripped_satin_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)),ModItemGroups.MOOSITE);
    public static final Block STRIPPED_SATIN_WOOD = registerBlock("stripped_satin_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)),ModItemGroups.MOOSITE);
    public static final Block SATIN_LEAVES = registerBlock("satin_leaves",
            new SatinLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.2f).requiresTool()),ModItemGroups.MOOSITE);

    public static final Block SATIN_PLANKS = registerBlock("satin_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block SATIN_STAIRS = registerBlock("satin_stairs",
            new StairsBlock(SATIN_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block SATIN_SLAB = registerBlock("satin_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block SATIN_FENCE = registerBlock("satin_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block SATIN_FENCE_GATE = registerBlock("satin_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f,3.0f).requiresTool(),
                    WoodType.OAK), ModItemGroups.MOOSITE);
    public static final Block SATIN_BUTTON = registerBlock("satin_button",
            new ButtonBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD), BlockSetType.OAK,30, true), ModItemGroups.MOOSITE);
    public static final Block SATIN_PRESSURE_PLATE = registerBlock("satin_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD,
                    SATIN_PLANKS.getDefaultMapColor()).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD),
                    BlockSetType.OAK),ModItemGroups.MOOSITE);
    public static final Block SATIN_DOOR = registerBlock("satin_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f,3.0f).requiresTool().nonOpaque(),
                    BlockSetType.OAK), ModItemGroups.MOOSITE);
    public static final Block SATIN_TRAPDOOR = registerBlock("satin_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f,3.0f).requiresTool().nonOpaque(),
                    BlockSetType.OAK), ModItemGroups.MOOSITE);

    public static final Block SATIN_SAPLING = registerBlock("satin_sapling",
            new SaplingBlock(new SatinSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).noCollision().breakInstantly().requiresTool().sounds(BlockSoundGroup.GRASS)),ModItemGroups.MOOSITE);
    public static final Block POTTED_SATIN_SAPLING = registerBlockWithoutItem("potted_satin_sapling",
            new FlowerPotBlock(SATIN_SAPLING, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);


    public static final Block BLACK_ROSE = registerBlock("black_rose",
            new FlowerBlock(StatusEffects.BAD_OMEN, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_BLACK_ROSE = registerBlockWithoutItem("potted_black_rose",
            new FlowerPotBlock(BLACK_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block WHITE_ROSE = registerBlock("white_rose",
            new FlowerBlock(StatusEffects.GLOWING, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_WHITE_ROSE = registerBlockWithoutItem("potted_white_rose",
            new FlowerPotBlock(WHITE_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block RED_ROSE = registerBlock("red_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_RED_ROSE = registerBlockWithoutItem("potted_red_rose",
            new FlowerPotBlock(RED_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block ORANGE_ROSE = registerBlock("orange_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_ORANGE_ROSE = registerBlockWithoutItem("potted_orange_rose",
            new FlowerPotBlock(ORANGE_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block YELLOW_ROSE = registerBlock("yellow_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_YELLOW_ROSE = registerBlockWithoutItem("potted_yellow_rose",
            new FlowerPotBlock(YELLOW_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block ILL_ROSE = registerBlock("ill_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_ILL_ROSE = registerBlockWithoutItem("potted_ill_rose",
            new FlowerPotBlock(ILL_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block CYAN_ROSE = registerBlock("cyan_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_CYAN_ROSE = registerBlockWithoutItem("potted_cyan_rose",
            new FlowerPotBlock(CYAN_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block BLUE_ROSE = registerBlock("blue_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_BLUE_ROSE = registerBlockWithoutItem("potted_blue_rose",
            new FlowerPotBlock(BLUE_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block PINK_ROSE = registerBlock("pink_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_PINK_ROSE = registerBlockWithoutItem("potted_pink_rose",
            new FlowerPotBlock(PINK_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block PURPLE_ROSE = registerBlock("purple_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_PURPLE_ROSE = registerBlockWithoutItem("potted_purple_rose",
            new FlowerPotBlock(PURPLE_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);
    public static final Block RAINBOW_ROSE = registerBlock("rainbow_rose",
            new FlowerBlock(StatusEffects.STRENGTH, 9, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),ModItemGroups.MOOSITE);
    public static final Block POTTED_RAINBOW_ROSE = registerBlockWithoutItem("potted_rainbow_rose",
            new FlowerPotBlock(RAINBOW_ROSE, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque()), ModItemGroups.MOOSITE);



    public static final Block GNEISS = registerBlock("gneiss",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).strength(3.0f,3.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block GNEISS_STAIRS = registerBlock("gneiss_stairs",
            new StairsBlock(MOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block GNEISS_SLAB = registerBlock("gneiss_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block GNEISS_WALL = registerBlock("gneiss_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);

    public static final Block POLISHED_GNEISS = registerBlock("polished_gneiss",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).strength(3.0f,3.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block POLISHED_GNEISS_STAIRS = registerBlock("polished_gneiss_stairs",
            new StairsBlock(MOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block POLISHED_GNEISS_SLAB = registerBlock("polished_gneiss_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);
    public static final Block POLISHED_GNEISS_WALL = registerBlock("polished_gneiss_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL).strength(3.0f,3.0f).requiresTool()),ModItemGroups.MOOSITE);

    public static final Block GOXITE_ORE = registerBlock("goxite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block DEEPSLATE_GOXITE_ORE = registerBlock("deepslate_goxite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block BLOCK_OF_GOXITE = registerBlock("block_of_goxite",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block BLOCK_OF_RAW_GOXITE = registerBlock("block_of_raw_goxite",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);

    public static final Block BORPITE_ORE = registerBlock("borpite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block DEEPSLATE_BORPITE_ORE = registerBlock("deepslate_borpite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block BLOCK_OF_BORPITE = registerBlock("block_of_borpite",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);
    public static final Block BLOCK_OF_RAW_BORPITE = registerBlock("block_of_raw_borpite",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f,4.0f).requiresTool()), ModItemGroups.MOOSITE);

    public static final Block MOOSITE_ORE = registerBlock("moosite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool(), UniformIntProvider.create(3,7)), ModItemGroups.MOOSITE);
    public static final Block DEEPSLATE_MOOSITE_ORE = registerBlock("deepslate_moosite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f,4.0f).requiresTool(), UniformIntProvider.create(3,7)), ModItemGroups.MOOSITE);
    public static final Block BLOCK_OF_MOOSITE = registerBlock("block_of_moosite",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)), ModItemGroups.MOOSITE);

    public static final Block TOMATO_CROP = registerBlockWithoutItem("tomato_crop",
            new TomatoCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)), ModItemGroups.MOOSITE);

    public static final Block VISION_PAD = registerBlock("vision_pad",
            new NightVisionBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f,4.0f)), ModItemGroups.MOOSITE);


    private static Block registerBlockWithoutItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.BLOCK, new Identifier(mooseblock.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(mooseblock.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        Item item = Registry.register(Registries.ITEM, new Identifier(mooseblock.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }
    public static void registerModBlocks(){
        mooseblock.LOGGER.info("Registering ModBlocks for " + mooseblock.MOD_ID);
    }
}
