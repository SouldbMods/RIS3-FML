
package xyz.souldb.ris3.itemgroup;

import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Ris3ModElements.ModElement.Tag
public class RisenergyItemGroup extends Ris3ModElements.ModElement {
	public RisenergyItemGroup(Ris3ModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabrisenergy") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.REPEATER, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
