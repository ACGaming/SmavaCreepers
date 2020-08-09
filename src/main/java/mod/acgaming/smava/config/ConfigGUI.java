package mod.acgaming.smava.config;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGUI extends GuiConfig
{
	public ConfigGUI(GuiScreen parent)
	{
		super(parent, getElements(), "smava", "smava", false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.INSTANCE.config.toString()));
	}
	
	private static List<IConfigElement> getElements()
	{
		List<IConfigElement> list = new ArrayList<>();
		for (String category : ConfigHandler.INSTANCE.usedCategories)
		list.add(new ConfigElement(ConfigHandler.INSTANCE.config.getCategory(category.toLowerCase()))); 
		return list;
	}
}