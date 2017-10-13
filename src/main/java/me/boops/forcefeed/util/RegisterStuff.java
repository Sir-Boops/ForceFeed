package me.boops.forcefeed.util;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegisterStuff {
	
    @SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	for(int i = 0; i < RegCache.items.size(); i++) {
    		
    		event.getRegistry().register(RegCache.items.get(i));
    		
    	}
	}
}
