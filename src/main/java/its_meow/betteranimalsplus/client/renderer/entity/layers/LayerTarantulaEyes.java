package its_meow.betteranimalsplus.client.renderer.entity.layers;

import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantula;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerTarantulaEyes implements LayerRenderer<EntityTarantula> {

    private final RenderTarantula tarantulaRenderer;

    public LayerTarantulaEyes(RenderTarantula rendererIn) {
        this.tarantulaRenderer = rendererIn;
    }

    @Override
    public void render(EntityTarantula entity, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!entity.isInvisible() && !entity.isChild()) {
            this.tarantulaRenderer.bindTexture(ModTextures.tarantula_eyes);

            GlStateManager.enableBlend();
            GlStateManager.disableAlphaTest();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

            if (entity.isInvisible()) {
                GlStateManager.depthMask(false);
            } else {
                GlStateManager.depthMask(true);
            }

            int i = 61680;
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.glMultiTexCoord2f(OpenGlHelper.GL_TEXTURE1, j, k);
            Minecraft.getInstance().gameRenderer.setupFogColor(true);
            this.tarantulaRenderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
                    headPitch, scale);
            Minecraft.getInstance().gameRenderer.setupFogColor(false);
            i = entity.getBrightnessForRender();
            j = i % 65536;
            k = i / 65536;
            OpenGlHelper.glMultiTexCoord2f(OpenGlHelper.GL_TEXTURE1, j, k);
            this.tarantulaRenderer.setLightmap(entity);
            GlStateManager.disableBlend();
            GlStateManager.enableAlphaTest();

        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}