package me.boops.forcefeed;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "forcefeed";
    public static final String NAME = "Force Feed";
    public static final String VERSION = "0.0.1";
    
    
    // Add a creative tab
	public static CreativeTabs tab = new CreativeTab(0, MODID);
	
	// Load the feeder
	public static Item feeder = new ItemFeeder();
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		Register(feeder);
		
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	// Register the feeders recipe
    	GameRegistry.addShapedRecipe(new ItemStack(feeder), "CRS", "ROR", "MDP",'C', Items.COOKED_CHICKEN, 'R', Items.REDSTONE, 'S', Items.COOKED_BEEF, 'O', Blocks.OBSIDIAN, 'M', Items.COOKED_MUTTON, 'D', Items.DIAMOND, 'P', Items.COOKED_PORKCHOP);
    }
    
    
    private void Register(Item item){
    	
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MODID, item.getUnlocalizedName().substring(5)),"inventory"));
    	
    	GameRegistry.register(item);
    	
    }
    
    
}
