package uk.enchantedoasis.eoitems.world.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.enchantedoasis.eoitems.blocks.Blocks;

import java.util.Random;

public class OreGenEventHandler {

    public static int diamondSize = 8;
    public static int diamondCount = 1;
    public static int diamondMinHeight;
    public static int diamondMaxHeight = 16;
    public static WorldGenMinable currencyGen = new WorldGenMinable(Blocks.BlockCurrency.getDefaultState(), diamondSize);


    @SubscribeEvent
    public static void onGenerateMinable(OreGenEvent.GenerateMinable event)
    {
        if (event.getType() == OreGenEvent.GenerateMinable.EventType.DIAMOND){
            genStandardOre1(event.getWorld(), event.getRand(), diamondCount, currencyGen, diamondMinHeight, diamondMaxHeight, event.getPos());
        }
    }

    protected static void genStandardOre1(World worldIn, Random random, int blockCount, WorldGenerator generator, int minHeight, int maxHeight, BlockPos pos)
    {
        if (maxHeight < minHeight)
        {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        }
        else if (maxHeight == minHeight)
        {
            if (minHeight < 255)
            {
                ++maxHeight;
            }
            else
            {
                --minHeight;
            }
        }

        for (int j = 0; j < blockCount; ++j)
        {
            BlockPos blockpos = pos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16));
            generator.generate(worldIn, random, blockpos);
        }
    }

}
