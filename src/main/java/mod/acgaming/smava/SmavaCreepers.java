package mod.acgaming.smava;

import mod.acgaming.smava.entity.EntitySmavaCreeper;
import mod.acgaming.smava.render.RenderSmavaCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = "smava", version = "1.1", acceptedMinecraftVersions = "[1.12.2]")
public class SmavaCreepers
{
	public static final String MODID = "smava";
	public static final String VERSION = "1.1";

	public static final SoundEvent ENTITY_SMAVACREEPER_FUSE = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.fuse"));
	public static final SoundEvent ENTITY_SMAVACREEPER_BLOW = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.blow"));
	public static final SoundEvent ENTITY_SMAVACREEPER_HURT = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.hurt"));
	public static final SoundEvent ENTITY_SMAVACREEPER_AMBIENT = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.ambient"));

	@Instance
	public static SmavaCreepers instance;

	@SideOnly(Side.CLIENT)
	@EventHandler
	public void preInitClient(FMLPreInitializationEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySmavaCreeper.class, RenderSmavaCreeper.FACTORY);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}