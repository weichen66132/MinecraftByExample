package minecraftbyexample.mbe30_inventory_basic;

import minecraftbyexample.GuiHandlerRegistry;
import minecraftbyexample.MinecraftByExample;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * The Startup class for this example is called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 *  See MinecraftByExample class for more information
 */
public class Startup
{
	public static Block blockInventoryBasic;  // this holds the unique instance of your block

	public static void preInitCommon()
	{
		// each instance of your block should have a name that is unique within your mod.  use lower case.
		blockInventoryBasic = new BlockInventoryBasic().setUnlocalizedName("mbe30_inventory_basic");
		GameRegistry.registerBlock(blockInventoryBasic, "mbe30_inventory_basic");
		// Each of your tile entities needs to be registered with a name that is unique to your mod.
		GameRegistry.registerTileEntity(TileEntityInventoryBasic.class, "mbe30_tile_inventory_basic");
		// you don't need to register an item corresponding to the block, GameRegistry.registerBlock does this automatically.

		// You need to register a GUIHandler for the container.  However there can be only one handler per mod, so for the purposes
		//   of this project, we create a single GuiHandlerRegistry for all examples.
		// We register this GuiHandlerRegistry with the NetworkRegistry, and then tell the GuiHandlerRegistry about
		//   each example's GuiHandler, in this case GuiHandlerMBE30, so that when it gets a request from NetworkRegistry,
		//   it passes the request on to the correct example's GuiHandler.
		NetworkRegistry.INSTANCE.registerGuiHandler(MinecraftByExample.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerMBE30(), GuiHandlerMBE30.getGuiID());
	}

	public static void preInitClientOnly()
	{
	}

	public static void initCommon()
	{
	}

	public static void initClientOnly()
	{
		Item itemBlockInventoryBasic = GameRegistry.findItem("minecraftbyexample", "mbe30_inventory_basic");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("minecraftbyexample:mbe30_inventory_basic", "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockInventoryBasic, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

	}

	public static void postInitCommon()
	{
	}

	public static void postInitClientOnly()
	{
	}

}
