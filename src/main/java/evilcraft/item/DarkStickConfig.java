package evilcraft.item;

import evilcraft.Reference;
import evilcraft.core.config.extendedconfig.ItemConfig;

/**
 * Config for the {@link DarkStick}.
 * @author rubensworks
 *
 */
public class DarkStickConfig extends ItemConfig {
    
    /**
     * The unique instance.
     */
    public static DarkStickConfig _instance;

    /**
     * Make a new instance.
     */
    public DarkStickConfig() {
        super(
        	true,
            "darkStick",
            null,
            DarkStick.class
        );
    }
    
    @Override
    public String getOreDictionaryId() {
        return Reference.DICT_WOODSTICK;
    }
    
}
