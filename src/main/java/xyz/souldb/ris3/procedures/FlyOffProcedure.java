package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class FlyOffProcedure extends Ris3ModElements.ModElement {
	public FlyOffProcedure(Ris3ModElements instance) {
		super(instance, 177);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Ris3Mod.LOGGER.warn("Failed to load dependency entity for procedure FlyOff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).stopFallFlying();
		}
	}
}
