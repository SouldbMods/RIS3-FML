
package xyz.souldb.ris3.entity;

import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@Ris3ModElements.ModElement.Tag
public class RocketthreeEntity extends Ris3ModElements.ModElement {
	public static EntityType entity = null;
	public RocketthreeEntity(Ris3ModElements instance) {
		super(instance, 151);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("rocketthree").setRegistryName("rocketthree");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 20, 4, 4));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrk3(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("ris3:textures/rk3.png");
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
		ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("Tier 3 Rocket"));
			setCustomNameVisible(true);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
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
		public boolean onLivingFall(float l, float d) {
			return false;
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

		@Override
		public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
			super.func_230254_b_(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelrk3 extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		public Modelrk3() {
			textureWidth = 336;
			textureHeight = 336;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-17.0F, -100.0F, -15.0F, 32.0F, 100.0F, 32.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 132).addBox(-16.0F, -101.0F, -14.0F, 30.0F, 1.0F, 30.0F, 0.0F, false);
			bb_main.setTextureOffset(120, 132).addBox(-15.0F, -102.0F, -13.0F, 28.0F, 1.0F, 28.0F, 0.0F, false);
			bb_main.setTextureOffset(232, 132).addBox(-14.0F, -103.0F, -12.0F, 26.0F, 1.0F, 26.0F, 0.0F, false);
			bb_main.setTextureOffset(128, 163).addBox(-13.0F, -105.0F, -11.0F, 24.0F, 1.0F, 24.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 228).addBox(-12.0F, -106.0F, -10.0F, 22.0F, 1.0F, 22.0F, 0.0F, false);
			bb_main.setTextureOffset(88, 228).addBox(-11.0F, -107.0F, -9.0F, 20.0F, 1.0F, 20.0F, 0.0F, false);
			bb_main.setTextureOffset(168, 228).addBox(-10.0F, -108.0F, -8.0F, 18.0F, 1.0F, 18.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 251).addBox(-9.0F, -109.0F, -7.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 268).addBox(-8.0F, -110.0F, -6.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 283).addBox(-7.0F, -111.0F, -5.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			bb_main.setTextureOffset(44, 303).addBox(-6.0F, -112.0F, -4.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(84, 303).addBox(-5.0F, -113.0F, -3.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(164, 303).addBox(-4.0F, -114.0F, -2.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(188, 311).addBox(-3.0F, -115.0F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(64, 251).addBox(-2.0F, -165.0F, 0.0F, 2.0F, 50.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(188, 303).addBox(-3.0F, -169.0F, -1.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(240, 228).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
			bb_main.setTextureOffset(128, 0).addBox(-17.0F, 5.0F, -15.0F, 32.0F, 5.0F, 32.0F, 0.0F, false);
			bb_main.setTextureOffset(64, 163).addBox(-47.0F, -63.0F, 0.0F, 30.0F, 63.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 303).addBox(-37.0F, -75.0F, 0.0F, 20.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(140, 303).addBox(-27.0F, -87.0F, 0.0F, 10.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 163).addBox(15.0F, -63.0F, 0.0F, 30.0F, 63.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(72, 251).addBox(15.0F, -75.0F, 0.0F, 20.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(116, 303).addBox(15.0F, -87.0F, 0.0F, 10.0F, 12.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(232, 132).addBox(-13.0F, -104.0F, -11.0F, 24.0F, 1.0F, 24.0F, 0.0F, false);
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
