package com.simibubi.create.content.logistics.block.extractor;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraftforge.client.model.generators.ModelFile;

public class VerticalExtractorGenerator extends SpecialBlockStateGen {

	private boolean linked;

	public VerticalExtractorGenerator(boolean linked) {
		this.linked = linked;
	}

	@Override
	protected int getXRotation(BlockState state) {
		return state.get(ExtractorBlock.Vertical.UPWARD) ? 180 : 0;
	}

	@Override
	protected int getYRotation(BlockState state) {
		return (state.get(ExtractorBlock.UPWARD) ? 0 : 180) + horizontalAngle(state.get(ExtractorBlock.HORIZONTAL_FACING));
	}

	@Override
	public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov,
		BlockState state) {
		return AssetLookup.forPowered(ctx, prov, "extractor/vertical" + (linked ? "_linked" : ""))
			.apply(state);
	}

}
