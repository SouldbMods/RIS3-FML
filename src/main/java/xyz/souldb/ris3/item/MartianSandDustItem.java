
package xyz.souldb.ris3.item;

import xyz.souldb.ris3.itemgroup.NaturerisItemGroup;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Ris3ModElements.ModElement.Tag
public class MartianSandDustItem extends Ris3ModElements.ModElement {
	@ObjectHolder("ris3:martian_sand_dust")
	public static final Item block = null;
	public MartianSandDustItem(Ris3ModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NaturerisItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("martian_sand_dust");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
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
