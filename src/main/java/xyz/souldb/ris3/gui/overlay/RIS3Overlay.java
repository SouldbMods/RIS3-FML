
package xyz.souldb.ris3.gui.overlay;

import xyz.souldb.ris3.procedures.Cr10Procedure;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@Ris3ModElements.ModElement.Tag
public class RIS3Overlay extends Ris3ModElements.ModElement {
	public RIS3Overlay(Ris3ModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (Cr10Procedure.executeProcedure(ImmutableMap.of("world", world))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "You are Really In Space!", posX + -60, posY + -115, -65536);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/earth.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -139, posY + -99, 0, 0, 16, 16, 16, 16);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mars.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -181, posY + -52, 0, 0, 16, 16, 16, 16);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -35, posY + -68, 0, 0, 16, 16, 16, 16);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/sun.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 17, posY + -42, 0, 0, 16, 16, 16, 16);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/venus.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 86, posY + -81, 0, 0, 16, 16, 16, 16);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Really In Space 3.0 By Souldbminer", posX + -80, posY + -102,
						-16776961);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
