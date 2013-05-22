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
		return "1.5.2-2";
	}

	@Override
	public String getName() {
		return "fragileArmor";
	}

	@Override
	public void load() {
		int armorindex;
		boolean isClient = false;
		try {
			isClient = ModLoader.getMinecraftInstance() != null;
		} catch (Exception e) {
		} catch (Error e) {
		}
		if (ItemIDPaper > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !isClient ? 0 : ModLoader.addArmor("paper");
			// �A�C�e���̒ǉ�
			helmetPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 0, IFA_EnumArmorMaterial.PAPER, armorindex, 0, 20)).setUnlocalizedName("helmetPaper");
			platePaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 1, IFA_EnumArmorMaterial.PAPER, armorindex, 1, 40)).setUnlocalizedName("chestplatePaper");
			legsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 2, IFA_EnumArmorMaterial.PAPER, armorindex, 2, 30)).setUnlocalizedName("leggingsPaper");
			bootsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 3, IFA_EnumArmorMaterial.PAPER, armorindex, 3, 20)).setUnlocalizedName("bootsPaper");
			// ���V�s�̒ǉ�
			addRecipes(Item.paper, helmetPaper, platePaper, legsPaper, bootsPaper, false);
			// ���̕ϊ��e�[�u���̒ǉ�
			ModLoader.addName(helmetPaper, "Paper Helm");
			ModLoader.addName(platePaper, "Paper Armor");
			ModLoader.addName(legsPaper, "Paper Pants");
			ModLoader.addName(bootsPaper, "Paper Sandal");
			ModLoader.addName(helmetPaper, "ja_JP", "���̂��Ԃ�");
			ModLoader.addName(platePaper, "ja_JP", "���̂�낢");
			ModLoader.addName(legsPaper, "ja_JP", "���̂ς��");
			ModLoader.addName(bootsPaper, "ja_JP", "���̂�炶");
		}
		if (ItemIDWool > 0) {
			// �A�[�}�[�e�N�X�`���̓o�^
			armorindex = !isClient ? 0 : ModLoader.addArmor("wool");
			// �A�C�e���̒ǉ�
			helmetWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 0, IFA_EnumArmorMaterial.WOOL, armorindex, 0,  70)).setUnlocalizedName("helmetWool");
			plateWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 1, IFA_EnumArmorMaterial.WOOL, armorindex, 1, 140)).setUnlocalizedName("chestplateWool");
			legsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 2, IFA_EnumArmorMaterial.WOOL, armorindex, 2, 120)).setUnlocalizedName("leggingsWool");
			bootsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 3, IFA_EnumArmorMaterial.WOOL, armorindex, 3,  70)).setUnlocalizedName("bootsWool");
			// ���V�s�̒ǉ�
			addRecipes(Block.cloth, helmetWool, plateWool, legsWool, bootsWool, true);
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
			armorindex = !isClient ? 0 : ModLoader.addArmor("oak");
			// �A�C�e���̒ǉ�
			helmetOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 0, IFA_EnumArmorMaterial.OAK, armorindex, 0, 200)).setUnlocalizedName("helmetOak");
			plateOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 1, IFA_EnumArmorMaterial.OAK, armorindex, 1, 400)).setUnlocalizedName("chestplateOak");
			legsOak		= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 2, IFA_EnumArmorMaterial.OAK, armorindex, 2, 300)).setUnlocalizedName("leggingsOak");
			bootsOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 3, IFA_EnumArmorMaterial.OAK, armorindex, 3, 250)).setUnlocalizedName("bootsOak");
			// ���V�s�̒ǉ�
			addRecipes(new ItemStack(Block.planks, 1, 0), helmetOak, plateOak, legsOak, bootsOak, false);
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
			armorindex = !isClient ? 0 : ModLoader.addArmor("spruce");
			// �A�C�e���̒ǉ�
			helmetSpruce	= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 0, IFA_EnumArmorMaterial.SPRUCE, armorindex, 0, 200)).setUnlocalizedName("helmetSpruce");
			plateSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 1, IFA_EnumArmorMaterial.SPRUCE, armorindex, 1, 400)).setUnlocalizedName("chestplateSpruce");
			legsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 2, IFA_EnumArmorMaterial.SPRUCE, armorindex, 2, 300)).setUnlocalizedName("leggingsSpruce");
			bootsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 3, IFA_EnumArmorMaterial.SPRUCE, armorindex, 3, 250)).setUnlocalizedName("bootsSpruce");
			// ���V�s�̒ǉ�
			addRecipes(new ItemStack(Block.planks, 1, 1), helmetSpruce, plateSpruce, legsSpruce, bootsSpruce, false);
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
			armorindex = !isClient ? 0 : ModLoader.addArmor("birch");
			// �A�C�e���̒ǉ�
			helmetBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 0, IFA_EnumArmorMaterial.BIRCH, armorindex, 0, 200)).setUnlocalizedName("helmetBirch");
			plateBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 1, IFA_EnumArmorMaterial.BIRCH, armorindex, 1, 400)).setUnlocalizedName("chestplateBirch");
			legsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 2, IFA_EnumArmorMaterial.BIRCH, armorindex, 2, 300)).setUnlocalizedName("leggingsBirch");
			bootsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 3, IFA_EnumArmorMaterial.BIRCH, armorindex, 3, 250)).setUnlocalizedName("bootsBirch");
			// ���V�s�̒ǉ�
			addRecipes(new ItemStack(Block.planks, 1, 2), helmetBirch, plateBirch, legsBirch, bootsBirch, false);
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
			armorindex = !isClient ? 0 : ModLoader.addArmor("jungle");
			// �A�C�e���̒ǉ�
			helmetJungle	= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 0, IFA_EnumArmorMaterial.JUNGLE, armorindex, 0, 200)).setUnlocalizedName("helmetJungle");
			plateJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 1, IFA_EnumArmorMaterial.JUNGLE, armorindex, 1, 400)).setUnlocalizedName("chestplateJungle");
			legsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 2, IFA_EnumArmorMaterial.JUNGLE, armorindex, 2, 300)).setUnlocalizedName("leggingsJungle");
			bootsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 3, IFA_EnumArmorMaterial.JUNGLE, armorindex, 3, 250)).setUnlocalizedName("bootsJungle");
			// ���V�s�̒ǉ�
			addRecipes(new ItemStack(Block.planks, 1, 3), helmetJungle, plateJungle, legsJungle, bootsJungle, false);
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
			armorindex = !isClient ? 0 : ModLoader.addArmor("bucket");
			Item.itemsList[69 + 256] = null;
