package mmm.fragileArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * かぶれるバケツ
 */
public class ItemBucketHelm extends ItemArmor {
	
	public ItemBucketHelm(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		
		maxStackSize = 1;
		setMaxDamage(getMaxDamage() / 2);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack.splitStack(1), par2World, par3EntityPlayer);
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
		// ダメージが無いものは元に戻す
		if (par1ItemStack.getItemDamage() == 0) {
			par1ItemStack.func_150996_a(fragileArmor.bucket);
		}
	}

}
