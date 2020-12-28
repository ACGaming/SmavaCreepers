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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MOD_ID)
public class SmavaCreepers
{
	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public SmavaCreepers()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		eventBus.addListener(this::setup);

		SmavaRegistry.ITEMS.register(eventBus);
		SmavaRegistry.ENTITIES.register(eventBus);
		SmavaRegistry.SOUND_EVENTS.register(eventBus);

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () ->
		{
			eventBus.addListener(ClientHandler::doClientStuff);
			eventBus.addListener(ClientHandler::registerItemColors);
		});

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		SmavaEntities.initializeEntities();
	}
}