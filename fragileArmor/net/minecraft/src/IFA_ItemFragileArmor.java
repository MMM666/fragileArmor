package net.minecraft.src;

public class IFA_ItemFragileArmor extends ItemArmor {

	public static final int matPaper	= 0;
	public static final int matWool		= 1;
	public static final int matOak		= 2;
	public static final int matSpruce	= 3;
	public static final int matBirch	= 4;
	public static final int matJungle	= 5;
    public static final String colorNames[] = {
        "paper", "wool", "oak", "spruce", "birch", "jungle"
    };
    public static final int colorValues[] = {
        0xefefff, 0xdfdfaf, 0xbc9862, 0x805e36, 0xd7cb8d, 0xb88764
    };

    public int fragileMaterial;

    // Method
    public IFA_ItemFragileArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k, int material, int maxdamegeRate) {
		super(i, enumarmormaterial, j, k);
		// 独自マテリアルの記憶
		fragileMaterial = material;
		// アーマー耐久の設定（革鎧基準）
        setMaxDamage(EnumArmorMaterial.CLOTH.getDurability(k) * maxdamegeRate / 5);
	}

    /**
     * アーマーカラーの補正
     */
    @Override
    public int getColor(ItemStack par1ItemStack) {
        if (fragileMaterial > 1) {
        	// 紙アーマー
            return colorValues[fragileMaterial];
        } else {
        	// 毛糸のお洋服
        	NBTTagCompound var2 = par1ItemStack.getTagCompound();

            if (var2 == null) {
                return 0xffffff;
            } else {
                NBTTagCompound var3 = var2.getCompoundTag("display");
                return var3 == null ? 0xffffff : (var3.hasKey("color") ? var3.getInteger("color") : 0xffffff);
            }
        }
    }
    
    /**
     * お洗濯
     */
    @Override
    public void removeColor(ItemStack par1ItemStack) {
    	if (fragileMaterial == matWool) {
    		// 色落ち激しす
    		super.removeColor(par1ItemStack);
    	} else if (fragileMaterial == matPaper) {
    		// 紙製品は洗ったらダメだろJK
    		par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
    	}
    }
    
    /**
     * 仮想的に違う素材を返すことで描画対策をする。
     */
    @Override
    public EnumArmorMaterial getArmorMaterial() {
        return fragileMaterial > 1 ? EnumArmorMaterial.CHAIN : EnumArmorMaterial.CLOTH;
    }
    

    /**
     * 修理素材の判定
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
    	switch (fragileMaterial) {
    	case matPaper:
    		// 紙アーマー
    		if (par2ItemStack.itemID == Item.paper.itemID || par2ItemStack.getItem() instanceof ItemMapBase) {
    			return true;
    		}
    		break;
    	case matWool:
    		if (par2ItemStack.itemID == Block.cloth.blockID) {
    			return true;
    		}
    		break;
    	case matOak:
    		if (par2ItemStack.itemID == Block.planks.blockID && par2ItemStack.getItemDamage() == 0) {
    			return true;
    		}
    		break;
    	case matSpruce:
    		if (par2ItemStack.itemID == Block.planks.blockID && par2ItemStack.getItemDamage() == 1) {
    			return true;
    		}
    		break;
    	case matBirch:
    		if (par2ItemStack.itemID == Block.planks.blockID && par2ItemStack.getItemDamage() == 2) {
    			return true;
    		}
    		break;
    	case matJungle:
    		if (par2ItemStack.itemID == Block.planks.blockID && par2ItemStack.getItemDamage() == 3) {
    			return true;
    		}
    		break;
    	}
    	
    	return false;
    }


    /**
     * 1.4.2から要らなくなったか？
     */
    @Override
    public boolean requiresMultipleRenderPasses() {
    	return false;
    }

}
