
package xyz.souldb.ris3.item;

import xyz.souldb.ris3.itemgroup.RISItemsItemGroup;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

@Ris3ModElements.ModElement.Tag
public class CoreOfFlightItem extends Ris3ModElements.ModElement {
	@ObjectHolder("ris3:core_of_flight")
	public static final Item block = null;
	public CoreOfFlightItem(Ris3ModElements instance) {
		super(instance, 176);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RISItemsItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("core_of_flight");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("I belive I can fly!"));
		}
	}
}
