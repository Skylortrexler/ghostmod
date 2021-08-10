package website.skylorbeck.minecraft.ghostmod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Registrar {

    public static void register(){
        regItem("ghostmode",Declarar.ghostmode);
        regItem("invisibleghostmode",Declarar.invisibleghostmode);

        FabricDefaultAttributeRegistry.register(Declarar.GHOSTCREEP, CreeperEntity.createCreeperAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostcreepegg"), Declarar.GHOSTCREEPEGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTENDERMAN, EndermanEntity.createEndermanAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostendermanegg"), Declarar.GHOSTENDERMANEGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTSKELETON, SkeletonEntity.createAbstractSkeletonAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostskeletonegg"), Declarar.GHOSTSKELETONEGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTSPIDER, SpiderEntity.createSpiderAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostspideregg"), Declarar.GHOSTSPIDEREGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTZOMBIE, ZombieEntity.createZombieAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostzombieegg"), Declarar.GHOSTZOMBIEEGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTZOMBIEVILLAGER, ZombieVillagerEntity.createZombieAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostzombievillageregg"), Declarar.GHOSTZOMBIEVILLAGEREGG);
        FabricDefaultAttributeRegistry.register(Declarar.GHOSTWITCH, WitchEntity.createWitchAttributes());
        Registry.register(Registry.ITEM, new Identifier("ghostmod", "ghostwitchegg"), Declarar.GHOSTWITCHEGG);
    }

    public static void regItem(String name, Item itemid){
        Registry.register(Registry.ITEM, new Identifier("ghostmod", name), itemid);
    }

}
