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
	
	// 紙
	public static Item helmetPaper;
	public static Item platePaper;
	public static Item legsPaper;
	public static Item bootsPaper;
	// 毛糸
	public static Item helmetWool;
	public static Item plateWool;
	public static Item legsWool;
	public static Item bootsWool;
	// 木材
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
	// バケツ
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
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("paper");
			// アイテムの追加
			helmetPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matPaper, 1, 20)).setIconCoord(0, 0).setItemName("helmetPaper");
			platePaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matPaper, 1, 40)).setIconCoord(0, 1).setItemName("chestplatePaper");
			legsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matPaper, 1, 30)).setIconCoord(0, 2).setItemName("leggingsPaper");
			bootsPaper	= (new IFA_ItemFragileArmor(ItemIDPaper - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matPaper, 1, 20)).setIconCoord(0, 3).setItemName("bootsPaper");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetPaper, "Paper Cap");
			ModLoader.addName(platePaper, "Paper Tunic");
			ModLoader.addName(legsPaper, "Paper Pants");
			ModLoader.addName(bootsPaper, "Paper Boots");
			ModLoader.addName(helmetPaper, "ja_JP", "紙の帽子");
			ModLoader.addName(platePaper, "ja_JP", "紙の上着");
			ModLoader.addName(legsPaper, "ja_JP", "紙のぱんつ");
			ModLoader.addName(bootsPaper, "ja_JP", "紙の靴");
		}
		if (ItemIDWool > 0) {
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("wool");
			// アイテムの追加
			helmetWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matWool, 2, 70)).setIconCoord(0, 0).setItemName("helmetWool");
			plateWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matWool, 2, 140)).setIconCoord(0, 1).setItemName("chestplateWool");
			legsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matWool, 2, 120)).setIconCoord(0, 2).setItemName("leggingsWool");
			bootsWool	= (new IFA_ItemFragileArmor(ItemIDWool - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matWool, 2, 70)).setIconCoord(0, 3).setItemName("bootsWool");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetWool, "Wool Cap");
			ModLoader.addName(plateWool, "Wool Tunic");
			ModLoader.addName(legsWool, "Wool Pants");
			ModLoader.addName(bootsWool, "Wool Boots");
			ModLoader.addName(helmetWool, "ja_JP", "毛糸のニットキャップ");
			ModLoader.addName(plateWool, "ja_JP", "毛糸のセーター");
			ModLoader.addName(legsWool, "ja_JP", "毛糸のズボン");
			ModLoader.addName(bootsWool, "ja_JP", "毛糸のブーツ");
		}
		// 手抜き、MOdlloader来たら変えるかも？
		if (ItemIDOak > 0) {
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("oak");
			// アイテムの追加
			helmetOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matOak, 4, 200)).setIconCoord(2, 0).setItemName("helmetOak");
			plateOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matOak, 4, 400)).setIconCoord(2, 1).setItemName("chestplateOak");
			legsOak		= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matOak, 4, 300)).setIconCoord(2, 2).setItemName("leggingsOak");
			bootsOak	= (new IFA_ItemFragileArmor(ItemIDOak - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matOak, 4, 250)).setIconCoord(2, 3).setItemName("bootsOak");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetOak, "Oak Helmet");
			ModLoader.addName(plateOak, "Oak Chestplate");
			ModLoader.addName(legsOak, "Oak Leggings");
			ModLoader.addName(bootsOak, "Oak Boots");
			ModLoader.addName(helmetOak, "ja_JP", "楢の兜鉢");
			ModLoader.addName(plateOak, "ja_JP", "楢の胴");
			ModLoader.addName(legsOak, "ja_JP", "楢の佩楯");
			ModLoader.addName(bootsOak, "ja_JP", "楢の脚絆");
		}
		if (ItemIDSpruce > 0) {
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("spruce");
			// アイテムの追加
			helmetSpruce	= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matSpruce, 4, 200)).setIconCoord(2, 0).setItemName("helmetSpruce");
			plateSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matSpruce, 4, 400)).setIconCoord(2, 1).setItemName("chestplateSpruce");
			legsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matSpruce, 4, 300)).setIconCoord(2, 2).setItemName("leggingsSpruce");
			bootsSpruce		= (new IFA_ItemFragileArmor(ItemIDSpruce - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matSpruce, 4, 250)).setIconCoord(2, 3).setItemName("bootsSpruce");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetSpruce, "Spruce Helmet");
			ModLoader.addName(plateSpruce, "Spruce Chestplate");
			ModLoader.addName(legsSpruce, "Spruce Leggings");
			ModLoader.addName(bootsSpruce, "Spruce Boots");
			ModLoader.addName(helmetSpruce, "ja_JP", "松の兜鉢");
			ModLoader.addName(plateSpruce, "ja_JP", "松の胴");
			ModLoader.addName(legsSpruce, "ja_JP", "松の佩楯");
			ModLoader.addName(bootsSpruce, "ja_JP", "松の脚絆");
		}
		if (ItemIDBirch > 0) {
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("birch");
			// アイテムの追加
			helmetBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matBirch, 4, 200)).setIconCoord(2, 0).setItemName("helmetBrich");
			plateBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matBirch, 4, 400)).setIconCoord(2, 1).setItemName("chestplateBrich");
			legsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matBirch, 4, 300)).setIconCoord(2, 2).setItemName("leggingsBrich");
			bootsBirch	= (new IFA_ItemFragileArmor(ItemIDBirch - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matBirch, 4, 250)).setIconCoord(2, 3).setItemName("bootsBrich");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetBirch, "Birch Helmet");
			ModLoader.addName(plateBirch, "Birch Chestplate");
			ModLoader.addName(legsBirch, "Birch Leggings");
			ModLoader.addName(bootsBirch, "Birch Boots");
			ModLoader.addName(helmetBirch, "ja_JP", "白樺の兜鉢");
			ModLoader.addName(plateBirch, "ja_JP", "白樺の胴");
			ModLoader.addName(legsBirch, "ja_JP", "白樺の佩楯");
			ModLoader.addName(bootsBirch, "ja_JP", "白樺の脚絆");
		}
		if (ItemIDJungle > 0) {
			// アーマーテクスチャの登録
			armorindex = !MMM_Helper.isClient ? 0 : ModLoader.addArmor("jungle");
			// アイテムの追加
			helmetJungle	= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 0, EnumArmorMaterial.CLOTH, armorindex, 0, IFA_ItemFragileArmor.matJungle, 4, 200)).setIconCoord(2, 0).setItemName("helmetJungle");
			plateJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 1, EnumArmorMaterial.CLOTH, armorindex, 1, IFA_ItemFragileArmor.matJungle, 4, 400)).setIconCoord(2, 1).setItemName("chestplateJungle");
			legsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 2, EnumArmorMaterial.CLOTH, armorindex, 2, IFA_ItemFragileArmor.matJungle, 4, 300)).setIconCoord(2, 2).setItemName("leggingsJungle");
			bootsJungle		= (new IFA_ItemFragileArmor(ItemIDJungle - 256 + 3, EnumArmorMaterial.CLOTH, armorindex, 3, IFA_ItemFragileArmor.matJungle, 4, 250)).setIconCoord(2, 3).setItemName("bootsJungle");
			// レシピの追加
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
			// 名称変換テーブルの追加
			ModLoader.addName(helmetJungle, "Jungle Helmet");
			ModLoader.addName(plateJungle, "Jungle Chestplate");
			ModLoader.addName(legsJungle, "Jungle Leggings");
			ModLoader.addName(bootsJungle, "Jungle Boots");
			ModLoader.addName(helmetJungle, "ja_JP", "加加阿の兜鉢");
			ModLoader.addName(plateJungle, "ja_JP", "加加阿の胴");
			ModLoader.addName(legsJungle, "ja_JP", "加加阿の佩楯");
			ModLoader.addName(bootsJungle, "ja_JP", "加加阿の脚絆");
		}
		
		if (ItemIDBucket > 0) {
			// かぶれるバケツ
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
		// 燃焼時間
		if (!isItemFuel || !(Item.itemsList[var1] instanceof IFA_ItemFragileArmor)) return 0;
		int ltime = 0;
		
		return ((IFA_ItemFragileArmor)Item.itemsList[var1]).getFuelTime(var2);
	}
	
}
