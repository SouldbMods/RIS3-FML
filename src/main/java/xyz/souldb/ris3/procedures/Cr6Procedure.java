package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class Cr6Procedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure Cr6!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (Ris3ModVariables.MapVariables.get(world).RocketGUIState > 256);
	}
}
