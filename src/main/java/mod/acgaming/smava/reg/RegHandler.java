package mod.acgaming.smava.reg;

import mod.acgaming.smava.SmavaCreepers;
import mod.acgaming.smava.config.ConfigHandler;
import mod.acgaming.smava.entity.EntitySmavaCreeper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber(modid = SmavaCreepers.MODID)
public class RegHandler {
    @SubscribeEvent
    public static void registerEntities(Register<EntityEntry> event) {
	EntityRegistry.registerModEntity(new ResourceLocation("smava:smava_creeper"), EntitySmavaCreeper.class,
		"smava_creeper", 1, SmavaCreepers.instance, 64, 1, true, 7649828, 11053224);
	EntityRegistry.addSpawn(EntitySmavaCreeper.class, ConfigHandler.SMAVA_CREEPER_SPAWN_CHANCE,
		ConfigHandler.SMAVA_CREEPER_MIN_SPAWN_SIZE, ConfigHandler.SMAVA_CREEPER_MAX_SPAWN_SIZE,
		EnumCreatureType.MONSTER,
		(Biome[]) ForgeRegistries.BIOMES.getValuesCollection().toArray((Object[]) new Biome[0]));
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
	SmavaCreepers.ENTITY_SMAVACREEPER_FUSE
		.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.fuse"));
	event.getRegistry().register(SmavaCreepers.ENTITY_SMAVACREEPER_FUSE);
	SmavaCreepers.ENTITY_SMAVACREEPER_BLOW
		.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.blow"));
	event.getRegistry().register(SmavaCreepers.ENTITY_SMAVACREEPER_BLOW);
	SmavaCreepers.ENTITY_SMAVACREEPER_HURT
		.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.hurt"));
	event.getRegistry().register(SmavaCreepers.ENTITY_SMAVACREEPER_HURT);
	SmavaCreepers.ENTITY_SMAVACREEPER_AMBIENT
		.setRegistryName(new ResourceLocation("smava:entities.smava_creeper.ambient"));
	event.getRegistry().register(SmavaCreepers.ENTITY_SMAVACREEPER_AMBIENT);
    }
}