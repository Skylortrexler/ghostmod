package website.skylorbeck.minecraft.ghostmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class Declarar {
    public static Item ghostmode = new Item(new FabricItemSettings().maxCount(1).group(ItemGroup.MISC));
    public static Potion visiblepotion = Registry.register(Registry.POTION, "visibility", new Potion(
            new StatusEffectInstance(StatusEffects.GLOWING, 2400)));
}
