package mmm.fragileArmor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class ItemFragileArmor extends ItemArmor {

	/**
	 * 内部で使用する素材の保存値、エンチャ係数や素材基準の数値には反映されない。
	 */
	public EnumArmorMaterial fragileMaterial;
	public int fuelTime;
	protected IIcon ficonBK;
	protected String funlocalizedName;

	// Method
	public ItemFragileArmor(EnumArmorMaterial pMaterial, int pRenderIndex,
			int pArmorType, int pFuelTime) {
		super(pMaterial.getAddedMaterial(), pRenderIndex, pArmorType);
		fragileMaterial = pMaterial;
		// 標準燃焼時間
		fuelTime = pFuelTime;
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		funlocalizedName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return fragileMaterial.isColored();
	}

	@Override
	public boolean hasColor(ItemStack par1ItemStack) {
		return !fragileMaterial.isColored() ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display", 10) ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color", 3)));
	}

	/**
	 * アーマーカラーの補正
	 */
	@Override
	public int getColor(ItemStack par1ItemStack) {
		if (fragileMaterial.isColored()) {
			// 合成着色料は使用しております
			NBTTagCompound ltag1 = par1ItemStack.getTagCompound();
			
			if (ltag1 == null) {
				return 0xffffff;
			} else {
				NBTTagCompound ltag2 = ltag1.getCompoundTag("display");
				return ltag2 == null ? 0xffffff : (ltag2.hasKey("color", 3) ? ltag2.getInteger("color") : 0xffffff);
			}
		} else {
			return -1;
		}
	}

	@Override
	public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 1 ? ficonBK : super.getIconFromDamageForRenderPass(par1, par2);
	}

	/**
	 * お洗濯
	 */
	@Override
	public void removeColor(ItemStack par1ItemStack) {
		if (fragileMaterial == EnumArmorMaterial.PAPER) {
			// 紙製品は洗ったらダメだろJK
			par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
		} else if (fragileMaterial.isColored()) {
			// 色落ち激しす
			NBTTagCompound ltag1 = par1ItemStack.getTagCompound();
			if (ltag1 != null) {
				NBTTagCompound ltag2 = ltag1.getCompoundTag("display");
				if (ltag2.hasKey("color")) {
					ltag2.removeTag("color");
				}
			}
		}
	}

	public void func_82813_b(ItemStack par1ItemStack, int par2) {
		if (fragileMaterial.isColored()) {
			NBTTagCompound ltag1 = par1ItemStack.getTagCompound();
			
			if (ltag1 == null) {
				ltag1 = new NBTTagCompound();
				par1ItemStack.setTagCompound(ltag1);
			}
			
			NBTTagCompound ltag2 = ltag1.getCompoundTag("display");
			
			if (!ltag1.hasKey("display", 10)) {
				ltag1.setTag("display", ltag2);
			}
			
			ltag2.setInteger("color", par2);
		}
	}

	/**
	 * 修理素材の判定
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		switch (fragileMaterial) {
		case PAPER:
			// 紙アーマー
			if (par2ItemStack.getItem() == Items.paper || par2ItemStack.getItem() instanceof ItemMapBase) {
				return true;
			}
			break;
		case WOOL:
			if (par2ItemStack.getItem() == Item.getItemFromBlock(Blocks.wool)) {
				return true;
			}
			break;
		case OAK:
			if (par2ItemStack.getItem() == Item.getItemFromBlock(Blocks.planks)
					&& par2ItemStack.getItemDamage() == 0) {
				return true;
			}
			break;
		case SPRUCE:
			if (par2ItemStack.getItem() == Item.getItemFromBlock(Blocks.planks)
					&& par2ItemStack.getItemDamage() == 1) {
				return true;
			}
			break;
		case BIRCH:
			if (par2ItemStack.getItem() == Item.getItemFromBlock(Blocks.planks)
					&& par2ItemStack.getItemDamage() == 2) {
				return true;
			}
			break;
		case JUNGLE:
			if (par2ItemStack.getItem() == Item.getItemFromBlock(Blocks.planks)
					&& par2ItemStack.getItemDamage() == 3) {
				return true;
			}
			break;
		}

		return false;
	}

	/**
	 * アイコンを登録
	 */
	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		
		if (fragileMaterial.isColored()) {
			ficonBK = par1IconRegister.registerIcon(funlocalizedName + "_overlay");
		}
	};

	public void setFuelTime(int pFuelTIme) {
		fuelTime = pFuelTIme;
	}

	public int getFuelTime(int pDamage) {
		return (fuelTime * (getMaxDamage() - pDamage)) / getMaxDamage();
	}

}
