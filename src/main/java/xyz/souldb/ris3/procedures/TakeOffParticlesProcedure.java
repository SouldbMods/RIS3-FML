package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class TakeOffParticlesProcedure extends Ris3ModElements.ModElement {
	public TakeOffParticlesProcedure(Ris3ModElements instance) {
		super(instance, 216);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Ris3Mod.LOGGER.warn("Failed to load dependency x for procedure TakeOffParticles!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Ris3Mod.LOGGER.warn("Failed to load dependency y for procedure TakeOffParticles!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Ris3Mod.LOGGER.warn("Failed to load dependency z for procedure TakeOffParticles!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure TakeOffParticles!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (1200); index0++) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, (y - 2), z, (int) 2, 3, 3, 3, 0.1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 2), z, (int) 2, 3, 3, 3, 0.1);
			}
		}
	}
}
