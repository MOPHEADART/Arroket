package io.github.MOPHEADART.arroket.mixin;

import io.github.MOPHEADART.arroket.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.SaplingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DyeItem.class)
public class BoneMealMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnNylium(ItemStack stack, PlayerEntity entity, World world, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir) {
            if (stack.getDamage()!= 15)
                return;
            int blockId = world.getBlockId(x, y, z);

            if (blockId == BlockListener.CRIMSON_NYLIUM.id) {
                if (tryGrowFungus(world, x, y+1, z, BlockListener.CRIMSON_FUNGI)) {
                    consumeBoneMeal(world, entity, stack, x, y, z);
                    cir.setReturnValue(true);
                    cir.cancel();
                }
            } else if (blockId == BlockListener.WARPED_NYLIUM.id) {
                if (tryGrowFungus(world, x, y+1, z, BlockListener.WARPED_FUNGI)) {
                    consumeBoneMeal(world, entity, stack, x, y, z);
                    cir.setReturnValue(true);
                    cir.cancel();
                }
            }
    }
    @Unique
    private boolean tryGrowFungus(World world, int x, int y, int z, Block NyliumFungi) {
        if (world.isAir(x, y, z)) {
            world.setBlock(x, y, z, NyliumFungi.id);
            return true;
        }
        return false;
    }

    @Unique
    private void consumeBoneMeal(World world, PlayerEntity player, ItemStack stack, int x, int y, int z) {
        stack.count--;

        Random random = world.random;
        for (int i = 0; i < 8; i++) {
            double px = x + random.nextDouble();
            double py = y + 1.0D + random.nextDouble() * 0.3D;
            double pz = z + random.nextDouble();
        }
    }
}
