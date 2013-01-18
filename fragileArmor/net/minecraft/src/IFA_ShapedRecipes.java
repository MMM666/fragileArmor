package net.minecraft.src;

import java.util.List;

public class IFA_ShapedRecipes extends ShapedRecipes {

	public static void replaceLastRecipe() {
		// 最後に追加されたレシピを置き換える。
		List llist = CraftingManager.getInstance().getRecipeList();
		if (llist.get(llist.size() - 1) instanceof ShapedRecipes) {
			// レシピ
			ShapedRecipes lrecipe = (ShapedRecipes)llist.remove(llist.size() - 1);
			try {
				int lwidth	= (Integer)ModLoader.getPrivateValue(ShapedRecipes.class, lrecipe, 0);
				int lheight	= (Integer)ModLoader.getPrivateValue(ShapedRecipes.class, lrecipe, 1);
				ItemStack[] litems	= (ItemStack[])ModLoader.getPrivateValue(ShapedRecipes.class, lrecipe, 2);
				ItemStack loutput	= (ItemStack)ModLoader.getPrivateValue(ShapedRecipes.class, lrecipe, 3);
				llist.add(new IFA_ShapedRecipes(lwidth, lheight, litems, loutput));
				System.out.println("fragileArmor-replace success: " + loutput.getItemName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public IFA_ShapedRecipes(int par1, int par2, ItemStack[] par3ArrayOfItemStack, ItemStack par4ItemStack) {
		super(par1, par2, par3ArrayOfItemStack, par4ItemStack);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
		ItemStack lresult = super.getCraftingResult(par1InventoryCrafting);
		int lcol[] = {0, 0, 0};
		int lcoladd[] = {0, 0, 0};
		int lcount = 0;
		int lmax = 0;
		
		for (int li = 0; li < par1InventoryCrafting.getSizeInventory(); li++) {
			ItemStack lis = par1InventoryCrafting.getStackInSlot(li);
			if (lis != null && lis.itemID == Block.cloth.blockID) {
				float[] lflrrce = EntitySheep.fleeceColorTable[lis.getItemDamage()];
				lcol[0] = (int)(lflrrce[0] * 255.0F);
				lcol[1] = (int)(lflrrce[1] * 255.0F);
				lcol[2] = (int)(lflrrce[2] * 255.0F);
				lmax += Math.max(lcol[0], Math.max(lcol[1], lcol[2]));
				lcoladd[0] += lcol[0];
				lcoladd[1] += lcol[1];
				lcoladd[2] += lcol[2];
				lcount++;
			}
		}
		// 色の確定、算出式は丸パクリ
		lcol[0] = lcoladd[0] / lcount;
		lcol[1] = lcoladd[1] / lcount;
		lcol[2] = lcoladd[2] / lcount;
		float lfmax = (float)lmax / (float)lcount;
		float lcmax = (float)Math.max(lcol[0], Math.max(lcol[1], lcol[2]));
		lcol[0] = (int)((float)lcol[0] * lfmax / lcmax);
		lcol[1] = (int)((float)lcol[1] * lfmax / lcmax);
		lcol[2] = (int)((float)lcol[2] * lfmax / lcmax);
		int lcolor = (lcol[0] << 16) + (lcol[1] << 8) + lcol[2];
		((IFA_ItemFragileArmor)lresult.getItem()).func_82813_b(lresult, lcolor);
		
		return lresult;
	}
	
}
