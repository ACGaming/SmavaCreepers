package mod.acgaming.smava.proxy;
import mod.acgaming.smava.entity.EntitySmavaCreeper;
import mod.acgaming.smava.render.RenderSmavaCreeper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntitySmavaCreeper.class, RenderSmavaCreeper::new);
	}
	
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}