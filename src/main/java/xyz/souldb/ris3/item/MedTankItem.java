
package xyz.souldb.ris3.item;

import xyz.souldb.ris3.itemgroup.RisRocketsItemGroup;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Ris3ModElements.ModElement.Tag
public class MedTankItem extends Ris3ModElements.ModElement {
	@ObjectHolder("ris3:med_tank")
	public static final Item block = null;
	public MedTankItem(Ris3ModElements instance) {
		super(instance, 172);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RisRocketsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("med_tank");
		}

		@Override
		public int getItemEnchantability() {
			return 2;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
