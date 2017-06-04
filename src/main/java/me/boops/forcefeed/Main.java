package me.boops.forcefeed;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "forcefeed";
    public static final String NAME = "Force Feed";
    public static final String VERSION = "0.0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Add a creative tab
    	CreativeTabs tab = new CreativeTab(0, MODID);
    }
}
