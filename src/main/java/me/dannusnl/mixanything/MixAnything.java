package me.dannusnl.mixanything;

import me.dannusnl.mixanything.flammablediamond.FlammebleDiamond;
import me.dannusnl.mixanything.flammablediamond.PickaxeMining;
import me.dannusnl.mixanything.flammablediamond.PickaxeRecipeBuilder;
import me.dannusnl.mixanything.flammablediamond.PickaxeThrow;
import me.dannusnl.mixanything.mixingequipment.RecipeBuilder;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MixAnything extends JavaPlugin {

    public static MixAnything instance;
    private static final List<NamespacedKey> namespaceKeys = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;

        RecipeBuilder recipeBuilder = new RecipeBuilder();
        Bukkit.addRecipe(recipeBuilder.blender());
        Bukkit.addRecipe(recipeBuilder.emptyJar());
        Bukkit.addRecipe(recipeBuilder.mixer());

        PickaxeRecipeBuilder pickaxeRecipeBuilder = new PickaxeRecipeBuilder();
        Bukkit.addRecipe(pickaxeRecipeBuilder.flammebleDiamondPickaxe());

        getServer().getPluginManager().registerEvents(new FlammebleDiamond(), this);
        getServer().getPluginManager().registerEvents(new PickaxeThrow(), this);
        getServer().getPluginManager().registerEvents(new PickaxeMining(), this);

        getServer().getPluginManager().registerEvents(new PreventMerge(), this);

    }

    public static MixAnything getInstance() {
        return instance;
    }

    public List<NamespacedKey> getNamespaceKeys() {
        return namespaceKeys;
    }

}
