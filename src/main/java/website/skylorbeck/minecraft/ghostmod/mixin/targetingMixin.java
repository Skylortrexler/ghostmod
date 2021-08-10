package website.skylorbeck.minecraft.ghostmod.mixin;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.ghostmod.Declarar;
import website.skylorbeck.minecraft.ghostmod.entities.*;

@Mixin(MobEntity.class)
public class targetingMixin {
    @Inject(at = @At("HEAD"), method = "setTarget", cancellable = true)
    public void inject(LivingEntity target, CallbackInfo ci){
        if (target != null && target.isPlayer()){
           PlayerEntity playerEntity = (PlayerEntity) target;
           PlayerInventory inventory = playerEntity.getInventory();
           MobEntity mobEntity = ((MobEntity)(Object)this);
           boolean ghostEntity = mobEntity instanceof GhostCreeperEntity || mobEntity instanceof GhostEndermanEntity || mobEntity instanceof GhostSkeletonEntity || mobEntity instanceof GhostSpiderEntity || mobEntity instanceof GhostWitchEntity || mobEntity instanceof GhostZombieEntity || mobEntity instanceof GhostZombieVillagerEntity;
           if (inventory.contains(Declarar.ghostmode.getDefaultStack())||inventory.contains(Declarar.invisibleghostmode.getDefaultStack())){
               if (!ghostEntity){
                   ci.cancel();
               }
           } else {
               if (ghostEntity){
                   ci.cancel();
               }
           }
       }
    }
}
