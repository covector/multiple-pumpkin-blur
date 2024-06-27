package dev.covector.multiplepumpkinblur.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Mixin(InGameHud.class)
public abstract class PumpkinBlurMixin {
    @Shadow
    private MinecraftClient client;

    @ModifyArg(method = "render(Lnet/minecraft/client/gui/DrawContext;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderOverlay(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/util/Identifier;F)V", ordinal = 0), index = 1)
    private Identifier injectAlternateOverlays(Identifier ti) {
        ItemStack helmet = this.client.player.getInventory().getArmorStack(3);
        if (helmet.hasNbt() && helmet.getNbt().contains("AltBlur")) {
            int customModelData = helmet.getNbt().getInt("AltBlur");
            return new Identifier(String.format("textures/misc/pumpkinblur%d.png", customModelData));
        }
        return ti;
    }
}
