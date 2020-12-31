package mod.acgaming.smava;

import mod.acgaming.smava.client.ClientHandler;
import mod.acgaming.smava.init.SmavaEntities;
import mod.acgaming.smava.init.SmavaRegistry;
import mod.acgaming.smava.utils.ConfigurationHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class SmavaCreepers
{
	public SmavaCreepers()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
		eventBus.register(ConfigurationHandler.class);

		eventBus.addListener(this::setup);

		SmavaRegistry.ITEMS.register(eventBus);
		SmavaRegistry.ENTITIES.register(eventBus);
		SmavaRegistry.SOUND_EVENTS.register(eventBus);

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () ->
		{
			eventBus.addListener(ClientHandler::doClientStuff);
			eventBus.addListener(ClientHandler::registerItemColors);
		});
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		SmavaEntities.initializeEntities();
	}
}