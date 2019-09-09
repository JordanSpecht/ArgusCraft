package com.jspecht.arguscraft;

import com.jspecht.arguscraft.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArgusCraftItemGroup extends ItemGroup {
	public ArgusCraftItemGroup() {
		super("argus");
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.battery);
	}
	
}
