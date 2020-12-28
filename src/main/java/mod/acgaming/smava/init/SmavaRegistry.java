package mod.acgaming.smava.init;

import mod.acgaming.smava.Reference;
import mod.acgaming.smava.entity.SmavaCreeperEntity;
import mod.acgaming.smava.items.CustomSpawnEggItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SmavaRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

	// ENTITIES
	public static final RegistryObject<EntityType<SmavaCreeperEntity>> SMAVA_CREEPER = ENTITIES.register("smava_creeper",
			() -> register("smava_creeper", EntityType.Builder.create(SmavaCreeperEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8)));

	// ITEMS
	public static final RegistryObject<Item> SMAVA_CREEPER_SPAWN_EGG = ITEMS.register("smava_creeper_spawn_egg", () -> new CustomSpawnEggItem(SmavaRegistry.SMAVA_CREEPER::get, 7649828, 11053224, itemBuilder()));

	// SOUND EVENTS
	public static final RegistryObject<SoundEvent> ENTITY_SMAVA_CREEPER_FUSE = SOUND_EVENTS.register("smava_creeper.fuse", () -> createSound("smava_creeper.fuse"));
	public static final RegistryObject<SoundEvent> ENTITY_SMAVA_CREEPER_BLOW = SOUND_EVENTS.register("smava_creeper.blow", () -> createSound("smava_creeper.blow"));
	public static final RegistryObject<SoundEvent> ENTITY_SMAVA_CREEPER_HURT = SOUND_EVENTS.register("smava_creeper.hurt", () -> createSound("smava_creeper.hurt"));
	public static final RegistryObject<SoundEvent> ENTITY_SMAVA_CREEPER_AMBIENT = SOUND_EVENTS.register("smava_creeper.ambient", () -> createSound("smava_creeper.ambient"));

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates)
	{
		return builder.setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(id);
	}

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder)
	{
		return register(id, builder, true);
	}

	private static SoundEvent createSound(String name)
	{
		ResourceLocation resourceLocation = new ResourceLocation(Reference.MOD_ID, name);
		return new SoundEvent(resourceLocation);
	}

	private static Item.Properties itemBuilder()
	{
		return new Item.Properties().group(SmavaTab.SMAVA_TAB);
	}
}