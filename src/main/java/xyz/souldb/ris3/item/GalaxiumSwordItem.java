
package xyz.souldb.ris3.item;

import xyz.souldb.ris3.itemgroup.RISCombatItemGroup;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Ris3ModElements.ModElement.Tag
public class GalaxiumSwordItem extends Ris3ModElements.ModElement {
	@ObjectHolder("ris3:galaxium_sword")
	public static final Item block = null;
	public GalaxiumSwordItem(Ris3ModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GalaxiumDustItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(RISCombatItemGroup.tab)) {
		}.setRegistryName("galaxium_sword"));
	}
}
