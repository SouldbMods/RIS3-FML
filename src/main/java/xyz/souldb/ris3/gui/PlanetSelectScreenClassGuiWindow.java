
package xyz.souldb.ris3.gui;

import xyz.souldb.ris3.Ris3Mod;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PlanetSelectScreenClassGuiWindow extends ContainerScreen<PlanetSelectScreenClassGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public PlanetSelectScreenClassGuiWindow(PlanetSelectScreenClassGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 431;
		this.ySize = 247;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/orbit2.png"));
		this.blit(ms, this.guiLeft + 117, this.guiTop + 16, 0, 0, 200, 200, 200, 200);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/orbitone.png"));
		this.blit(ms, this.guiLeft + 73, this.guiTop + -6, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mars.png"));
		this.blit(ms, this.guiLeft + 110, this.guiTop + 113, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/earth.png"));
		this.blit(ms, this.guiLeft + 149, this.guiTop + 69, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/venusorbit.png"));
		this.blit(ms, this.guiLeft + 142, this.guiTop + 42, 0, 0, 160, 160, 160, 160);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/venus.png"));
		this.blit(ms, this.guiLeft + 207, this.guiTop + 52, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercorbitnew.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + 85, 0, 0, 64, 64, 64, 64);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 199, this.guiTop + 88, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/sun.png"));
		this.blit(ms, this.guiLeft + 217, this.guiTop + 110, 0, 0, 16, 16, 16, 16);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Planets", 200, 5, -16711936);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 19, this.guiTop + 34, 40, 20, new StringTextComponent("Sun"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(0, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 0, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 19, this.guiTop + 61, 60, 20, new StringTextComponent("Mercury"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(1, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 1, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + 91, 50, 20, new StringTextComponent("Venus"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(2, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 2, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + 121, 50, 20, new StringTextComponent("Earth"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(3, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 3, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + 151, 45, 20, new StringTextComponent("Mars"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(4, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 4, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 343, this.guiTop + 223, 85, 20, new StringTextComponent("Next Page >>"), e -> {
			Ris3Mod.PACKET_HANDLER.sendToServer(new PlanetSelectScreenClassGui.ButtonPressedMessage(5, x, y, z));
			PlanetSelectScreenClassGui.handleButtonAction(entity, 5, x, y, z);
		}));
	}
}