//			Item.itemsList[70] = null;
//			Item.itemsList[71] = null;
			bucketDamaged = (new IFA_ItemBucket(ItemIDBucket - 256, EnumArmorMaterial.IRON, armorindex, 0, Item.bucketEmpty)).setUnlocalizedName("bucket").setMaxStackSize(16);
			Item.bucketEmpty = (new IFA_ItemBucket(69, EnumArmorMaterial.IRON, armorindex, 0, Item.bucketEmpty)).setUnlocalizedName("bucket").setMaxStackSize(16);
			Item.bucketWater.setContainerItem(Item.bucketEmpty);
			Item.bucketLava.setContainerItem(Item.bucketEmpty);
//			Item.bucketWater = (new XEU_ItemBucketProxy(70, Block.waterMoving.blockID)).setIconCoord(11, 4).setItemName("bucketWater").setContainerItem(Item.bucketEmpty).setMaxDamage(Item.bucketEmpty.getMaxDamage());
//			Item.bucketLava	 = (new XEU_ItemBucketProxy(71, Block.lavaMoving.blockID)).setIconCoord(12, 4).setItemName("bucketLava").setContainerItem(Item.bucketEmpty).setMaxDamage(Item.bucketEmpty.getMaxDamage());
		}
	}

	public void addRecipes(Object pMaterial, Item pHelmet, Item pPlate, Item pLegs, Item pBoots, boolean pReplace) {
		// ���V�s�̒ǉ�
		ModLoader.addRecipe(new ItemStack(pHelmet), new Object[] {
			"XXX", "X X", Character.valueOf('X'), pMaterial
		});
		if (pReplace) IFA_ShapedRecipes.replaceLastRecipe();
		ModLoader.addRecipe(new ItemStack(pPlate), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), pMaterial
		});
		if (pReplace) IFA_ShapedRecipes.replaceLastRecipe();
		ModLoader.addRecipe(new ItemStack(pLegs), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), pMaterial
		});
		if (pReplace) IFA_ShapedRecipes.replaceLastRecipe();
		ModLoader.addRecipe(new ItemStack(pBoots), new Object[] {
			"X X", "X X", Character.valueOf('X'), pMaterial
		});
		if (pReplace) IFA_ShapedRecipes.replaceLastRecipe();
	}

	@Override
	public int addFuel(int var1, int var2) {
		// �R�Ď���
		if (!isItemFuel || !(Item.itemsList[var1] instanceof IFA_ItemFragileArmor)) return 0;
		int ltime = 0;
		
		return ((IFA_ItemFragileArmor)Item.itemsList[var1]).getFuelTime(var2);
	}
	
}
