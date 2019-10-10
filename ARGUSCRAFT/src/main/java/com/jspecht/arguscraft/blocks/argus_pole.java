package com.jspecht.arguscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class argus_pole extends Block {
	
	public static final IntegerProperty POWER = BlockStateProperties.POWER_0_15;

	public argus_pole(Properties properties) {
		super(properties);
		this.setRegistryName("argus_pole");
		this.setDefaultState(this.stateContainer.getBaseState().with(POWER, Integer.valueOf(0)));
	}

	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(POWER, Integer.valueOf(0));
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(POWER);
	}
	
	//TODO: add tile entity to store battery level(tickable tile entity so battery level can decrease over time)

}
