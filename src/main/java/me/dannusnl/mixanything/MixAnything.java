package me.dannusnl.mixanything;

import me.dannusnl.mixanything.flammablediamond.FlammebleDiamond;
import me.dannusnl.mixanything.flammablediamond.PickaxeMining;
import me.dannusnl.mixanything.flammablediamond.PickaxeRecipeBuilder;
import me.dannusnl.mixanything.flammablediamond.PickaxeThrow;
import me.dannusnl.mixanything.luckyfoodblock.LuckyEating;
import me.dannusnl.mixanything.luckyfoodblock.LuckyFoodBlock;
import me.dannusnl.mixanything.mixingequipment.RecipeBuilder;
import me.dannusnl.mixanything.spikyiron.SpikeyRecipeBuilder;
import me.dannusnl.mixanything.theoreticalspace.ActivateSpaceBuffs;
import me.dannusnl.mixanything.theoreticalspace.BlockRemoving;
import me.dannusnl.mixanything.theoreticalspace.GuiUse;
import me.dannusnl.mixanything.warden.WardenBeam;
import me.dannusnl.mixanything.warden.WardenHorn;
import me.dannusnl.mixanything.warden.WardenReward;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MixAnything extends JavaPlugin {

    public static MixAnything instance;
    private static final List<NamespacedKey> namespaceKeys = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;

        RecipeBuilder equipmentRecipeBuilder = new RecipeBuilder();
        Bukkit.addRecipe(equipmentRecipeBuilder.blender());
        Bukkit.addRecipe(equipmentRecipeBuilder.emptyJar());
        Bukkit.addRecipe(equipmentRecipeBuilder.mixer());

        SpikeyRecipeBuilder ironRecipeBuilder = new SpikeyRecipeBuilder();
        Bukkit.addRecipe(ironRecipeBuilder.spikeyIronIngot());
        Bukkit.addRecipe(ironRecipeBuilder.spikeyIronChestplate());

        PickaxeRecipeBuilder pickaxeRecipeBuilder = new PickaxeRecipeBuilder();
        Bukkit.addRecipe(pickaxeRecipeBuilder.flammebleDiamondPickaxe());

        getServer().getPluginManager().registerEvents(new FlammebleDiamond(), this);
        getServer().getPluginManager().registerEvents(new PickaxeThrow(), this);
        getServer().getPluginManager().registerEvents(new PickaxeMining(), this);

        getServer().getPluginManager().registerEvents(new LuckyFoodBlock(), this);
        getServer().getPluginManager().registerEvents(new LuckyEating(), this);

        getServer().getPluginManager().registerEvents(new WardenHorn(), this);
        getServer().getPluginManager().registerEvents(new WardenReward(), this);
        getServer().getPluginManager().registerEvents(new WardenBeam(), this);

        getServer().getPluginManager().registerEvents(new ActivateSpaceBuffs(), this);
        getServer().getPluginManager().registerEvents(new GuiUse(), this);
        getServer().getPluginManager().registerEvents(new BlockRemoving(), this);

        getServer().getPluginManager().registerEvents(new UnlockRecipes(), this);
        getServer().getPluginManager().registerEvents(new PreventMerge(), this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                WardenBeam wardenBeam = new WardenBeam();
                wardenBeam.wardenBeam(p);
            }
        }, 0, 10);

    }

    public static MixAnything getInstance() {
        return instance;
    }

    public List<NamespacedKey> getNamespaceKeys() {
        return namespaceKeys;
    }

}
