package mmm.fragileArmor;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(
		modid	= "fragileArmor",
		name	= "fragileArmor",
		version	= "1.7.x-srg-1"
		)
public class fragileArmor implements IFuelHandler {

	public static String[] fprefixs = {
		"paper",
		"wool",
		"oak",
		"spruce",
		"birch",
		"jungle"
	};
	public static String[][] fnames = {
		{"helmetPaper",		"chestplatePaper",	"leggingsPaper",	"bootsPaper"},
		{"helmetWool",		"chestplateWool",	"leggingsWool",		"bootsWool"},
		{"helmetOak",		"chestplateOak",	"leggingsOak",		"bootsOak"},
		{"helmetSpruce",	"chestplateSpruce",	"leggingsSpruce",	"bootsSpruce"},
		{"helmetBirch",		"chestplateBirch",	"leggingsBirch",	"bootsBirch"},
		{"helmetJungle",	"chestplateJungle",	"leggingsJungle",	"bootsJungle"}
	};
	public static EnumArmorMaterial[] fmaterials = {
		EnumArmorMaterial.PAPER,
		EnumArmorMaterial.WOOL,
		EnumArmorMaterial.OAK,
		EnumArmorMaterial.SPRUCE,
		EnumArmorMaterial.BIRCH,
		EnumArmorMaterial.JUNGLE
	};
	public static int[][] ffueltimes = {
		{20, 40, 30, 20},
		{70, 140, 120, 70},
		{200, 400, 300, 250},
		{200, 400, 300, 250},
		{200, 400, 300, 250},
		{200, 400, 300, 250}
	};
	
	// props
	public static boolean isDebugMessage = true;
	
	public static boolean isItemFuel = true;
	public static boolean isBucketHelmet = true;
	public static boolean isPaper = true;
	public static boolean isWool = true;
	public static boolean isWood = true;
	
	
	// 紙
	public static ArmorMaterial materialPaper;
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
	public static Item bucket;


