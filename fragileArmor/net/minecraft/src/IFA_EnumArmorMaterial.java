package net.minecraft.src;

public enum IFA_EnumArmorMaterial {

	PAPER(1, true, EnumArmorMaterial.CLOTH, 20),
	WOOL(2, true, EnumArmorMaterial.CLOTH, 13),
	OAK(4, false, EnumArmorMaterial.CLOTH, 20),
	BIRCH(4, false, EnumArmorMaterial.CLOTH, 20),
	SPRUCE(4, false, EnumArmorMaterial.CLOTH, 20),
	JUNGLE(4, false, EnumArmorMaterial.CLOTH, 20);


	private int maxDamageFactor;
	private boolean fColored;
	private EnumArmorMaterial fBaseMaterial;
	private int enchantability;

	private IFA_EnumArmorMaterial(int pmaxDamageFactor, boolean pColored, EnumArmorMaterial pBaseMaterial, int pEnchantability) {
		maxDamageFactor = pmaxDamageFactor;
		fColored = pColored;
		fBaseMaterial = pBaseMaterial;
		enchantability = pEnchantability;
	}

	public boolean isColored() {
		return fColored;
	}

	public EnumArmorMaterial getBaseMaterial() {
		return fBaseMaterial;
	}
	
	public int getDurability(int par1) {
		return ItemArmor.getMaxDamageArray()[par1] * maxDamageFactor;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

}
