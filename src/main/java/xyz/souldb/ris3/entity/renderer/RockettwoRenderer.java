package xyz.souldb.ris3.entity.renderer;

import xyz.souldb.ris3.entity.RockettwoEntity;

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
public class RockettwoRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RockettwoEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrk2(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("ris3:textures/rk2.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelrk2 extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		public Modelrk2() {
			textureWidth = 256;
			textureHeight = 256;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-8.0F, -50.0F, -8.0F, 16.0F, 50.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(20, 238).addBox(-11.0F, -2.0F, 7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 238).addBox(-14.0F, 1.0F, 10.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(120, 228).addBox(-17.0F, 4.0F, 13.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(100, 228).addBox(-11.0F, -2.0F, -11.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(80, 228).addBox(-14.0F, 1.0F, -14.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(60, 228).addBox(-17.0F, 4.0F, -17.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(40, 228).addBox(6.0F, -2.0F, -11.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(20, 228).addBox(9.0F, 1.0F, -14.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 228).addBox(12.0F, 4.0F, -17.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(32, 207).addBox(6.0F, -2.0F, 6.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(32, 197).addBox(9.0F, 1.0F, 9.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(8, 211).addBox(12.0F, 4.0F, 12.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(56, 66).addBox(-7.0F, -51.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 81).addBox(-6.0F, -52.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 105).addBox(-5.0F, -53.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 170).addBox(-4.0F, -54.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(8, 204).addBox(-3.0F, -55.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 121).addBox(-2.0F, -37.0F, 8.0F, 2.0F, 37.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(20, 121).addBox(-2.0F, -35.0F, 11.0F, 2.0F, 35.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 161).addBox(-2.0F, -33.0F, 14.0F, 2.0F, 33.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(20, 161).addBox(-2.0F, -31.0F, 17.0F, 2.0F, 31.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(48, 81).addBox(-2.0F, -37.0F, -11.0F, 2.0F, 37.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(10, 121).addBox(-2.0F, -35.0F, -14.0F, 2.0F, 35.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 121).addBox(-2.0F, -33.0F, -17.0F, 2.0F, 33.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(10, 161).addBox(-2.0F, -31.0F, -20.0F, 2.0F, 31.0F, 3.0F, 0.0F, false);
			bb_main.setTextureOffset(56, 243).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(8, 197).addBox(-3.0F, 1.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 161).addBox(-4.0F, 2.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 94).addBox(-5.0F, 3.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(112, 66).addBox(-6.0F, 4.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 66).addBox(-7.0F, 5.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(64, 0).addBox(-8.0F, 6.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 197).addBox(-1.0F, -85.0F, -1.0F, 2.0F, 29.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(56, 238).addBox(-2.0F, -56.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(40, 238).addBox(-2.0F, -89.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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
