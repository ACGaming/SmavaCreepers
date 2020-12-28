package mod.acgaming.smava.init;

import mod.acgaming.smava.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SmavaTab
{
	public static final ItemGroup SMAVA_TAB = new ItemGroup(Reference.MOD_ID)
	{
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(Blocks.CREEPER_HEAD);
		}
	};
}