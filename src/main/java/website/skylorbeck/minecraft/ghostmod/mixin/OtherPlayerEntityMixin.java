package website.skylorbeck.minecraft.ghostmod.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.ghostmod.Declarar;

@Mixin(OtherClientPlayerEntity.class)
public abstract class OtherPlayerEntityMixin extends AbstractClientPlayerEntity {


    public OtherPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(at = @At("HEAD"), method = "updatePose", cancellable = true)
    public void updateFlyingPose(CallbackInfo ci){
        if (this.getOffHandStack().isOf(Declarar.ghostmode) || this.getMainHandStack().isOf(Declarar.ghostmode)){
                ((setPoseAccessor) this).setPoseInvoker(EntityPose.SWIMMING);
            } else {
                ((setPoseAccessor) this).setPoseInvoker(EntityPose.STANDING);
            }
            ci.cancel();
    }
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    public void injectUpdatePose(CallbackInfo ci){
        this.updatePose();
    }

}
