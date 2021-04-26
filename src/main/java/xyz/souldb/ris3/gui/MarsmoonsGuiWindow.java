
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MarsmoonsGuiWindow extends ContainerScreen<MarsmoonsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget SearchMoons;
	public MarsmoonsGuiWindow(MarsmoonsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 434;
		this.ySize = 245;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		SearchMoons.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/selbackround.png"));
		this.blit(ms, this.guiLeft + -18, this.guiTop + -2, 0, 0, 854, 480, 854, 480);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mars.png"));
		this.blit(ms, this.guiLeft + 206, this.guiTop + 97, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercorbitnew.png"));
		this.blit(ms, this.guiLeft + 182, this.guiTop + 76, 0, 0, 64, 64, 64, 64);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 188, this.guiTop + 123, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 228, this.guiTop + 85, 0, 0, 16, 16, 16, 16);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (SearchMoons.isFocused())
			return SearchMoons.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		SearchMoons.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "T2", 64, 53, -1);
		this.font.drawString(ms, "T3", 74, 84, -1);
		this.font.drawString(ms, "T3", 76, 108, -1);
		this.font.drawString(ms, "Mars", 203, 3, -65536);
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
		this.addButton(new Button(this.guiLeft + 15, this.guiTop + 52, 45, 20, new StringTextComponent("Mars"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new MarsmoonsGui.ButtonPressedMessage(0, x, y, z));
				MarsmoonsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 16, this.guiTop + 82, 55, 20, new StringTextComponent("Phobos"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new MarsmoonsGui.ButtonPressedMessage(1, x, y, z));
				MarsmoonsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 17, this.guiTop + 107, 55, 20, new StringTextComponent("Deimos"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new MarsmoonsGui.ButtonPressedMessage(2, x, y, z));
				MarsmoonsGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		SearchMoons = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 6, 120, 20, new StringTextComponent("Search Moons")) {
			{
				setSuggestion("Search Moons");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Search Moons");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Search Moons");
				else
					setSuggestion(null);
			}
		};
		MarsmoonsGui.guistate.put("text:SearchMoons", SearchMoons);
		SearchMoons.setMaxStringLength(32767);
		this.children.add(this.SearchMoons);
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 221, 65, 20, new StringTextComponent("<<< Back"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new MarsmoonsGui.ButtonPressedMessage(3, x, y, z));
				MarsmoonsGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
