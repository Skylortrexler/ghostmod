package website.skylorbeck.minecraft.ghostmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PotionItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import website.skylorbeck.minecraft.ghostmod.entities.*;


public class Declarar {
    public static Item ghostmode = new Item(new FabricItemSettings().maxCount(1).group(ItemGroup.MISC));
    public static Item invisibleghostmode = new Item(new FabricItemSettings().maxCount(1).group(ItemGroup.MISC));
    public static Potion visiblepotion = Registry.register(Registry.POTION, "visibility", new Potion(
            new StatusEffectInstance(StatusEffects.GLOWING, 2400)));

    public static final EntityType<GhostCreeperEntity> GHOSTCREEP = regEntity("ghostcreep", GhostCreeperEntity::new, SpawnGroup.MONSTER,0.6f,1.7f,8);
    public static final Item GHOSTCREEPEGG = new SpawnEggItem(GHOSTCREEP, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostEndermanEntity> GHOSTENDERMAN = regEntity("ghostenderman", GhostEndermanEntity::new, SpawnGroup.MONSTER,0.6F, 2.9F, 8);
    public static final Item GHOSTENDERMANEGG = new SpawnEggItem(GHOSTENDERMAN, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostSkeletonEntity> GHOSTSKELETON = regEntity("ghostskeleton", GhostSkeletonEntity::new, SpawnGroup.MONSTER,0.6F, 1.99F, 8);
    public static final Item GHOSTSKELETONEGG = new SpawnEggItem(GHOSTSKELETON, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostSpiderEntity> GHOSTSPIDER = regEntity("ghostspider", GhostSpiderEntity::new, SpawnGroup.MONSTER,1.4F, 0.9F, 8);
    public static final Item GHOSTSPIDEREGG = new SpawnEggItem(GHOSTSPIDER, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostZombieEntity> GHOSTZOMBIE = regEntity("ghostzombie", GhostZombieEntity::new, SpawnGroup.MONSTER,0.6F, 1.95F, 8);
    public static final Item GHOSTZOMBIEEGG = new SpawnEggItem(GHOSTZOMBIE, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostZombieVillagerEntity> GHOSTZOMBIEVILLAGER = regEntity("ghostzombievillager", GhostZombieVillagerEntity::new, SpawnGroup.MONSTER,0.6F, 1.95F, 8);
    public static final Item GHOSTZOMBIEVILLAGEREGG = new SpawnEggItem(GHOSTZOMBIEVILLAGER, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
    public static final EntityType<GhostWitchEntity> GHOSTWITCH = regEntity("ghostwitch",GhostWitchEntity::new, SpawnGroup.MONSTER,0.6F, 1.95F, 8);
    public static final Item GHOSTWITCHEGG = new SpawnEggItem(GHOSTWITCH, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));





    public static <T extends Entity> EntityType<T> regEntity(String name, EntityType.EntityFactory<T> entity, SpawnGroup spawnGroup, float width, float height, int range) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier("ghostmod", name), FabricEntityTypeBuilder.create(spawnGroup, entity).dimensions(EntityDimensions.fixed(width, height)).trackRangeBlocks(range).build());

    }
}