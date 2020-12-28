package mod.acgaming.smava.init;

import mod.acgaming.smava.Reference;
import mod.acgaming.smava.entity.SmavaCreeperEntity;
import mod.acgaming.smava.utils.ConfigurationHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class SmavaEntities
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addSpawn(BiomeLoadingEvent event)
	{
		Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
		if (biome != null)
		{
			MobSpawnInfo info = biome.getMobSpawnInfo();
			List<MobSpawnInfo.Spawners> spawns = event.getSpawns().getSpawner(EntityClassification.MONSTER);
			for (Spawners entry : info.getSpawners(EntityClassification.MONSTER))
			{
				registerSpawn(spawns, entry, EntityType.CREEPER, SmavaRegistry.SMAVA_CREEPER.get());
			}
		}
	}

	public static void initializeEntities()
	{
		EntitySpawnPlacementRegistry.register(SmavaRegistry.SMAVA_CREEPER.get(), PlacementType.ON_GROUND, Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
		GlobalEntityTypeAttributes.put(SmavaRegistry.SMAVA_CREEPER.get(), SmavaCreeperEntity.registerAttributes().create());
	}

	public static void registerSpawn(List<Spawners> spawns, Spawners entry, EntityType<? extends LivingEntity> oldEntity, EntityType<? extends LivingEntity> newEntity)
	{
		if (entry.type == oldEntity)
		{
			spawns.add(new MobSpawnInfo.Spawners(newEntity, ConfigurationHandler.SPAWN.weight.get(), ConfigurationHandler.SPAWN.min.get(), ConfigurationHandler.SPAWN.max.get()));
		}
	}
}