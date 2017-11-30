package com.ferreusveritas.dynamictrees.api.network;

import java.util.ArrayList;

import net.minecraft.block.Block;
import com.ferreusveritas.dynamictrees.api.backport.EnumFacing;
import com.ferreusveritas.dynamictrees.api.backport.WorldDec;
import com.ferreusveritas.dynamictrees.api.backport.BlockPos;

public class MapSignal {

	protected ArrayList<INodeInspector> nodeInspectors;

	public BlockPos root;
	public int depth;

	public EnumFacing localRootDir;

	public boolean overflow;
	public boolean found;

	public MapSignal() {
		localRootDir = null;
		nodeInspectors = new ArrayList<INodeInspector>();
	}

	public MapSignal(INodeInspector ... nis) {
		this();

		for(INodeInspector ni: nis) {
			nodeInspectors.add(ni);
		}
	}

	public boolean run(WorldDec world, Block block, BlockPos pos, EnumFacing fromDir) {
		for(INodeInspector inspector: nodeInspectors) {
			inspector.run(world, block, pos, fromDir);
		}
		return false;
	}

	public boolean returnRun(WorldDec world, Block block, BlockPos pos, EnumFacing fromDir) {
		for(INodeInspector inspector: nodeInspectors) {
			inspector.returnRun(world, block, pos, fromDir);
		}
		return false;
	}

	public ArrayList<INodeInspector> getInspectors() {
		return nodeInspectors;
	}
}
