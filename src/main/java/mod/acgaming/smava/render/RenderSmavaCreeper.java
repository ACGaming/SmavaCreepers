package mod.acgaming.smava.render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerCreeperCharge;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;

public class RenderSmavaCreeper extends RenderCreeper
{
    private static final ResourceLocation SMAVA_CREEPER_TEXTURE = new ResourceLocation("smava:textures/entities/smava_creeper.png");

    public RenderSmavaCreeper(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.addLayer(new LayerCreeperCharge(this));
    }
    
    protected ResourceLocation getEntityTexture(EntityCreeper entity)
    {
        return SMAVA_CREEPER_TEXTURE;
    }
}