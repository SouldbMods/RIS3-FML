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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}