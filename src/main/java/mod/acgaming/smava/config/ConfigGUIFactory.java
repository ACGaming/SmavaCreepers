package mod.acgaming.smava.config;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public class ConfigGUIFactory implements IModGuiFactory
{
	public void initialize(Minecraft minecraftInstance) {}
	
	public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories()
	{
		return null;
	}
	
	public boolean hasConfigGui()
	{
		return true;
	}
	
	public GuiScreen createConfigGui(GuiScreen parentScreen)
	{
		return (GuiScreen)new ConfigGUI(parentScreen);
	}
}