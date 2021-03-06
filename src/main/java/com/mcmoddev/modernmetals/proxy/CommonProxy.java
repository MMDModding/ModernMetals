package com.mcmoddev.modernmetals.proxy;

import java.util.HashSet;

import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.oregen.FallbackGenerator;
import com.mcmoddev.lib.util.Config.Options;
import com.mcmoddev.modernmetals.data.MaterialNames;
import com.mcmoddev.modernmetals.init.ItemGroups;
import com.mcmoddev.modernmetals.init.Recipes;
import com.mcmoddev.modernmetals.init.VillagerTrades;
import com.mcmoddev.modernmetals.util.MMeConfig;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

/**
 * Modern Metals Common Proxy.
 *
 * @author Jasmine Iwanek
 *
 */
public class CommonProxy {

	/**
	 * 
	 * @param event The Event.
	 */
	@SuppressWarnings("deprecation")
	public void preInit(final FMLPreInitializationEvent event) {

		if ((Options.requireMMDOreSpawn()) && (!Loader.isModLoaded(SharedStrings.ORESPAWN_MODID))) {
			if (Options.fallbackOrespawn()) {
				GameRegistry.registerWorldGenerator(new FallbackGenerator(), 0);
			} else {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion(SharedStrings.ORESPAWN_VERSION));
				throw new MissingModsException(orespawnMod, SharedStrings.ORESPAWN_MODID,
						SharedStrings.ORESPAWN_MISSING_TEXT);
			}
		}

		VillagerTrades.init();
	}

	/**
	 * 
	 * @param event The Event.
	 */
	public void init(final FMLInitializationEvent event) {
		Recipes.init();

		ItemGroups.setupIcons(MaterialNames.ALUMINUM);
	}

	/**
	 * 
	 * @param event The Event.
	 */
	public void postInit(FMLPostInitializationEvent event) {
		MMeConfig.postInit();
	}
}
