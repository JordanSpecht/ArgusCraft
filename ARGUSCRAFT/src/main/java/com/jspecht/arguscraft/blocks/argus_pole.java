package com.jspecht.arguscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;

public class argus_pole extends Block{

	public argus_pole(Properties properties) {
		super(properties);
		this.setRegistryName("argus_pole");
	}

	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT;
	   }

}
