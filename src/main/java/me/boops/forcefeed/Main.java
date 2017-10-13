package me.boops.forcefeed;

import me.boops.forcefeed.util.RegCache;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	
    public static final String MODID = "forcefeed";
    public static final String NAME = "Force Feed";
    public static final String VERSION = "1.0.0";
    
    // Add a creative tab
	public static CreativeTabs tab = new CreativeTab(0, MODID);
	
	// Load the items
	private Item FORCE_FEEDER = new ItemFeeder();
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		// Add items to be registered
		RegCache.items.add(FORCE_FEEDER);
		
		// Register item models
		ModelLoader.setCustomModelResourceLocation(FORCE_FEEDER, 0, new ModelResourceLocation(new ResourceLocation(MODID, FORCE_FEEDER.getUnlocalizedName().substring(5)),"inventory"));
		
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	
    }
}
