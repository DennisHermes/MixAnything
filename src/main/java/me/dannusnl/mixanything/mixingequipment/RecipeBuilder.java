package me.dannusnl.mixanything.mixingequipment;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeBuilder {

    public RecipeBuilder() {

    }

    public ShapedRecipe blender() {
        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "blender");
        MixAnything.getInstance().getNamespaceKeys().add(key);

        ItemBuilder itemBuilder = new ItemBuilder();
        ShapedRecipe recipe = new ShapedRecipe(key, itemBuilder.blender());

        recipe.shape("NNN", "G G", " I ");
        recipe.setIngredient('N', Material.IRON_NUGGET);
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('I', Material.IRON_INGOT);

        return recipe;
    }

    public ShapedRecipe emptyJar() {
        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "empty_jar");
        MixAnything.getInstance().getNamespaceKeys().add(key);

        ItemBuilder itemBuilder = new ItemBuilder();
        ShapedRecipe recipe = new ShapedRecipe(key, itemBuilder.emptyJar());

        recipe.shape("GWG", "G G", "GGG");
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('W', new RecipeChoice.MaterialChoice(Material.OAK_PLANKS, Material.BIRCH_PLANKS, Material.SPRUCE_PLANKS, Material.JUNGLE_PLANKS, Material.ACACIA_PLANKS, Material.DARK_OAK_PLANKS, Material.MANGROVE_PLANKS));

        return recipe;
    }

    public ShapedRecipe mixer() {
        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "mixer");
        MixAnything.getInstance().getNamespaceKeys().add(key);

        ItemBuilder itemBuilder = new ItemBuilder();
        ShapedRecipe recipe = new ShapedRecipe(key, itemBuilder.mixer());

        recipe.shape("N N", "N N", "NBN");
        recipe.setIngredient('N', Material.IRON_NUGGET);
        recipe.setIngredient('B', Material.BUCKET);

        return recipe;
    }


}
