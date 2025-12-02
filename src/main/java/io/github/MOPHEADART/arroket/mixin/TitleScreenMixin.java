package io.github.MOPHEADART.arroket.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Shadow private String splashText;

    @Inject(method = "init", at = @At("TAIL"))
    void configureSplashText(CallbackInfo ci) {
        splashText = "Arroket";
    }
}