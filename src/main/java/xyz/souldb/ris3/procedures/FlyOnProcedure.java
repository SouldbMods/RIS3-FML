package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class FlyOnProcedure extends Ris3ModElements.ModElement {
	public FlyOnProcedure(Ris3ModElements instance) {
		super(instance, 176);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Ris3Mod.LOGGER.warn("Failed to load dependency entity for procedure FlyOn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).startFallFlying();
		}
	}
}
