package net.pl3x.map.plugin.data;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import it.unimi.dsi.fastutil.objects.Reference2IntMaps;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import java.util.Map;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.pl3x.map.plugin.util.Colors;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.DefaultQualifier;

@DefaultQualifier(NonNull.class)
public final class BlockColors {
    private final Reference2IntMap<Block> staticColorMap;
    private final Map<Block, DynamicColorGetter> dynamicColorMap;

    public BlockColors(final MapWorld world) {
        final Reference2IntMap<Block> staticColors = new Reference2IntOpenHashMap<>(world.advanced().COLOR_OVERRIDES_BLOCKS);
        staticColors.defaultReturnValue(-1);
        this.staticColorMap = Reference2IntMaps.unmodifiable(staticColors);
        this.dynamicColorMap = this.loadDynamicColors();
    }

    private Map<Block, DynamicColorGetter> loadDynamicColors() {
        final ImmutableMap.Builder<Block, DynamicColorGetter> dynamicColorBuilder = ImmutableMap.builder();

        dynamicColorBuilder.put(Blocks.MELON_STEM, BlockColors::melonAndPumpkinStem);
        dynamicColorBuilder.put(Blocks.PUMPKIN_STEM, BlockColors::melonAndPumpkinStem);
        dynamicColorBuilder.put(Blocks.WHEAT, BlockColors::wheat);

        return dynamicColorBuilder.build();
    }

    /**
     * Get a special color for a BlockState, if it exists. Will return -1 if there
     * is no special color for the provided IBlockData.
     *
     * @param state IBlockData to test
     * @return special color, or -1
     */
    public int getColor(final BlockState state) {
        final Block block = state.getBlock();

        final int staticColor = this.staticColorMap.getInt(block);
        if (staticColor != -1) {
            return staticColor;
        }

        final @Nullable DynamicColorGetter func = this.dynamicColorMap.get(block);
        if (func != null) {
            return func.color(state);
        }

        return -1;
    }

    private static int melonAndPumpkinStem(final BlockState state) {
        int age = state.getValue(StemBlock.AGE);
        int k = age * 32;
        int l = 255 - age * 8;
        int m = age * 4;
        return k << 16 | l << 8 | m;
    }

    private static int wheat(final BlockState state) {
        float factor = (state.getValue(CropBlock.AGE) + 1) / 8F;
        return Colors.mix(Colors.plantsMapColor(), 0xDCBB65, factor);
    }

    private interface DynamicColorGetter {
        int color(BlockState state);
    }
}
