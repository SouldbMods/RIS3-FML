package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.world.IWorld;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class CheckRocket1Procedure extends Ris3ModElements.ModElement {
	public CheckRocket1Procedure(Ris3ModElements instance) {
		super(instance, 96);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure CheckRocket1!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return ((Ris3ModVariables.MapVariables.get(world).RocketGUIState) < 64);
	}
}
