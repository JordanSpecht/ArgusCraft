package com.jspecht.arguscraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jspecht.arguscraft.lists.ItemList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("arguscraft")
public class ArgusCraft {
	
	public static ArgusCraft instance;
	public static final String modid = "arguscraft";
	private static final Logger logger = LogManager.getLogger(modid);
	
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
					ItemList.battery = new Item(new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(location("battery"))
			);
			
			logger.info("Items registered.");
		}
		
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
