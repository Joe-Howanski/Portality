package com.buuz135.portality.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class TileFrame extends TileBase {

    private BlockPos controllerPos;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        if (controllerPos != null) {
            compound.setInteger("X", controllerPos.getX());
            compound.setInteger("Y", controllerPos.getY());
            compound.setInteger("Z", controllerPos.getZ());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("X")) {
            controllerPos = new BlockPos(compound.getInteger("X"), compound.getInteger("Y"), compound.getInteger("Z"));
        }
    }

    public BlockPos getControllerPos() {
        return controllerPos;
    }

    public void setControllerPos(BlockPos controllerPos) {
        this.controllerPos = controllerPos;
    }
}