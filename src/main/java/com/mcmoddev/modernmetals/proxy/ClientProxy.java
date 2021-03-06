package com.mcmoddev.modernmetals.proxy;

import com.mcmoddev.lib.client.registrations.RegistrationHelper;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.modernmetals.init.Blocks;
import com.mcmoddev.modernmetals.init.Fluids;
import com.mcmoddev.modernmetals.init.Items;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Modern Metals Client Proxy.
 *
 * @author Jasmine Iwanek
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * 
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void fluidRendering(final RegistryEvent.Register<MMDMaterial> event) {
		for (final String name : Fluids.getFluidBlockRegistry().keySet()) {
			RegistrationHelper.registerFluidRender(name);
		}
	}

	/**
	 * 
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void modelRegistry(final ModelRegistryEvent event) {
		for (final String name : Items.getItemRegistry().keySet()) {
			RegistrationHelper.registerItemRender(name);
		}

		for (final String name : Blocks.getBlockRegistry().keySet()) {
			RegistrationHelper.registerBlockRender(name);
		}
	}
}
