package io.github.MOPHEADART.arroket.mixin;

import io.github.MOPHEADART.arroket.events.init.BlockListener;
import net.minecraft.block.Block;
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
                if (tryGrow(world, x, y, z, BlockListener.CRIMSON_FUNGI, blockId)) {
                    consumeBoneMeal(stack);
                    cir.setReturnValue(true);
                    cir.cancel();
                }
            } else if (blockId == BlockListener.WARPED_NYLIUM.id) {
                if (tryGrow(world, x, y, z, BlockListener.WARPED_FUNGI, blockId)) {
                    consumeBoneMeal(stack);
                    cir.setReturnValue(true);
                    cir.cancel();
                }
            }
    }
    @Unique
    private boolean tryGrow(World world, int x, int y, int z, Block fungi, int nyliumId) {
        Random random = world.random;

        int originalNylium = world.getBlockId(x, y, z);

        for (int i = 0; i < 128; ++i) {

            int fx = x + random.nextInt(7) - 3;
            int fy = y + 1;
            int fz = z + random.nextInt(7) - 3;

            if (world.getBlockId(fx, fy - 1, fz) != originalNylium)
                continue;

            if (!world.isAir(fx, fy, fz))
                continue;

            if (random.nextInt(2) != 0) {
                world.setBlock(fx, fy, fz, fungi.id);
            }

            int radius = 3;
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int nx = x + dx;
                        int ny = y + dy;
                        int nz = z + dz;


                        if (world.getBlockId(nx, ny, nz) != Block.NETHERRACK.id)
                            continue;

                        if (!world.isAir(nx, ny + 1, nz))
                            continue;

                        if (random.nextInt(2) == 0) {
                            world.setBlock(nx, ny, nz, nyliumId);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }


    @Unique
    private void consumeBoneMeal(ItemStack stack) {
        stack.count--;
    }
}
