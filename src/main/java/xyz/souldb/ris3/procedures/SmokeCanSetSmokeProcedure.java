package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.block.SmokeBlock;
import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class SmokeCanSetSmokeProcedure extends Ris3ModElements.ModElement {
	public SmokeCanSetSmokeProcedure(Ris3ModElements instance) {
		super(instance, 254);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Ris3Mod.LOGGER.warn("Failed to load dependency x for procedure SmokeCanSetSmoke!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Ris3Mod.LOGGER.warn("Failed to load dependency y for procedure SmokeCanSetSmoke!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Ris3Mod.LOGGER.warn("Failed to load dependency z for procedure SmokeCanSetSmoke!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure SmokeCanSetSmoke!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SmokeBlock.block.getDefaultState(), 3);
	}
}
