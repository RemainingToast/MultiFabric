package io.multifabric.mixin;

import io.multifabric.MultiFabric;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftDedicatedServer.class)
public class MinecraftDedicatedServerMixin {
	@Inject(at = @At("TAIL"), method = "setupServer")
	private void setupServer(CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue()) {
			MultiFabric.LOGGER.info("MultiFabric started successfully!");
		} else {
			MultiFabric.LOGGER.error("MultiFabric failed to 'setupServer'!");
		}
	}
}
