package xyz.souldb.ris3.procedures;

import xyz.souldb.ris3.Ris3ModElements;

import java.util.Map;

@Ris3ModElements.ModElement.Tag
public class SmokeLakesGenConditionProcedure extends Ris3ModElements.ModElement {
	public SmokeLakesGenConditionProcedure(Ris3ModElements instance) {
		super(instance, 253);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return (true);
	}
}
