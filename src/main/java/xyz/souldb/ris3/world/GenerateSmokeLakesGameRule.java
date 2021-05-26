package xyz.souldb.ris3.world;

import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import java.lang.reflect.Method;

@Ris3ModElements.ModElement.Tag
public class GenerateSmokeLakesGameRule extends Ris3ModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("generateSmokeLakes", GameRules.Category.MISC,
			create(false));
	public GenerateSmokeLakesGameRule(Ris3ModElements instance) {
		super(instance, 251);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