	public static void Debug(String pText, Object... pData) {
		// デバッグメッセージ
		if (isDebugMessage) {
			System.out.println(String.format("fragileArmor-" + pText, pData));
		}
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent pEvent) {
		int armorindex;
		if (isPaper) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("paper");
			// アイテムの追加
			helmetPaper	= (new ItemFragileArmor(EnumArmorMaterial.PAPER, armorindex, 0, 20)).setUnlocalizedName("helmetPaper").setTextureName("helmetPaper");
			platePaper	= (new ItemFragileArmor(EnumArmorMaterial.PAPER, armorindex, 1, 40)).setUnlocalizedName("chestplatePaper").setTextureName("chestplatePaper");
			legsPaper	= (new ItemFragileArmor(EnumArmorMaterial.PAPER, armorindex, 2, 30)).setUnlocalizedName("leggingsPaper").setTextureName("leggingsPaper");
			bootsPaper	= (new ItemFragileArmor(EnumArmorMaterial.PAPER, armorindex, 3, 20)).setUnlocalizedName("bootsPaper").setTextureName("bootsPaper");
			GameRegistry.registerItem(helmetPaper, "helmetPaper");
			GameRegistry.registerItem(platePaper, "chestplatePaper");
			GameRegistry.registerItem(legsPaper, "leggingsPaper");
			GameRegistry.registerItem(bootsPaper, "bootsPaper");
		}
		if (isWool) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("wool");
			// アイテムの追加
			helmetWool	= (new ItemFragileArmor(EnumArmorMaterial.WOOL, armorindex, 0,  70)).setUnlocalizedName("helmetWool").setTextureName("helmetWool");
			plateWool	= (new ItemFragileArmor(EnumArmorMaterial.WOOL, armorindex, 1, 140)).setUnlocalizedName("chestplateWool").setTextureName("chestplateWool");
			legsWool	= (new ItemFragileArmor(EnumArmorMaterial.WOOL, armorindex, 2, 120)).setUnlocalizedName("leggingsWool").setTextureName("leggingsWool");
			bootsWool	= (new ItemFragileArmor(EnumArmorMaterial.WOOL, armorindex, 3,  70)).setUnlocalizedName("bootsWool").setTextureName("bootsWool");
			GameRegistry.registerItem(helmetWool, "helmetWool");
			GameRegistry.registerItem(plateWool, "chestplateWool");
			GameRegistry.registerItem(legsWool, "leggingsWool");
			GameRegistry.registerItem(bootsWool, "bootsWool");
		}
		// 手抜き、MOdlloader来たら変えるかも？
		if (isWood) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("oak");
			// アイテムの追加
			helmetOak	= (new ItemFragileArmor(EnumArmorMaterial.OAK, armorindex, 0, 200)).setUnlocalizedName("helmetOak").setTextureName("helmetOak");
			plateOak	= (new ItemFragileArmor(EnumArmorMaterial.OAK, armorindex, 1, 400)).setUnlocalizedName("chestplateOak").setTextureName("chestplateOak");
			legsOak		= (new ItemFragileArmor(EnumArmorMaterial.OAK, armorindex, 2, 300)).setUnlocalizedName("leggingsOak").setTextureName("leggingsOak");
			bootsOak	= (new ItemFragileArmor(EnumArmorMaterial.OAK, armorindex, 3, 250)).setUnlocalizedName("bootsOak").setTextureName("bootsOak");
		}
		if (isWood) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("spruce");
			// アイテムの追加
			helmetSpruce	= (new ItemFragileArmor(EnumArmorMaterial.SPRUCE, armorindex, 0, 200)).setUnlocalizedName("helmetSpruce").setTextureName("helmetSpruce");
			plateSpruce		= (new ItemFragileArmor(EnumArmorMaterial.SPRUCE, armorindex, 1, 400)).setUnlocalizedName("chestplateSpruce").setTextureName("chestplateSpruce");
			legsSpruce		= (new ItemFragileArmor(EnumArmorMaterial.SPRUCE, armorindex, 2, 300)).setUnlocalizedName("leggingsSpruce").setTextureName("leggingsSpruce");
			bootsSpruce		= (new ItemFragileArmor(EnumArmorMaterial.SPRUCE, armorindex, 3, 250)).setUnlocalizedName("bootsSpruce").setTextureName("bootsSpruce");
		}
		if (isWood) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("birch");
			// アイテムの追加
			helmetBirch	= (new ItemFragileArmor(EnumArmorMaterial.BIRCH, armorindex, 0, 200)).setUnlocalizedName("helmetBirch").setTextureName("helmetBirch");
			plateBirch	= (new ItemFragileArmor(EnumArmorMaterial.BIRCH, armorindex, 1, 400)).setUnlocalizedName("chestplateBirch").setTextureName("chestplateBirch");
			legsBirch	= (new ItemFragileArmor(EnumArmorMaterial.BIRCH, armorindex, 2, 300)).setUnlocalizedName("leggingsBirch").setTextureName("leggingsBirch");
			bootsBirch	= (new ItemFragileArmor(EnumArmorMaterial.BIRCH, armorindex, 3, 250)).setUnlocalizedName("bootsBirch").setTextureName("bootsBirch");
			addRecipes(new ItemStack(Blocks.planks, 1, 2), helmetBirch, plateBirch, legsBirch, bootsBirch);
			// 名称変換テーブルの追加
		}
		if (isWood) {
			// アーマーテクスチャの登録
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("jungle");
			// アイテムの追加
			helmetJungle	= (new ItemFragileArmor(EnumArmorMaterial.JUNGLE, armorindex, 0, 200)).setUnlocalizedName("helmetJungle").setTextureName("helmetJungle");
			plateJungle		= (new ItemFragileArmor(EnumArmorMaterial.JUNGLE, armorindex, 1, 400)).setUnlocalizedName("chestplateJungle").setTextureName("chestplateJungle");
			legsJungle		= (new ItemFragileArmor(EnumArmorMaterial.JUNGLE, armorindex, 2, 300)).setUnlocalizedName("leggingsJungle").setTextureName("leggingsJungle");
			bootsJungle		= (new ItemFragileArmor(EnumArmorMaterial.JUNGLE, armorindex, 3, 250)).setUnlocalizedName("bootsJungle").setTextureName("bootsJungle");
		}
		GameRegistry.registerFuelHandler(this);
		
		if (isBucketHelmet) {
			// かぶれるバケツ
			armorindex = RenderingRegistry.addNewArmourRendererPrefix("bucket");
			bucket = (new ItemBucketReplace(Blocks.air)).setUnlocalizedName("bucket").setMaxStackSize(16).setTextureName("bucket_empty");
			bucketDamaged = (new ItemBucketHelm(ArmorMaterial.IRON, armorindex, 0)).setUnlocalizedName("bucketHelm").setTextureName("bucket_empty");
			GameRegistry.registerItem(bucket, "bucket");
			GameRegistry.registerItem(bucketDamaged, "bucketHelm");
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent pEvent) {
		// レシピの追加
		if (isPaper) {
			addRecipes(Items.paper, helmetPaper, platePaper, legsPaper, bootsPaper);
		}
		if (isWool) {
			addRecipes(Blocks.wool, helmetWool, plateWool, legsWool, bootsWool);
		}
		if (isWood) {
			addRecipes(new ItemStack(Blocks.planks, 1, 0), helmetOak, plateOak, legsOak, bootsOak);
		}
		if (isWood) {
			addRecipes(new ItemStack(Blocks.planks, 1, 1), helmetSpruce, plateSpruce, legsSpruce, bootsSpruce);
		}
		if (isWood) {
			addRecipes(new ItemStack(Blocks.planks, 1, 2), helmetBirch, plateBirch, legsBirch, bootsBirch);
		}
		if (isWood) {
			addRecipes(new ItemStack(Blocks.planks, 1, 3), helmetJungle, plateJungle, legsJungle, bootsJungle);
		}
	}

	public void addRecipes(Object pMaterial, Item pHelmet, Item pPlate, Item pLegs, Item pBoots) {
		// レシピの追加
		ShapedRecipes.addRecipes(new ItemStack(pHelmet), new Object[] {
			"XXX", "X X", Character.valueOf('X'), pMaterial
		});
		ShapedRecipes.addRecipes(new ItemStack(pPlate), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), pMaterial
		});
		ShapedRecipes.addRecipes(new ItemStack(pLegs), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), pMaterial
		});
		ShapedRecipes.addRecipes(new ItemStack(pBoots), new Object[] {
			"X X", "X X", Character.valueOf('X'), pMaterial
		});
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		// 燃焼時間
		int ltime = 0;
		if (!isItemFuel || !(fuel.getItem() instanceof ItemFragileArmor)) {
			ltime = ((ItemFragileArmor)fuel.getItem()).getFuelTime(fuel.getItemDamage());
		}
		return ltime;
	}

}
