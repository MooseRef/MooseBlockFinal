package net.moose.mooseblock.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.fluid.ModFluids;
import net.moose.mooseblock.item.ModItems;
import net.moose.mooseblock.mooseblock;
import net.moose.mooseblock.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter)
    {
        offerPlanksRecipe(exporter,ModBlocks.MOOD_PLANKS, ModTags.Items.MOOD_LOGS,4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.MOOD_WOOD)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.MOOD_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_LOG))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.STRIPPED_MOOD_WOOD)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.STRIPPED_MOOD_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_MOOD_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_MOOD_LOG))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "stripped_mood_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_SLAB, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_FENCE, 3)
                .pattern("   ")
                .pattern("XSX")
                .pattern("XSX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_fence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("SXS")
                .pattern("SXS")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_fence_gate"));
        offerSingleOutputShapelessRecipe(exporter,ModBlocks.MOOD_BUTTON,ModBlocks.MOOD_PLANKS,"wooden_button");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("XX ")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_pressure_plate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_DOOR, 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_door"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_trapdoor"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOOD_REDSTONE_LAMP, 1)
                .pattern("XRX")
                .pattern("RGR")
                .pattern("XRX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('R',Items.REDSTONE)
                .input('G',Blocks.GLOWSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "mood_redstone_lamp"));


        offerPlanksRecipe(exporter,ModBlocks.SATIN_PLANKS, ModTags.Items.SATIN_LOGS,4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.SATIN_WOOD)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.SATIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_LOG))
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "satin_wood"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.STRIPPED_SATIN_WOOD)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.STRIPPED_SATIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SATIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SATIN_LOG))
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "stripped_satin_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_SLAB, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_FENCE, 3)
                .pattern("   ")
                .pattern("XSX")
                .pattern("XSX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_fence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("SXS")
                .pattern("SXS")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_fence_gate"));
        offerSingleOutputShapelessRecipe(exporter,ModBlocks.SATIN_BUTTON,ModBlocks.SATIN_PLANKS,"wooden_button");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("XX ")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_pressure_plate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_DOOR, 3)
                .pattern("XX ")
                .pattern("XG ")
                .pattern("XX ")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_door"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SATIN_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XGX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_trapdoor"));

        offerSmelting(exporter, List.of(ModBlocks.MOOD_LOG), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"mood");
        offerSmelting(exporter, List.of(ModBlocks.STRIPPED_MOOD_LOG), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"mood");
        offerSmelting(exporter, List.of(ModBlocks.MOOD_WOOD), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"mood");
        offerSmelting(exporter, List.of(ModBlocks.STRIPPED_MOOD_WOOD), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"mood");
        offerSmelting(exporter, List.of(ModBlocks.SATIN_LOG), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"satin");
        offerSmelting(exporter, List.of(ModBlocks.STRIPPED_SATIN_LOG), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"satin");
        offerSmelting(exporter, List.of(ModBlocks.SATIN_WOOD), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"satin");
        offerSmelting(exporter, List.of(ModBlocks.STRIPPED_SATIN_WOOD), RecipeCategory.MISC, Items.CHARCOAL,
                0.15f, 200,"satin");

        offerSmelting(exporter, List.of(ModItems.RAW_GOXITE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModItems.RAW_GOXITE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 100,"moosite");
        offerSmelting(exporter, List.of(ModBlocks.GOXITE_ORE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.GOXITE_ORE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 100,"moosite");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_GOXITE_ORE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_GOXITE_ORE), RecipeCategory.MISC, ModItems.GOXITE,
                0.5f, 100,"moosite");

        offerSmelting(exporter, List.of(ModItems.RAW_BORPITE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModItems.RAW_BORPITE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 100,"moosite");
        offerSmelting(exporter, List.of(ModBlocks.BORPITE_ORE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.BORPITE_ORE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 100,"moosite");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_BORPITE_ORE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_BORPITE_ORE), RecipeCategory.MISC, ModItems.BORPITE,
                0.5f, 100,"moosite");

        offerSmelting(exporter, List.of(ModBlocks.MOOSITE_ORE), RecipeCategory.MISC, ModItems.MOOSITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.MOOSITE_ORE), RecipeCategory.MISC, ModItems.MOOSITE,
                0.5f, 100,"moosite");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_MOOSITE_ORE), RecipeCategory.MISC, ModItems.MOOSITE,
                0.5f, 200,"moosite");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_MOOSITE_ORE), RecipeCategory.MISC, ModItems.MOOSITE,
                0.5f, 100,"moosite");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLISHED_GNEISS, 4)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("   ")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GNEISS_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GNEISS_SLAB, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GNEISS_WALL, 6)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_wall"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLISHED_GNEISS_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLISHED_GNEISS_SLAB, 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLISHED_GNEISS_WALL, 6)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_wall"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.GNEISS_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.GNEISS_STAIRS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.GNEISS_WALL);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.POLISHED_GNEISS_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.POLISHED_GNEISS_STAIRS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS, ModBlocks.POLISHED_GNEISS_WALL);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GOXITE, RecipeCategory.DECORATIONS,
                ModBlocks.BLOCK_OF_GOXITE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GOXITE, RecipeCategory.DECORATIONS,
                ModBlocks.BLOCK_OF_RAW_GOXITE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BORPITE, RecipeCategory.DECORATIONS,
                ModBlocks.BLOCK_OF_BORPITE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BORPITE, RecipeCategory.DECORATIONS,
                ModBlocks.BLOCK_OF_RAW_BORPITE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOOSITE, RecipeCategory.DECORATIONS,
                ModBlocks.BLOCK_OF_MOOSITE);

        offerSingleOutputShapelessRecipe(exporter,ModItems.TOMATO_SEEDS,ModItems.TOMATO,"tomato_seeds");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOLDEN_TOMATO)
                .pattern("GGG")
                .pattern("GXG")
                .pattern("GGG")
                .input('X',ModItems.TOMATO)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOMATO),
                        FabricRecipeProvider.conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "golden_tomato"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ILL_ROSE)
                .pattern("   ")
                .pattern(" R ")
                .pattern(" W ")
                .input('R',ModTags.Items.MOOSE_ROSES)
                .input('W',Blocks.WITHER_ROSE)
                .criterion(FabricRecipeProvider.hasItem(Blocks.WITHER_ROSE),
                        FabricRecipeProvider.conditionsFromItem(Blocks.WITHER_ROSE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "ill_rose"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.RAINBOW_ROSE)
                .pattern("YGC")
                .pattern("ONB")
                .pattern("RPM")
                .input('R',ModBlocks.RED_ROSE)
                .input('O',ModBlocks.ORANGE_ROSE)
                .input('Y',ModBlocks.YELLOW_ROSE)
                .input('G',ModBlocks.ILL_ROSE)
                .input('C',ModBlocks.CYAN_ROSE)
                .input('B',ModBlocks.BLUE_ROSE)
                .input('M',ModBlocks.PURPLE_ROSE)
                .input('P',ModBlocks.PINK_ROSE)
                .input('N',Items.GOLD_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ILL_ROSE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ILL_ROSE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "rainbow_rose"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_BOOTS)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_CHESTPLATE)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_LEGGINGS)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_HELMET)
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_AXE)
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_HOE)
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_SHOVEL)
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_SWORD)
                .pattern("X")
                .pattern("X")
                .pattern("S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOXITE_PICKAXE)
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_pickaxe"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_BOOTS)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_CHESTPLATE)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_LEGGINGS)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_HELMET)
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_AXE)
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_HOE)
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_SHOVEL)
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_SWORD)
                .pattern("X")
                .pattern("X")
                .pattern("S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BORPITE_PICKAXE)
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_CUBE)
                .pattern(" X ")
                .pattern("XRX")
                .pattern(" X ")
                .input('X',ModItems.MOOSITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MOOSITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MOOSITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_cube"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_DODECAHEDRON)
                .pattern(" XX")
                .pattern("XRX")
                .pattern("XX ")
                .input('X',ModItems.BORPITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_dodecahedron"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_ICOSAHEDRON)
                .pattern("XXX")
                .pattern("XRX")
                .pattern("XXX")
                .input('X',ModItems.GOXITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_icosahedron"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModFluids.GLUE_BUCKET)
                .pattern("XXX")
                .pattern("XWX")
                .pattern("XXX")
                .input('X', Items.LEATHER)
                .input('W', Items.WATER_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(Items.WATER_BUCKET),
                        FabricRecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "glue_bucket"));


        offerSingleOutputShapelessRecipe(exporter,Items.BLACK_DYE,ModBlocks.BLACK_ROSE,"roses");


        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_GRAY_DYE,ModBlocks.WHITE_ROSE,"roses");
        offerSingleOutputShapelessRecipe(exporter,Items.RED_DYE,ModBlocks.RED_ROSE,"roses");
        offerSingleOutputShapelessRecipe(exporter,Items.ORANGE_DYE,ModBlocks.ORANGE_ROSE,"roses");

        offerSingleOutputShapelessRecipe(exporter,Items.YELLOW_DYE,ModBlocks.YELLOW_ROSE,"roses");

        offerSingleOutputShapelessRecipe(exporter,Items.GREEN_DYE,ModBlocks.ILL_ROSE,"roses");

        offerSingleOutputShapelessRecipe(exporter,Items.CYAN_DYE,ModBlocks.CYAN_ROSE,"roses");
        offerSingleOutputShapelessRecipe(exporter,Items.BLUE_DYE,ModBlocks.BLUE_ROSE,"roses");
        offerSingleOutputShapelessRecipe(exporter,Items.PINK_DYE,ModBlocks.PINK_ROSE,"roses");
        offerSingleOutputShapelessRecipe(exporter,Items.PURPLE_DYE,ModBlocks.PURPLE_ROSE,"roses");


                    }


}
