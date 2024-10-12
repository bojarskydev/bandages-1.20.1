package net.bojarsky.bandages.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class ItemBandage extends Item {
    private static final int COOLDOWN_TICKS = 300;

    public ItemBandage() {
        super(new Item.Properties());
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 4;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (player.getHealth() >= player.getMaxHealth()) {
            return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
        }

        if (!player.getCooldowns().isOnCooldown(this)) {
            player.startUsingItem(hand);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
        }

        return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
    }

    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level world, @Nonnull LivingEntity entityLiving) {
        if (entityLiving instanceof Player player) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(3.0F);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 150, 0));
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);

                player.playSound(SoundEvents.WOOL_BREAK, 1.0F, 1.0F);
            }
        }

        stack.shrink(1);
        return stack;
    }
}
