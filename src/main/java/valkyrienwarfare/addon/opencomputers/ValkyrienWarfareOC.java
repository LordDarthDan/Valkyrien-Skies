/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2015-2018 the Valkyrien Warfare team
 *
 * Permission is hereby granted to any persons and/or organizations using this software to copy, modify, merge, publish, and distribute it.
 * Said persons and/or organizations are not allowed to use the software or any derivatives of the work for commercial use or any other means to generate income unless it is to be used as a part of a larger project (IE: "modpacks"), nor are they allowed to claim this software as their own.
 *
 * The persons and/or organizations are also disallowed from sub-licensing and/or trademarking this software without explicit permission from the Valkyrien Warfare team.
 *
 * Any persons and/or organizations using this software must disclose their source code and have it publicly available, include this license, provide sufficient credit to the original authors of the project (IE: The Valkyrien Warfare team), as well as provide a link to the original project.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package valkyrienwarfare.addon.opencomputers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import valkyrienwarfare.addon.opencomputers.block.GPSBlock;
import valkyrienwarfare.addon.opencomputers.tileentity.GPSTileEntity;
import valkyrienwarfare.api.addons.Module;
import valkyrienwarfare.mod.common.ValkyrienWarfareMod;

@Mod(
        name = ValkyrienWarfareOC.MOD_NAME,
        modid = ValkyrienWarfareOC.MOD_ID,
        version = ValkyrienWarfareOC.MOD_VERSION,
        dependencies = "required-after:" + ValkyrienWarfareMod.MOD_ID
)
public class ValkyrienWarfareOC {
    static final String MOD_ID = "vs_open_computers";
    static final String MOD_NAME = "Valkyrien Skies Open Computers";
    static final String MOD_VERSION = ValkyrienWarfareMod.MOD_VERSION;

    @Instance(MOD_ID)
    public static ValkyrienWarfareOC INSTANCE = new ValkyrienWarfareOC();
    public Block gpsBlock;

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        gpsBlock = new GPSBlock().setTranslationKey("gpsblock")
                .setRegistryName(MOD_ID, "gpsblock")
                .setCreativeTab(ValkyrienWarfareMod.vwTab);

        event.getRegistry().register(gpsBlock);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        Module.registerItemBlock(event, gpsBlock);
    }

    @SubscribeEvent
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(GPSTileEntity.class, "tilegps");
    }
}
