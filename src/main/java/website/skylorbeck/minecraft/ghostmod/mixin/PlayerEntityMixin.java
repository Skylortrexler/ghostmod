package website.skylorbeck.minecraft.ghostmod.mixin;

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

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow @Final private PlayerInventory inventory;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow @Final private PlayerAbilities abilities;

    @Inject(at = @At("HEAD"), method = "updatePose", cancellable = true)
    public void updateFlyingPose(CallbackInfo ci){
            if (this.inventory.contains(Declarar.ghostmode.getDefaultStack())){
                if (this.forwardSpeed>=0.25 || this.sidewaysSpeed >=0.25 || this.sidewaysSpeed <=-0.25) {
                    ((setPoseAccessor) this).setPoseInvoker(EntityPose.FALL_FLYING);
                    ci.cancel();
                }
            }
    }
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSpectator()Z"), method = "tick")
    public boolean injectedTick(PlayerEntity playerEntity){
        if (this.inventory.contains(Declarar.ghostmode.getDefaultStack())){
            this.abilities.flying = true;
            this.abilities.allowFlying = true;
            this.abilities.setFlySpeed(0.2f);
            return true;
        }
        this.abilities.flying = false;
        this.abilities.allowFlying = false;
        return false;
    }
    @Inject(at = @At("HEAD"), method = "attack", cancellable = true)
    public void injectedAttack(Entity target, CallbackInfo ci){
        if (!this.getStackInHand(Hand.MAIN_HAND).hasEnchantments() && target.isPlayer()){
            ci.cancel();
        }
    }
    @Inject(at = @At("HEAD"), method = "damage", cancellable = true)
    public void injectedDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if (source.getSource()!=null && source.getSource().isPlayer()) {
            if (!source.getSource().getItemsHand().iterator().next().hasEnchantments() && !source.isMagic()) {
                cir.cancel();
            }
        }
    }
}
