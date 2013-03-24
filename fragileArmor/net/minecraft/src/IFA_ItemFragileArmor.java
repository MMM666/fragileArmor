package net.minecraft.src;

public class IFA_ItemFragileArmor extends ItemArmor {
/*
	public static final int matPaper = 0;
	public static final int matWool = 1;
	public static final int matOak = 2;
	public static final int matSpruce = 3;
	public static final int matBirch = 4;
	public static final int matJungle = 5;
	public static final String colorNames[] = {
		"paper", "wool", "oak", "spruce", "birch", "jungle" };
	public static final int colorValues[] = {
		0xefefff, 0xdfdfaf, 0xbc9862, 0x805e36, 0xd7cb8d, 0xb88764 };
*/
	/**
	 * �����Ŏg�p����f�ނ̕ۑ��l�A�G���`���W����f�ފ�̐��l�ɂ͔��f����Ȃ��B
	 */
	public IFA_EnumArmorMaterial fragileMaterial;
	public int fuelTime;
	protected Icon ficonBK;
	protected String funnlocalizedName;

	// Method
	public IFA_ItemFragileArmor(int i, IFA_EnumArmorMaterial pMaterial,
			int j, int k, int pFueltime) {
		super(i, pMaterial.getBaseMaterial(), j, k);
		// �G���`���̌W������ς������ꍇ��enumarmormaterial�����̒l��EnumArmorMaterial����I�ԁB
		// �Ǝ��}�e���A���̋L��
		fragileMaterial = pMaterial;
		// �A�[�}�[�ϋv�̐ݒ�
		setMaxDamage(pMaterial.getDurability(k));
		// �W���R�Ď���
		fuelTime = pFueltime;
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		funnlocalizedName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return fragileMaterial.isColored();
	}

	@Override
	public int getItemEnchantability() {
		return fragileMaterial.getEnchantability();
	}

	/**
	 * ���z�I�ɈႤ�f�ނ�Ԃ����Ƃŕ`��΍������B
	 * �v�̃A�[�}�[�̓A�C�R�������ɂȂ邽�߁B
	 */
	@Override
	public EnumArmorMaterial getArmorMaterial() {
		return fragileMaterial.isColored() ? EnumArmorMaterial.CLOTH : EnumArmorMaterial.CHAIN;
	}

	public boolean hasColor(ItemStack par1ItemStack) {
		return !fragileMaterial.isColored() ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
	}

	/**
	 * �A�[�}�[�J���[�̕␳
	 */
	@Override
	public int getColor(ItemStack par1ItemStack) {
		if (fragileMaterial.isColored()) {
			// �������F���͎g�p���Ă���܂�
			NBTTagCompound var2 = par1ItemStack.getTagCompound();
			
			if (var2 == null) {
				return 0xffffff;
			} else {
				NBTTagCompound var3 = var2.getCompoundTag("display");
				return var3 == null ? 0xffffff : (var3.hasKey("color") ? var3.getInteger("color") : 0xffffff);
			}
		} else {
			return -1;
		}
	}

	public Icon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 1 ? ficonBK : super.getIconFromDamageForRenderPass(par1, par2);
	}

	/**
	 * ������
	 */
	@Override
	public void removeColor(ItemStack par1ItemStack) {
		if (fragileMaterial == IFA_EnumArmorMaterial.WOOL) {
			// �F����������
			super.removeColor(par1ItemStack);
		} else if (fragileMaterial == IFA_EnumArmorMaterial.PAPER) {
			// �����i�͐������_������JK
			par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
		}
	}

	/**
	 * �C���f�ނ̔���
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		switch (fragileMaterial) {
		case PAPER:
			// ���A�[�}�[
			if (par2ItemStack.itemID == Item.paper.itemID
					|| par2ItemStack.getItem() instanceof ItemMapBase) {
				return true;
			}
			break;
		case WOOL:
			if (par2ItemStack.itemID == Block.cloth.blockID) {
				return true;
			}
			break;
		case OAK:
			if (par2ItemStack.itemID == Block.planks.blockID
					&& par2ItemStack.getItemDamage() == 0) {
				return true;
			}
			break;
		case SPRUCE:
			if (par2ItemStack.itemID == Block.planks.blockID
					&& par2ItemStack.getItemDamage() == 1) {
				return true;
			}
			break;
		case BIRCH:
			if (par2ItemStack.itemID == Block.planks.blockID
					&& par2ItemStack.getItemDamage() == 2) {
				return true;
			}
			break;
		case JUNGLE:
			if (par2ItemStack.itemID == Block.planks.blockID
					&& par2ItemStack.getItemDamage() == 3) {
				return true;
			}
			break;
		}

		return false;
	}

	/**
	 * �A�C�R����o�^
	 */
	@Override
	public void updateIcons(IconRegister par1IconRegister) {
		super.updateIcons(par1IconRegister);
		
		if (fragileMaterial.isColored()) {
			ficonBK = par1IconRegister.registerIcon(funnlocalizedName + "_overlay");
		}
	};

	public void setFuelTime(int pFuelTIme) {
		fuelTime = pFuelTIme;
	}

	public int getFuelTime(int pDamage) {
		return (fuelTime * (getMaxDamage() - pDamage)) / getMaxDamage();
	}

}
