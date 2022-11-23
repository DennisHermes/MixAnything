package me.dannusnl.mixanything.flammablediamond;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class PickaxeRecipeBuilder {

    public PickaxeRecipeBuilder() {

    }

    public ShapedRecipe flammebleDiamondPickaxe() {
        ItemBuilder itemBuilder = new ItemBuilder();

        NamespacedKey key = new NamespacedKey(MixAnything.getInstance(), "pickaxe");
        MixAnything.getInstance().getNamespaceKeys().add(key);
        ShapedRecipe flammebleDiamondPickaxe = new ShapedRecipe(key, itemBuilder.flammebleDiamondPickaxe());

        flammebleDiamondPickaxe.shape("DDD", " D ", " D ");
        flammebleDiamondPickaxe.setIngredient('D', new RecipeChoice.ExactChoice(itemBuilder.flammebleDiamond()));
        return flammebleDiamondPickaxe;
    }

}
