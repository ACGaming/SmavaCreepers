package mod.acgaming.smava;
import mod.acgaming.smava.proxy.CommonProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "smava", version = "1.0", guiFactory = "mod.acgaming.smava.config.ConfigGUIFactory", acceptedMinecraftVersions = "[1.12.2]")
public class SmavaCreepers
{
	public static final String MODID = "smava";
	public static final String VERSION = "1.0";
	
	public static final SoundEvent ENTITY_SMAVACREEPER_FUSE = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.fuse"));
	public static final SoundEvent ENTITY_SMAVACREEPER_BLOW = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.blow"));
	public static final SoundEvent ENTITY_SMAVACREEPER_HURT = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.hurt"));
	public static final SoundEvent ENTITY_SMAVACREEPER_AMBIENT = new SoundEvent(new ResourceLocation("smava:entities.smava_creeper.ambient"));
	
	@SidedProxy(clientSide = "mod.acgaming.smava.proxy.ClientProxy", serverSide = "mod.acgaming.smava.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static SmavaCreepers instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
}