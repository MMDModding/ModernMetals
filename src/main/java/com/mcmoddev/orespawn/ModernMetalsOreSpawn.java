package com.mcmoddev.orespawn;

import com.google.common.base.Function;
import com.mcmoddev.modernmetals.init.Blocks;
import com.mcmoddev.modernmetals.init.Materials;
import com.mcmoddev.orespawn.api.OreSpawnAPI;
import com.mcmoddev.orespawn.api.SpawnLogic;

public class ModernMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {
		SpawnLogic logic = api.createSpawnLogic();


		logic.getDimension(-1)
				.addOre(Materials.coldiron.ore.getDefaultState(), 8, 4, 5, 0, 128)
				.addOre(Materials.adamantine.ore.getDefaultState(), 8, 4, 2, 0, 128);

		logic.getDimension(OreSpawnAPI.DIMENSION_WILDCARD)
				.addOre(Materials.copper.ore.getDefaultState(), 8, 4, 10, 0,  96)
				.addOre(Materials.silver.ore.getDefaultState(), 8, 4,  4, 0,  32)
				.addOre(Materials.tin.ore.getDefaultState(), 8, 4, 10, 0, 128)
				.addOre(Materials.lead.ore.getDefaultState(), 8, 4, 5, 0, 64)
				.addOre(Materials.zinc.ore.getDefaultState(), 8, 4, 5, 0, 96)
//				.addOre(Materials.mercury.ore.getDefaultState(), 8, 4, 3, 0, 32)
				.addOre(Materials.nickel.ore.getDefaultState(), 8, 4, 1, 32, 96);
//				.addOre(Materials.platinum.ore.getDefaultState(), 8, 4, 0.125f, 1, 32); // Currently broken

		logic.getDimension(1)
				.addOre(Blocks.starsteel_ore.getDefaultState(), 8, 4, 5, 0, 255);

		return logic;
	}
}
