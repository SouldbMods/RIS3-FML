
package xyz.souldb.ris3.gui;

import xyz.souldb.ris3.Ris3Mod;

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

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EarthMoonsGuiWindow extends ContainerScreen<EarthMoonsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public EarthMoonsGuiWindow(EarthMoonsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 431;
		this.ySize = 243;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/selbackroundmain.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -2, 0, 0, 431, 247, 431, 247);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercorbitnew.png"));
		this.blit(ms, this.guiLeft + 193, this.guiTop + 86, 0, 0, 64, 64, 64, 64);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 202, this.guiTop + 92, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/earth.png"));
		this.blit(ms, this.guiLeft + 220, this.guiTop + 114, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 300, this.guiTop + 132, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/orbit2.png"));
		this.blit(ms, this.guiLeft + 127, this.guiTop + 18, 0, 0, 200, 200, 200, 200);
		RenderSystem.disableBlend();
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
		this.font.drawString(ms, "T1", 75, 67, -1);
		this.font.drawString(ms, "Earth", 209, 5, -16776961);
		this.font.drawString(ms, "T2", 85, 91, -1);
		this.font.drawString(ms, "T1", 73, 40, -1);
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
		this.addButton(new Button(this.guiLeft + 19, this.guiTop + 65, 45, 20, new StringTextComponent("Moon"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new EarthMoonsGui.ButtonPressedMessage(0, x, y, z));
				EarthMoonsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 19, this.guiTop + 90, 60, 20, new StringTextComponent("Moon #2"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new EarthMoonsGui.ButtonPressedMessage(1, x, y, z));
				EarthMoonsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 218, 120, 20, new StringTextComponent("<<< Back"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new EarthMoonsGui.ButtonPressedMessage(2, x, y, z));
				EarthMoonsGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + 40, 50, 20, new StringTextComponent("Earth"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new EarthMoonsGui.ButtonPressedMessage(3, x, y, z));
				EarthMoonsGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
