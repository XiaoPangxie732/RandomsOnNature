package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import cn.maxpixel.mods.randomsonnature.registry.tags.ItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS, BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG);
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS, BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG);
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS, BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG);
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS, BlockRegistry.LIGHTNING_POWERED_OAK_LOG);
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS, BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG);
        planksFromLightningPoweredLog(output, BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS, BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemRegistry.LIGHTNING_POWERED_WOODEN_AXE)
                .define('#', Items.STICK)
                .define('X', ItemTags.LIGHTNING_POWERED_PLANKS)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_stick", has(Items.STICK))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.LIGHTNING_POWERED_WOODEN_SWORD)
                .define('#', Items.STICK)
                .define('X', ItemTags.LIGHTNING_POWERED_PLANKS)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_stick", has(Items.STICK))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.WIND_TUNNEL_CONTROLLER)
                .define('#', Items.GRAY_CONCRETE)
                .define('X', Items.PISTON)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_piston", has(Items.PISTON))
                .save(output);
    }

    private static void planksFromLightningPoweredLog(RecipeOutput output, ItemLike planks, ItemLike logs) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 2)
                .requires(logs)
                .group("planks")
                .unlockedBy("has_log", has(logs))
                .save(output);
    }
}