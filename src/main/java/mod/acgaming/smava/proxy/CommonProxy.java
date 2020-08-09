package mod.acgaming.smava.proxy;
import mod.acgaming.smava.SmavaCreepers;
import mod.acgaming.smava.config.ConfigHandler;
import mod.acgaming.smava.entity.EntitySmavaCreeper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigHandler.INSTANCE.loadConfig(e);
		EntityRegistry.registerModEntity(new ResourceLocation("smava:smava_creeper"), EntitySmavaCreeper.class, "smava_creeper", 1, SmavaCreepers.instance, 64, 1, true, 7649828, 11053224);
		MinecraftForge.EVENT_BUS.register(new Events());
	}
	
	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		SmavaCreepers.ENTITY_SMAVACREEPER_FUSE.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.fuse"));
		event.getRegistry().register((SoundEvent)SmavaCreepers.ENTITY_SMAVACREEPER_FUSE);
		SmavaCreepers.ENTITY_SMAVACREEPER_BLOW.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.blow"));
		event.getRegistry().register((SoundEvent)SmavaCreepers.ENTITY_SMAVACREEPER_BLOW);
		SmavaCreepers.ENTITY_SMAVACREEPER_HURT.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.hurt"));
		event.getRegistry().register((SoundEvent)SmavaCreepers.ENTITY_SMAVACREEPER_HURT);
		SmavaCreepers.ENTITY_SMAVACREEPER_AMBIENT.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.ambient"));
		event.getRegistry().register((SoundEvent)SmavaCreepers.ENTITY_SMAVACREEPER_AMBIENT);
	}
	
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(ConfigHandler.INSTANCE);
		EntityRegistry.addSpawn(EntitySmavaCreeper.class, ConfigHandler.SMAVA_CREEPER_SPAWN_CHANCE, ConfigHandler.SMAVA_CREEPER_MIN_SPAWN_SIZE, ConfigHandler.SMAVA_CREEPER_MAX_SPAWN_SIZE, EnumCreatureType.MONSTER, (Biome[])ForgeRegistries.BIOMES.getValuesCollection().toArray((Object[])new Biome[0]));
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
	public class Events
	{
		
	}
}