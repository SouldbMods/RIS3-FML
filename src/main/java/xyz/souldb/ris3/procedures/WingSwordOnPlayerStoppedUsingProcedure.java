package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class WingSwordOnPlayerStoppedUsingProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure WingSwordOnPlayerStoppedUsing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Ris3ModVariables.MapVariables.get(world).wingsword = (boolean) (false);
		Ris3ModVariables.MapVariables.get(world).syncData(world);
	}
}
