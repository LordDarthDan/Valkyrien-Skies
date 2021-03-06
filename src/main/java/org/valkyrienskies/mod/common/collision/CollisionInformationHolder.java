package org.valkyrienskies.mod.common.collision;

import net.minecraft.block.state.IBlockState;

public class CollisionInformationHolder {

    protected final int inWorldX, inWorldY, inWorldZ, inLocalX, inLocalY, inLocalZ;
    protected final IBlockState inWorldState, inLocalState;

    public CollisionInformationHolder(int inWorldX, int inWorldY,
        int inWorldZ, int inLocalX, int inLocalY, int inLocalZ, IBlockState inWorldState,
        IBlockState inLocalState) {

        this.inWorldX = inWorldX;
        this.inWorldY = inWorldY;
        this.inWorldZ = inWorldZ;

        this.inLocalX = inLocalX;
        this.inLocalY = inLocalY;
        this.inLocalZ = inLocalZ;

        this.inWorldState = inWorldState;
        this.inLocalState = inLocalState;
    }
}
