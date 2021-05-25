package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.entity.Entity;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class Cd2cProcedure extends Ris3ModElements.ModElement {
	public Cd2cProcedure(Ris3ModElements instance) {
		super(instance, 233);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Ris3Mod.LOGGER.warn("Failed to load dependency entity for procedure Cd2c!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(Ris3ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Ris3ModVariables.PlayerVariables())).countdown) == 9);
	}
}
