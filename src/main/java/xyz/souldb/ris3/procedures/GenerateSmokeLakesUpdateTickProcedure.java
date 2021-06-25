package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.world.GenerateSmokeLakesGameRule;
import xyz.souldb.ris3.Ris3ModVariables;
import xyz.souldb.ris3.Ris3Mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

public class GenerateSmokeLakesUpdateTickProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Ris3Mod.LOGGER.warn("Failed to load dependency world for procedure GenerateSmokeLakesUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(GenerateSmokeLakesGameRule.gamerule)) == (true))) {
			Ris3ModVariables.MapVariables.get(world).SmokeLakesGen = (boolean) (true);
			Ris3ModVariables.MapVariables.get(world).syncData(world);
		} else {
			Ris3ModVariables.MapVariables.get(world).SmokeLakesGen = (boolean) (false);
			Ris3ModVariables.MapVariables.get(world).syncData(world);
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				SmokeLakesGenConditionProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
