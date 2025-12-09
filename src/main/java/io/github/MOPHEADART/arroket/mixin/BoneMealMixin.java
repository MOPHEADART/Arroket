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
        boolean grewFungus = false;
        boolean grewNylium = false;

        int originalNylium = world.getBlockId(x, y, z);

        for (int i = 0; i < 128; ++i) {

            int fx = x + random.nextInt(7) - 3;
            int fy = y + 1;
            int fz = z + random.nextInt(7) - 3;

            int blockBelow = world.getBlockId(fx, fy - 1, fz);

            if (blockBelow != originalNylium && blockBelow != Block.NETHERRACK.id)
                continue;

            if (!world.isAir(fx, fy, fz))
                continue;

            if (blockBelow == Block.NETHERRACK.id) {
                world.setBlock(fx, fy - 1, fz, nyliumId);
            }

            if (random.nextInt(3) != 0) {
                world.setBlock(fx, fy, fz, fungi.id);
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
