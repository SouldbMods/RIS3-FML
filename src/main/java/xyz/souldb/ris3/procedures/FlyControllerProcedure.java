package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3ModElements;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@Ris3ModElements.ModElement.Tag
public class FlyControllerProcedure extends Ris3ModElements.ModElement {
	public FlyControllerProcedure(Ris3ModElements instance) {
		super(instance, 178);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Ris3Mod.LOGGER.warn("Failed to load dependency entity for procedure FlyController!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Ris3ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Ris3ModVariables.PlayerVariables())).fly_state) == (true))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FlyOnProcedure.executeProcedure($_dependencies);
			}
		} else {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FlyOffProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
