package mmm.fragileArmor;

import java.util.List;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ShapedRecipes extends net.minecraft.item.crafting.ShapedRecipes {

	/**
	 * 布の服用のレシピ処理を追加する。
	 * @param par1ItemStack
	 * @param par2ArrayOfObj
	 * @return
	 */
	public static ShapedRecipes addRecipes(ItemStack par1ItemStack, Object ... par2ArrayOfObj) {
		return replaceLastRecipe(GameRegistry.addShapedRecipe(par1ItemStack, par2ArrayOfObj));
	}

	/**
	 * レシピの解析部分を作るのが面倒だったので、
	 * 作ったレシピから必要な部分をコピって成り代わるようにしている。
	 */
	public static ShapedRecipes replaceLastRecipe(IRecipe pRecipe) {
		// 最後に追加されたレシピを置き換える。
		if (pRecipe instanceof ShapedRecipes) {
			ShapedRecipes lrecipe = (ShapedRecipes)pRecipe;
			@SuppressWarnings("unchecked")
			List<IRecipe> llist = CraftingManager.getInstance().getRecipeList();
			if (llist.remove(pRecipe)) {
				// 対象が存在しているので削除して置換え
				int lwidth	= lrecipe.recipeWidth;
				int lheight	= lrecipe.recipeHeight;
				ItemStack[] litems	= lrecipe.recipeItems;
				ItemStack loutput	= lrecipe.getRecipeOutput();
				lrecipe = new ShapedRecipes(lwidth, lheight, litems, loutput);
				llist.add(lrecipe);
				return lrecipe;
			}
		}
		return null;
	}


	public ShapedRecipes(int par1, int par2, ItemStack[] par3ArrayOfItemStack, ItemStack par4ItemStack) {
		super(par1, par2, par3ArrayOfItemStack, par4ItemStack);
	}

	/**
	 * 色の計算部分の実装。
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
		ItemStack lresult = super.getCraftingResult(par1InventoryCrafting);
		int lcol[] = {0, 0, 0};
		int lcoladd[] = {0, 0, 0};
		int lcount = 0;
		int lmax = 0;
		Item lwool = Item.getItemFromBlock(Blocks.wool);
		
		for (int li = 0; li < par1InventoryCrafting.getSizeInventory(); li++) {
			ItemStack lis = par1InventoryCrafting.getStackInSlot(li);
			if (lis != null && lis.getItem() == lwool) {
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
		((ItemFragileArmor)lresult.getItem()).func_82813_b(lresult, lcolor);
		
		return lresult;
	}

}
