
package xyz.souldb.ris3.gui;

import xyz.souldb.ris3.Ris3Mod;

import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.concurrent.atomic.AtomicInteger;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BatteryUIGuiWindow extends ContainerScreen<BatteryUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public BatteryUIGuiWindow(BatteryUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 245;
		this.ySize = 229;
	}
	private static final ResourceLocation texture = new ResourceLocation("ris3:textures/battery_ui.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 47, 0, 0, 24, 16, 24, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_not_equipped.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_lvl_1.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_2.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_3.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_4.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/oxygen_5.png"));
		this.blit(ms, this.guiLeft + 195, this.guiTop + 29, 0, 0, 16, 32, 16, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ris3:textures/rocketingui.png"));
		this.blit(ms, this.guiLeft + 222, this.guiTop + 209, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "Battery", 103, 4, -12829636);
		this.font.drawString(ms, "Transfer Rate- 128 E / Tick", 105, 83, -12829636);
		this.font.drawString(ms, "Quick charger", 6, 20, -12829636);
		this.font.drawString(ms, "Charge Mode", 6, 29, -16776961);
		this.font.drawString(ms, "Discharge Mode", 6, 29, -65536);
		this.font.drawString(ms, "" + (new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + " E / 60KE", 132, 65, -12829636);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 74, 55, 20, new StringTextComponent("Charge"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new BatteryUIGui.ButtonPressedMessage(0, x, y, z));
				BatteryUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 101, 85, 20, new StringTextComponent("Toggle Modes"), e -> {
			if (true) {
				Ris3Mod.PACKET_HANDLER.sendToServer(new BatteryUIGui.ButtonPressedMessage(1, x, y, z));
				BatteryUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
