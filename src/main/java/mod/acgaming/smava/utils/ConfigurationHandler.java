package mod.acgaming.smava.utils;

import net.minecraftforge.common.ForgeConfigSpec;

// Thanks to Girafi!
public class ConfigurationHandler
{
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final Spawn SPAWN = new Spawn(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();

	public static class Spawn
	{
		public final ForgeConfigSpec.IntValue min;
		public final ForgeConfigSpec.IntValue max;
		public final ForgeConfigSpec.IntValue weight;

		Spawn(ForgeConfigSpec.Builder builder)
		{
			builder.push("spawn chances");
			builder.comment("Configure spawn weight & min/max group size. Set weight to 0 to disable.");
			min = builder.defineInRange("min", 1, 0, 64);
			max = builder.defineInRange("max", 1, 0, 64);
			weight = builder.defineInRange("weight", 80, 0, 200);
			builder.pop();
		}
	}
}