package me.dannusnl.mixanything.spikyiron;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class SpikeyRecipeBuilder {

    public SpikeyRecipeBuilder() {

    }

    public ShapelessRecipe spikeyIronIngot() {
        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "spikey_iron_ingot");
        MixAnything.getInstance().getNamespaceKeys().add(key);

        ItemBuilder itemBuilder = new ItemBuilder();
        ShapelessRecipe recipe = new ShapelessRecipe(key, itemBuilder.spikeyIronIngot());

        recipe.addIngredient(new RecipeChoice.ExactChoice(itemBuilder.spikeyIronBlock()));

        return recipe;
    }

    public ShapedRecipe spikeyIronChestplate() {
        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "spikey_iron_chestplate");
        MixAnything.getInstance().getNamespaceKeys().add(key);

        ItemBuilder itemBuilder = new ItemBuilder();
        ShapedRecipe recipe = new ShapedRecipe(key, itemBuilder.spikeyIronChestplate());

        recipe.shape("I I", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(itemBuilder.spikeyIronIngot()));

        return recipe;
    }

}
