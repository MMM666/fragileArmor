package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class mod_IFA_fragileArmor extends BaseMod {

	// feald
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDPaper = 22210;
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDWool = 22214;
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDOak = 22218;
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDSpruce = 22222;
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDBirch = 22226;
	@MLProp(info = "ItemID +0..+3(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDJungle = 22230;
	@MLProp(info = "can use like a Fuel in Furnace.")
	public static boolean isItemFuel = true;
	@MLProp(info = "ItemID(ShiftIndex = ItemID - 256, 0 is not use.)")
	public static int ItemIDBucket = 22234;
	
	// ��
	public static Item helmetPaper;
	public static Item platePaper;
	public static Item legsPaper;
	public static Item bootsPaper;
	// �ю�
	public static Item helmetWool;
	public static Item plateWool;
	public static Item legsWool;
	public static Item bootsWool;
	// �؍�
	public static Item helmetOak;
	public static Item plateOak;
	public static Item legsOak;
	public static Item bootsOak;
	public static Item helmetSpruce;
	public static Item plateSpruce;
	public static Item legsSpruce;
	public static Item bootsSpruce;
	public static Item helmetBirch;
	public static Item plateBirch;
	public static Item legsBirch;
	public static Item bootsBirch;
	public static Item helmetJungle;
	public static Item plateJungle;
	public static Item legsJungle;
	public static Item bootsJungle;
	// �o�P�c
	public static Item bucketDamaged;



	@Override
	public String getVersion() {
		return "1.4.7-2";
	}

	@Override
	public String getName() {
		return "fragileArmor";
	}

	@Override
	public String getPriorities() {
		return "required-after:mod_MMM_MMMLib";
	}

	@Override
	public void load() {
		int armorindex;
		if (ItemIDPaper > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("paper");
			// �A�C�e���̒ǉ�
			helmetPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matPaper, 1, 20)).setIconCoord(0, 0).setItemName("helmetPaper");
			platePaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matPaper, 1, 40)).setIconCoord(0, 1).setItemName("chestplatePaper");
			legsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matPaper, 1, 30)).setIconCoord(0, 2).setItemName("leggingsPaper");
			bootsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matPaper, 1, 20)).setIconCoord(0, 3).setItemName("bootsPaper");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetPaper), new Object[] {
				"XXX", "X X", Character.valueOf('X'), Item.paper
			});
			ModLoader.addRecipe(new ItemStack(platePaper), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Item.paper
			});
			ModLoader.addRecipe(new ItemStack(legsPaper), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), Item.paper
			});
			ModLoader.addRecipe(new ItemStack(bootsPaper), new Object[] {
				"X X", "X X", Character.valueOf('X'), Item.paper
			});
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetPaper, "Paper Cap");
			ModLoader.addName(platePaper, "Paper Tunic");
			ModLoader.addName(legsPaper, "Paper Pants");
			ModLoader.addName(bootsPaper, "Paper Boots");
			ModLoader.addName(helmetPaper, "ja_JP", "���̖X�q");
			ModLoader.addName(platePaper, "ja_JP", "���̏㒅");
			ModLoader.addName(legsPaper, "ja_JP", "���̂ς��");
			ModLoader.addName(bootsPaper, "ja_JP", "���̌C");
		}
		if (ItemIDWool > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("wool");
			// �A�C�e���̒ǉ�
			helmetWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matWool, 2, 70)).setIconCoord(0, 0).setItemName("helmetWool");
			plateWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matWool, 2, 140)).setIconCoord(0, 1).setItemName("chestplateWool");
			legsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matWool, 2, 120)).setIconCoord(0, 2).setItemName("leggingsWool");
			bootsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matWool, 2, 70)).setIconCoord(0, 3).setItemName("bootsWool");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetWool), new Object[] {
				"XXX", "X X", Character.valueOf('X'), Block.cloth
			});
			IFA_ShapedRecipes.replaceLastRecipe();
			ModLoader.addRecipe(new ItemStack(plateWool), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Block.cloth
			});
			IFA_ShapedRecipes.replaceLastRecipe();
			ModLoader.addRecipe(new ItemStack(legsWool), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), Block.cloth
			});
			IFA_ShapedRecipes.replaceLastRecipe();
			ModLoader.addRecipe(new ItemStack(bootsWool), new Object[] {
				"X X", "X X", Character.valueOf('X'), Block.cloth
			});
			IFA_ShapedRecipes.replaceLastRecipe();
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetWool, "Wool Cap");
			ModLoader.addName(plateWool, "Wool Tunic");
			ModLoader.addName(legsWool, "Wool Pants");
			ModLoader.addName(bootsWool, "Wool Boots");
			ModLoader.addName(helmetWool, "ja_JP", "�ю��̃j�b�g�L���b�v");
			ModLoader.addName(plateWool, "ja_JP", "�ю��̃Z�[�^�[");
			ModLoader.addName(legsWool, "ja_JP", "�ю��̃Y�{��");
			ModLoader.addName(bootsWool, "ja_JP", "�ю��̃u�[�c");
		}
		// �蔲���AMOdlloader������ς��邩���H
		if (ItemIDOak > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("oak");
			// �A�C�e���̒ǉ�
			helmetOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matOak, 4, 200)).setIconCoord(2, 0).setItemName("helmetOak");
			plateOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matOak, 4, 400)).setIconCoord(2, 1).setItemName("chestplateOak");
			legsOak		= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matOak, 4, 300)).setIconCoord(2, 2).setItemName("leggingsOak");
			bootsOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matOak, 4, 250)).setIconCoord(2, 3).setItemName("bootsOak");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetOak), new Object[] {
				"XXX", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 0)
			});
			ModLoader.addRecipe(new ItemStack(plateOak), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.planks, 1, 0)
			});
			ModLoader.addRecipe(new ItemStack(legsOak), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 0)
			});
			ModLoader.addRecipe(new ItemStack(bootsOak), new Object[] {
				"X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 0)
			});
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetOak, "Oak Helmet");
			ModLoader.addName(plateOak, "Oak Chestplate");
			ModLoader.addName(legsOak, "Oak Leggings");
			ModLoader.addName(bootsOak, "Oak Boots");
			ModLoader.addName(helmetOak, "ja_JP", "��̊���");
			ModLoader.addName(plateOak, "ja_JP", "��̓�");
			ModLoader.addName(legsOak, "ja_JP", "��̘Ώ|");
			ModLoader.addName(bootsOak, "ja_JP", "��̋r�J");
		}
		if (ItemIDSpruce > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("spruce");
			// �A�C�e���̒ǉ�
			helmetSpruce	= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matSpruce, 4, 200)).setIconCoord(2, 0).setItemName("helmetSpruce");
			plateSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matSpruce, 4, 400)).setIconCoord(2, 1).setItemName("chestplateSpruce");
			legsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matSpruce, 4, 300)).setIconCoord(2, 2).setItemName("leggingsSpruce");
			bootsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matSpruce, 4, 250)).setIconCoord(2, 3).setItemName("bootsSpruce");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetSpruce), new Object[] {
				"XXX", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 1)
			});
			ModLoader.addRecipe(new ItemStack(plateSpruce), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.planks, 1, 1)
			});
			ModLoader.addRecipe(new ItemStack(legsSpruce), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 1)
			});
			ModLoader.addRecipe(new ItemStack(bootsSpruce), new Object[] {
				"X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 1)
			});
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetSpruce, "Spruce Helmet");
			ModLoader.addName(plateSpruce, "Spruce Chestplate");
			ModLoader.addName(legsSpruce, "Spruce Leggings");
			ModLoader.addName(bootsSpruce, "Spruce Boots");
			ModLoader.addName(helmetSpruce, "ja_JP", "���̊���");
			ModLoader.addName(plateSpruce, "ja_JP", "���̓�");
			ModLoader.addName(legsSpruce, "ja_JP", "���̘Ώ|");
			ModLoader.addName(bootsSpruce, "ja_JP", "���̋r�J");
		}
		if (ItemIDBirch > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("birch");
			// �A�C�e���̒ǉ�
			helmetBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matBirch, 4, 200)).setIconCoord(2, 0).setItemName("helmetBrich");
			plateBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matBirch, 4, 400)).setIconCoord(2, 1).setItemName("chestplateBrich");
			legsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matBirch, 4, 300)).setIconCoord(2, 2).setItemName("leggingsBrich");
			bootsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matBirch, 4, 250)).setIconCoord(2, 3).setItemName("bootsBrich");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetBirch), new Object[] {
				"XXX", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 2)
			});
			ModLoader.addRecipe(new ItemStack(plateBirch), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.planks, 1, 2)
			});
			ModLoader.addRecipe(new ItemStack(legsBirch), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 2)
			});
			ModLoader.addRecipe(new ItemStack(bootsBirch), new Object[] {
				"X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 2)
			});
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetBirch, "Birch Helmet");
			ModLoader.addName(plateBirch, "Birch Chestplate");
			ModLoader.addName(legsBirch, "Birch Leggings");
			ModLoader.addName(bootsBirch, "Birch Boots");
			ModLoader.addName(helmetBirch, "ja_JP", "�����̊���");
			ModLoader.addName(plateBirch, "ja_JP", "�����̓�");
			ModLoader.addName(legsBirch, "ja_JP", "�����̘Ώ|");
			ModLoader.addName(bootsBirch, "ja_JP", "�����̋r�J");
		}
		if (ItemIDJungle > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("jungle");
			// �A�C�e���̒ǉ�
			helmetJungle	= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matJungle, 4, 200)).setIconCoord(2, 0).setItemName("helmetJungle");
			plateJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matJungle, 4, 400)).setIconCoord(2, 1).setItemName("chestplateJungle");
			legsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matJungle, 4, 300)).setIconCoord(2, 2).setItemName("leggingsJungle");
			bootsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matJungle, 4, 250)).setIconCoord(2, 3).setItemName("bootsJungle");
			// ���V�s�̒ǉ�
			ModLoader.addRecipe(new ItemStack(helmetJungle), new Object[] {
				"XXX", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 3)
			});
			ModLoader.addRecipe(new ItemStack(plateJungle), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.planks, 1, 3)
			});
			ModLoader.addRecipe(new ItemStack(legsJungle), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 3)
			});
			ModLoader.addRecipe(new ItemStack(bootsJungle), new Object[] {
				"X X", "X X", Character.valueOf('X'), new ItemStack(Block.planks, 1, 3)
			});
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetJungle, "Jungle Helmet");
			ModLoader.addName(plateJungle, "Jungle Chestplate");
			ModLoader.addName(legsJungle, "Jungle Leggings");
			ModLoader.addName(bootsJungle, "Jungle Boots");
			ModLoader.addName(helmetJungle, "ja_JP", "�������̊���");
			ModLoader.addName(plateJungle, "ja_JP", "�������̓�");
			ModLoader.addName(legsJungle, "ja_JP", "�������̘Ώ|");
			ModLoader.addName(bootsJungle, "ja_JP", "�������̋r�J");
		}
		
		if (ItemIDBucket > 0) {
			// ���Ԃ��o�P�c
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("bucket");
			Item.itemsList[69 + 256] = null;
//			Item.itemsList[70] = null;
//			Item.itemsList[71] = null;
			bucketDamaged = (new IFA_ItemBucket(ItemIDBucket - 256, EnumArmorMaterial.IRON, armorindex, 0, Item.bucketEmpty)).setIconCoord(10, 4).setItemName("bucket").setMaxStackSize(16);
			Item.bucketEmpty = (new IFA_ItemBucket(69, EnumArmorMaterial.IRON, armorindex, 0, Item.bucketEmpty)).setIconCoord(10, 4).setItemName("bucket").setMaxStackSize(16);
//			Item.bucketWater = (new XEU_ItemBucketProxy(70, Block.waterMoving.blockID)).setIconCoord(11, 4).setItemName("bucketWater").setContainerItem(Item.bucketEmpty).setMaxDamage(Item.bucketEmpty.getMaxDamage());
//			Item.bucketLava	 = (new XEU_ItemBucketProxy(71, Block.lavaMoving.blockID)).setIconCoord(12, 4).setItemName("bucketLava").setContainerItem(Item.bucketEmpty).setMaxDamage(Item.bucketEmpty.getMaxDamage());
		}
		
	}

	@Override
	public int addFuel(int var1, int var2) {
		// �R�Ď���
		if (!isItemFuel || !(Item.itemsList[var1] instanceof IFA_ItemFragileArmor)) return 0;
		int ltime = 0;
		
		return ((IFA_ItemFragileArmor)Item.itemsList[var1]).getFuelTime(var2);
	}
	
}
