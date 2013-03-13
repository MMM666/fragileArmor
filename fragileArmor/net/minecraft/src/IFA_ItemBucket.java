package net.minecraft.src;

/**
 * かぶれるバケツ
 */
public class IFA_ItemBucket extends ItemArmor {
	
	private Item fbucket;

	public IFA_ItemBucket(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, Item pItem) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		
		maxStackSize = 1;
		setMaxDamage(getMaxDamage() / 2);
		setCreativeTab(CreativeTabs.tabMisc);
		
		fbucket = pItem;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		int ldm = par1ItemStack.getItemDamage();
		if (ldm > 0) return par1ItemStack;
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
/*
		// 対策が思いつかないので下の判定は無効
		if (ldm > (getMaxDamage() * 2 / 3)) {
			// 強度が1/3以下の場合は汲めない。
			return par1ItemStack;
		}
		ItemStack lis = fbucket.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
		lis.setItemDamage(ldm);
		if (lis.itemID == Item.bucketMilk.itemID && ldm > 0) {
			// 衛生上の観点から牛乳は汲めない。
			return par1ItemStack;
		}
		return lis;
		*/
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		// ダメージ有りのものを別IDへ変える
		if (par1ItemStack.getItemDamage() > 0) {
			par1ItemStack.itemID = mod_IFA_fragileArmor.bucketDamaged.itemID;
		}
	}

}
