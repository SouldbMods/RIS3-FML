package xyz.souldb.ris3.entity.renderer;

import xyz.souldb.ris3.entity.RocketoneEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RocketoneRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RocketoneEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrk(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("ris3:textures/rk.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelrk extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bb_main;
		public Modelrk() {
			textureWidth = 192;
			textureHeight = 192;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(8.0F, 37.0F, -7.0F);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(6.0F, -1.0F, -10.0F);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-8.0F, -50.0F, -8.0F, 16.0F, 50.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(56, 66).addBox(-7.0F, -51.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(112, 66).addBox(-6.0F, -52.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(96, 85).addBox(-5.0F, -53.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(88, 109).addBox(-4.0F, -54.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(72, 158).addBox(-3.0F, -55.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(16, 169).addBox(-2.0F, -56.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(96, 147).addBox(-1.0F, -76.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 169).addBox(-2.0F, -80.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(68, 85).addBox(8.0F, -37.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(40, 85).addBox(-10.0F, -37.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(60, 109).addBox(-6.0F, -37.0F, 8.0F, 12.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(32, 109).addBox(-6.0F, -37.0F, -10.0F, 12.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(48, 147).addBox(-12.0F, -2.0F, 6.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 147).addBox(-12.0F, -2.0F, -12.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 147).addBox(6.0F, -2.0F, -12.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(120, 135).addBox(6.0F, -2.0F, 6.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(96, 135).addBox(-16.0F, 2.0F, 10.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(72, 135).addBox(-16.0F, 2.0F, -16.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(48, 135).addBox(10.0F, 2.0F, -16.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 135).addBox(10.0F, 2.0F, 10.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 135).addBox(14.0F, 6.0F, 14.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(120, 123).addBox(-20.0F, 6.0F, 14.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(96, 123).addBox(-20.0F, 6.0F, -20.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(72, 123).addBox(14.0F, 6.0F, -20.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(48, 123).addBox(18.0F, 10.0F, 18.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 123).addBox(-23.0F, 10.0F, 18.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 123).addBox(-23.0F, 10.0F, -23.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(120, 109).addBox(17.0F, 10.0F, -23.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(72, 147).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 109).addBox(-4.0F, 2.0F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 85).addBox(-5.0F, 4.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 66).addBox(-7.0F, 6.0F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(64, 0).addBox(-8.0F, 8.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
