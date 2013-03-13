package net.minecraft.src;

public class IFA_ItemBucketProxy extends ItemBucket {

	public IFA_ItemBucketProxy(int par1, int par2) {
		super(par1, par2);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		int ldm = par1ItemStack.getItemDamage();
		ItemStack lis = super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
		lis.setItemDamage(ldm);
		return lis;
	}

}
