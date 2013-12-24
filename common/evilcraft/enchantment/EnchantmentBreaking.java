package evilcraft.enchantment;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import evilcraft.EvilCraft;
import evilcraft.api.config.ConfigurableEnchantment;
import evilcraft.api.config.ExtendedConfig;
import evilcraft.blocks.BloodyCobblestone;

public class EnchantmentBreaking extends ConfigurableEnchantment {
    
    private static EnchantmentBreaking _instance = null;
    
    public static void initInstance(ExtendedConfig eConfig) {
        if(_instance == null)
            _instance = new EnchantmentBreaking(eConfig);
        else EvilCraft.log("If you see this, something went horribly wrong while registring stuff!");
    }
    
    public static EnchantmentBreaking getInstance() {
        return _instance;
    }

    private EnchantmentBreaking(ExtendedConfig eConfig) {
        super(eConfig, 1, EnumEnchantmentType.all);
    }
    
    public int getMinEnchantability(int level) {
        return 5 + (level - 1) * 8;
    }
    
    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 50;
    }
    
    public int getMaxLevel() {
        return 3;
    }
    
    public boolean canApply(ItemStack par1ItemStack)
    {
        return par1ItemStack.isItemStackDamageable() ? true : super.canApply(par1ItemStack);
    }
    
    /**
     * Used by ItemStack.attemptDamageItem. Randomly determines if a point of damage should be amplified using the
     * enchantment level. If the ItemStack is Armor then there is a flat 60% chance for damage to be amplified no
     * matter the enchantment level, otherwise there is a 1-(level/1) chance for damage to be amplified.
     */
    public static boolean amplifyDamage(ItemStack itemStack, int level, Random random)
    {
        return itemStack.getItem() instanceof ItemArmor && random.nextFloat() < 0.6F ? false : random.nextInt(level + 1) > 0;
    }

}