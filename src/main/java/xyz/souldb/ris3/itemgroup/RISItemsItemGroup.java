
package xyz.souldb.ris3.itemgroup;

import xyz.souldb.ris3.item.MartianSandDustItem;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Ris3ModElements.ModElement.Tag
public class RISItemsItemGroup extends Ris3ModElements.ModElement {
	public RISItemsItemGroup(Ris3ModElements instance) {
		super(instance, 112);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabris_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MartianSandDustItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
