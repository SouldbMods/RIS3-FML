package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class WingedSwordFlightTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Ris3Mod.LOGGER.warn("Failed to load dependency entity for procedure WingedSwordFlightTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Ris3Mod.LOGGER.warn("Failed to load dependency x for procedure WingedSwordFlightTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Ris3Mod.LOGGER.warn("Failed to load dependency y for procedure WingedSwordFlightTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Ris3Mod.LOGGER.warn("Failed to load dependency z for procedure WingedSwordFlightTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure WingedSwordFlightTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		Ris3ModVariables.MapVariables.get(world).wingsword = (boolean) (true);
		Ris3ModVariables.MapVariables.get(world).syncData(world);
		if ((Ris3ModVariables.MapVariables.get(world).wingsword == (true))) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.setFlySpeed((float) 1F);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof PlayerEntity) {
				((PlayerEntity) ((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).abilities.allowFlying = ((entity
								.getCapability(Ris3ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Ris3ModVariables.PlayerVariables())).fly_state);
				((PlayerEntity) ((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).sendPlayerAbilities();
			}
		}
	}
}
