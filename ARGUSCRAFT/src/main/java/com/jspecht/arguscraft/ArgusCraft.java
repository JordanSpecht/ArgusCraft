package com.jspecht.arguscraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jspecht.arguscraft.blocks.argus_pole;
import com.jspecht.arguscraft.blocks.gateway;
import com.jspecht.arguscraft.lists.BlockList;
import com.jspecht.arguscraft.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.LecternTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("arguscraft")
public class ArgusCraft {
	
	public static ArgusCraft instance;
	public static final String modid = "arguscraft";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup argus = new ArgusCraftItemGroup();
	
	public ArgusCraft() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("Client method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			event.getRegistry().registerAll(
					ItemList.battery = new Item(new Item.Properties().group(argus)).setRegistryName(location("battery")),
					ItemList.circuit = new Item(new Item.Properties().group(argus)).setRegistryName(location("circuit")),
					ItemList.antenna = new Item(new Item.Properties().group(argus)).setRegistryName(location("antenna")),
					//ItemList.solarpanel = new Item(new Item.Properties().group(argus)).setRegistryName(location("solarpanel")),
					
					//Block Items
					ItemList.argus_pole = new BlockItem(BlockList.argus_pole, new Item.Properties().group(argus)).setRegistryName("argus_pole"),
					ItemList.gateway = new BlockItem(BlockList.gateway, new Item.Properties().group(argus)).setRegistryName("gateway")
			);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			
			event.getRegistry().registerAll(
					BlockList.argus_pole = new argus_pole(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.SCAFFOLDING)),
					BlockList.gateway = new gateway(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.0f, 3.0f).lightValue(2).sound(SoundType.METAL))
					);
			
			logger.info("Blocks registered.");
		}		
		
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
