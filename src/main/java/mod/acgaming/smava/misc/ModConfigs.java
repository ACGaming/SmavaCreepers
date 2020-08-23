package mod.acgaming.smava.misc;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = "smava")
@LangKey("smava.config.title")
public class ModConfigs
{
	@Name("Smava Creeper spawn probability:")
	public static int spawn_weight = 50;
	@Name("Smava Creeper min group size:")
	public static int min_size = 1;
	@Name("Smava Creeper max group size:")
	public static int max_size = 4;

	@EventBusSubscriber(modid = "smava")
	private static class EventHandler
	{
		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
		{
			if (event.getModID().equals("smava"))
			{
				ConfigManager.sync("smava", Config.Type.INSTANCE);
			}
		}
	}
}