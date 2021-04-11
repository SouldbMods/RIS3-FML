
package xyz.souldb.ris3.entity;

import xyz.souldb.ris3.gui.PlanetSelectScreenClassGui;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@Ris3ModElements.ModElement.Tag
public class RocketoneEntity extends Ris3ModElements.ModElement {
	public static EntityType entity = null;
	public RocketoneEntity(Ris3ModElements instance) {
		super(instance, 94);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("rocketone").setRegistryName("rocketone");
		elements.entities.add(() -> entity);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrk(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("ris3:textures/rockettexture.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(true);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			if (source.getDamageType().equals("trident"))
				return false;
			if (source == DamageSource.ANVIL)
				return false;
			if (source == DamageSource.DRAGON_BREATH)
				return false;
			return super.attackEntityFrom(source, amount);
		}
		private final ItemStackHandler inventory = new ItemStackHandler(0) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}
		};
		private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this),
				new EntityArmorInvWrapper(this));
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
			if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == null)
				return LazyOptional.of(() -> combined).cast();
			return super.getCapability(capability, side);
		}

		@Override
		protected void dropInventory() {
			super.dropInventory();
			for (int i = 0; i < inventory.getSlots(); ++i) {
				ItemStack itemstack = inventory.getStackInSlot(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.entityDropItem(itemstack);
				}
			}
		}

		@Override
		public void writeAdditional(CompoundNBT compound) {
			super.writeAdditional(compound);
			compound.put("InventoryCustom", inventory.serializeNBT());
		}

		@Override
		public void readAdditional(CompoundNBT compound) {
			super.readAdditional(compound);
			INBT inventoryCustom = compound.get("InventoryCustom");
			if (inventoryCustom instanceof CompoundNBT)
				inventory.deserializeNBT((CompoundNBT) inventoryCustom);
		}

		@Override
		public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
			if (sourceentity.isSecondaryUseActive()) {
				if (sourceentity instanceof ServerPlayerEntity) {
					NetworkHooks.openGui((ServerPlayerEntity) sourceentity, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Tier One Rocket");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
							packetBuffer.writeBlockPos(new BlockPos(sourceentity.getPosition()));
							packetBuffer.writeByte(0);
							packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
							return new PlanetSelectScreenClassGui.GuiContainerMod(id, inventory, packetBuffer);
						}
					}, buf -> {
						buf.writeBlockPos(new BlockPos(sourceentity.getPosition()));
						buf.writeByte(0);
						buf.writeVarInt(this.getEntityId());
					});
				}
				return ActionResultType.func_233537_a_(this.world.isRemote());
			}
			super.func_230254_b_(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelrk extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bb_main;
		public Modelrk() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(8.0F, 37.0F, -7.0F);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(6.0F, -1.0F, -10.0F);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-8.0F, -50.0F, -8.0F, 16.0F, 50.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-7.0F, -51.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-6.0F, -52.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-5.0F, -53.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-4.0F, -54.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-3.0F, -55.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -56.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-1.0F, -76.0F, -1.0F, 2.0F, 20.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -80.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(8.0F, -37.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-10.0F, -37.0F, -6.0F, 2.0F, 12.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-6.0F, -37.0F, 8.0F, 12.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-6.0F, -37.0F, -10.0F, 12.0F, 12.0F, 2.0F, 0.0F, true);
			bb_main.setTextureOffset(0, 0).addBox(-12.0F, -2.0F, 6.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-12.0F, -2.0F, -12.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(6.0F, -2.0F, -12.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(6.0F, -2.0F, 6.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-16.0F, 2.0F, 10.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-16.0F, 2.0F, -16.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(10.0F, 2.0F, -16.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(10.0F, 2.0F, 10.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(14.0F, 6.0F, 14.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-20.0F, 6.0F, 14.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-20.0F, 6.0F, -20.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(14.0F, 6.0F, -20.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(18.0F, 10.0F, 18.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-23.0F, 10.0F, 18.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-23.0F, 10.0F, -23.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(17.0F, 10.0F, -23.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-4.0F, 2.0F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-5.0F, 4.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-7.0F, 6.0F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-8.0F, 8.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
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
