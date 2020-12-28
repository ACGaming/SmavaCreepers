package mod.acgaming.smava.client;

import mod.acgaming.smava.client.renderer.SmavaCreeperRenderer;
import mod.acgaming.smava.init.SmavaRegistry;
import mod.acgaming.smava.items.CustomSpawnEggItem;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler
{
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(SmavaRegistry.SMAVA_CREEPER.get(), SmavaCreeperRenderer::new);
	}

	public static void registerItemColors(final ColorHandlerEvent.Item event)
	{
		ItemColors colors = event.getItemColors();

		for (CustomSpawnEggItem item : CustomSpawnEggItem.getEggs())
		{
			colors.register((p_198141_1_, p_198141_2_) -> item.getColor(p_198141_2_), item);
		}
	}
}