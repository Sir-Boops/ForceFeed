package me.boops.forcefeed;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFeeder extends Item {
	
	public ItemFeeder(){
		
		// Set the tab
		this.setCreativeTab(Main.tab);
		
		// Set the names
		this.setUnlocalizedName("force_feeder");
		this.setRegistryName(Main.MODID, this.getUnlocalizedName());
		this.setMaxStackSize(1);
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(entityIn instanceof EntityPlayer){
			
			EntityPlayer player = (EntityPlayer) entityIn;
			
			if(player.getFoodStats().getFoodLevel() < 18){
				
				InventoryPlayer inv = player.inventory;
				
				boolean done = false;
				
				for (int i=0; inv.getSizeInventory()>i && !done; i++){
					
					if(inv.getStackInSlot(i).getItem() instanceof ItemFood){
						
						done = true;
						
						ItemFood food = (ItemFood) inv.getStackInSlot(i).getItem();
						int meta = inv.getStackInSlot(i).getItem().getMetadata(inv.getStackInSlot(i));
						
						player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() + food.getHealAmount(inv.getStackInSlot(i)));
						
						ItemStack newFood = new ItemStack(food);
						newFood.setCount(inv.getStackInSlot(i).getCount() - 1);
						newFood.setItemDamage(meta);
						
						inv.setInventorySlotContents(i, newFood);
						
					}
					
				}
				
			}
		}
    }
	
}
