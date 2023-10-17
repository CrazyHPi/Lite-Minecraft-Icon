package xyz.crazyh.liteminecrafticon.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import xyz.crazyh.liteminecrafticon.IconStorage;

import java.io.InputStream;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    @ModifyArg(
            method = "setWindowIcon",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Minecraft;readImageToBuffer(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;",
                    ordinal = 0
            )
    )
    private InputStream get16xIcon(InputStream imageStream) {
        return IconStorage.getResource("icon_16x16.png");
    }
    @ModifyArg(
            method = "setWindowIcon",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Minecraft;readImageToBuffer(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;",
                    ordinal = 1
            )
    )
    private InputStream get32xIcon(InputStream imageStream) {
        return IconStorage.getResource("icon_32x32.png");
    }
}
