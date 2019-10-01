package com.jspecht.arguscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Rotation;
import net.minecraft.world.IBlockReader;

public class gateway extends Block{
	
	public gateway(Block.Properties properties) {
		super(properties);
		this.setRegistryName("gateway");
	}

	public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState();
	}

}
