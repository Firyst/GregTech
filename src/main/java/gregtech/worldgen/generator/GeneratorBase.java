package gregtech.worldgen.generator;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

public abstract class GeneratorBase<T extends GeneratorSettings> implements WorldGenerator {

    protected final T settings;

    protected GeneratorBase(@NotNull T settings) {
        this.settings = settings;
    }

    /**
     * @param dimension the dimension to check
     * @return if the vein can generate in the dimension
     */
    public boolean canGenerateInDimension(int dimension) {
        int[] arr = settings.allowedDimensions();
        if (arr.length == 0) return true;
        return ArrayUtils.contains(arr, dimension);
    }

    /**
     * @param biome the biome to check
     * @return if the vein can generate in the biome
     */
    public boolean canGenerateInBiome(@NotNull String biome) {
        String[] arr = settings.allowedBiomes();
        if (arr.length == 0) return true;
        return ArrayUtils.contains(arr, biome);
    }
}
