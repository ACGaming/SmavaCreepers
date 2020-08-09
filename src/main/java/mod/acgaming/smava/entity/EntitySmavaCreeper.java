package mod.acgaming.smava.entity;
import mod.acgaming.smava.init.InitSmavaCreepers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySmavaCreeper extends EntityCreeper
{
	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 20;
	private int explosionRadius = 6;
	  
	public EntitySmavaCreeper(World worldIn)
	{
		super(worldIn);
		setSize(0.6F, 1.7F);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}
	
	public void onUpdate()
	{
		if (this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;
			
			if (this.hasIgnited())
			{
				this.setCreeperState(1);
			}
			
			int i = this.getCreeperState();
			
			if (i > 0 && this.timeSinceIgnited == 0)
			{
				this.playSound(InitSmavaCreepers.ENTITY_SMAVACREEPER_FUSE, 1.0F, 1.0F);
			}
			
			this.timeSinceIgnited += i;
			
			if (this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}
			
			if (this.timeSinceIgnited >= this.fuseTime)
			{
				this.timeSinceIgnited = this.fuseTime;
				this.explode();
			}
		}
		
		super.onUpdate();
	}
	
	private void explode()
    {
        if (!this.world.isRemote)
        {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
            float f = this.getPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.world.playSound(null, getPosition(), InitSmavaCreepers.ENTITY_SMAVACREEPER_BLOW, getSoundCategory(), 5.0F, 1.0F);
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius * f, flag);
            this.setDead();
        }
    }
	
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return InitSmavaCreepers.ENTITY_SMAVACREEPER_HURT;
    }
    
    protected SoundEvent getAmbientSound()
    {
        return InitSmavaCreepers.ENTITY_SMAVACREEPER_AMBIENT;
    }
}