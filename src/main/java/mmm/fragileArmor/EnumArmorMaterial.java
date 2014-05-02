package mmm.fragileArmor;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public enum EnumArmorMaterial {

	PAPER(1, new int[]{1, 3, 2, 1}, 20, true, ArmorMaterial.CLOTH),
	WOOL(2, new int[]{1, 3, 2, 1}, 13, true, ArmorMaterial.CLOTH),
	OAK(4, new int[]{1, 3, 2, 1}, 20, false, ArmorMaterial.CLOTH),
	BIRCH(4, new int[]{1, 3, 2, 1}, 20, false, ArmorMaterial.CLOTH),
	SPRUCE(4, new int[]{1, 3, 2, 1}, 20, false, ArmorMaterial.CLOTH),
	JUNGLE(4, new int[]{1, 3, 2, 1}, 20, false, ArmorMaterial.CLOTH);


	private ArmorMaterial addedMaterial;
	private boolean fColored;

	private EnumArmorMaterial(int pMaxDamageFactor,
			int[] pDamageReductionAmountArray, int pEnchantability, boolean pColored, ArmorMaterial pMaterial) {
		addedMaterial = EnumHelper.addArmorMaterial(this.name(), pMaxDamageFactor, pDamageReductionAmountArray, pEnchantability);
		fColored = pColored;
	}

	public boolean isColored() {
		return fColored;
	}

	public ArmorMaterial getAddedMaterial() {
		return addedMaterial;
	}

}
