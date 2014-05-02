package mmm.fragileArmor;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBucketReplace extends ItemBucket {

	public ItemBucketReplace(Block p_i45331_1_) {
		super(p_i45331_1_);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		ItemStack lir = par1ItemStack.copy();
		ItemStack lis = super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
		if (ItemStack.areItemStacksEqual(lir, lis)) {
			lir.func_150996_a(fragileArmor.bucketDamaged);
			lir = fragileArmor.bucketDamaged.onItemRightClick(lir, par2World, par3EntityPlayer);
			if (lir.stackSize <= 0) {
				lis.stackSize -= 1;
			}
		}
		return lis;
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		// 被れる
		return (armorType == 0) ? true : super.isValidArmor(stack, armorType, entity);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		// 装備スロットに入れたときにアイテムを変更する。
		super.onArmorTick(world, player, itemStack);
		itemStack.func_150996_a(fragileArmor.bucketDamaged);
	}

}
