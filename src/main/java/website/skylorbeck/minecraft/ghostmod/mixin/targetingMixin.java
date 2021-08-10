package website.skylorbeck.minecraft.ghostmod.mixin;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.ghostmod.Declarar;

@Mixin(MobEntity.class)
public class targetingMixin {
    @Inject(at = @At("HEAD"), method = "setTarget", cancellable = true)
    public void inject(LivingEntity target, CallbackInfo ci){
       if (target.isPlayer()){
           PlayerEntity playerEntity = (PlayerEntity) target;
           PlayerInventory inventory = playerEntity.getInventory();
           if (inventory.contains(Declarar.ghostmode.getDefaultStack())||inventory.contains(Declarar.invisibleghostmode.getDefaultStack())){
               ci.cancel();
           }
       }
    }
}
