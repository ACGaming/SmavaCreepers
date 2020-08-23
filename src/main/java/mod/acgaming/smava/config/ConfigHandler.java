package mod.acgaming.smava.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {
    public static final ConfigHandler INSTANCE = new ConfigHandler();
    public Configuration config;
    public static int SMAVA_CREEPER_MIN_SPAWN_SIZE;
    public static int SMAVA_CREEPER_MAX_SPAWN_SIZE;
    public static int SMAVA_CREEPER_SPAWN_CHANCE;
    public final String[] usedCategories = new String[] { "Smava Creepers settings" };

    public void loadConfig(FMLPreInitializationEvent event) {
	this.config = new Configuration(event.getSuggestedConfigurationFile());
	this.config.load();
	syncConfigs();
    }

    private void syncConfigs() {
	SMAVA_CREEPER_MIN_SPAWN_SIZE = this.config.get("Smava Creepers settings", "Minimum size per spawn group", 1)
		.getInt(1);
	SMAVA_CREEPER_MAX_SPAWN_SIZE = this.config.get("Smava Creepers settings", "Maximum size per spawn group", 4)
		.getInt(4);
	SMAVA_CREEPER_SPAWN_CHANCE = this.config.get("Smava Creepers settings", "Spawn chance", 10).getInt(10);

	if (this.config.hasChanged())
	    this.config.save();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
	if (event.getModID().equals("smava"))
	    syncConfigs();
    }
}