
package xyz.souldb.ris3.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ConfigGuiWindow extends ContainerScreen<ConfigGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ConfigGui.guistate;
	CheckboxButton ge;
	CheckboxButton rke;
	CheckboxButton mps;
	CheckboxButton ce;
	CheckboxButton cmmd;
	CheckboxButton te;
	public ConfigGuiWindow(ConfigGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 193;
		this.ySize = 212;
	}
	private static final ResourceLocation texture = new ResourceLocation("ris3:textures/config.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/cs.png"));
		this.blit(ms, this.guiLeft + 85, this.guiTop + 170, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/ss.png"));
		this.blit(ms, this.guiLeft + 76, this.guiTop + 188, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/ss.png"));
		this.blit(ms, this.guiLeft + 121, this.guiTop + 24, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/ss.png"));
		this.blit(ms, this.guiLeft + 120, this.guiTop + 47, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/ss.png"));
		this.blit(ms, this.guiLeft + 94, this.guiTop + 73, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/cs.png"));
		this.blit(ms, this.guiLeft + 127, this.guiTop + 100, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/cs.png"));
		this.blit(ms, this.guiLeft + 162, this.guiTop + 126, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/cs.png"));
		this.blit(ms, this.guiLeft + 123, this.guiTop + 155, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Config", 81, 4, -12829636);
		this.font.drawString(ms, "Client side  = ", 8, 177, -12829636);
		this.font.drawString(ms, "Server Side =", 8, 190, -12829636);
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
		ge = new CheckboxButton(this.guiLeft + 8, this.guiTop + 21, 150, 20, new StringTextComponent("Gravity Disabled"), false);
		ConfigGui.guistate.put("checkbox:ge", ge);
		this.addButton(ge);
		rke = new CheckboxButton(this.guiLeft + 8, this.guiTop + 46, 150, 20, new StringTextComponent("Rockets disabled"), false);
		ConfigGui.guistate.put("checkbox:rke", rke);
		this.addButton(rke);
		mps = new CheckboxButton(this.guiLeft + 8, this.guiTop + 72, 150, 20, new StringTextComponent("LAN Enabled"), false);
		ConfigGui.guistate.put("checkbox:mps", mps);
		this.addButton(mps);
		ce = new CheckboxButton(this.guiLeft + 7, this.guiTop + 98, 150, 20, new StringTextComponent("Cosmetics Disabled"), false);
		ConfigGui.guistate.put("checkbox:ce", ce);
		this.addButton(ce);
		cmmd = new CheckboxButton(this.guiLeft + 8, this.guiTop + 125, 150, 20, new StringTextComponent("Custom main menu disabled"), false);
		ConfigGui.guistate.put("checkbox:cmmd", cmmd);
		this.addButton(cmmd);
		te = new CheckboxButton(this.guiLeft + 9, this.guiTop + 153, 150, 20, new StringTextComponent("Trashslot Enabled"), false);
		ConfigGui.guistate.put("checkbox:te", te);
		this.addButton(te);
	}
}
