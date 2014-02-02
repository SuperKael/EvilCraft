package evilcraft.entities.monster;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import evilcraft.Reference;
import evilcraft.api.config.ElementTypeCategory;
import evilcraft.api.config.MobConfig;
import evilcraft.api.config.configurable.ConfigurableProperty;
import evilcraft.render.entity.RenderPoisonousLibelle;
import evilcraft.render.models.PoisonousLibelleModel;

public class PoisonousLibelleConfig extends MobConfig {
    
    @ConfigurableProperty(category = ElementTypeCategory.MOB, comment = "Should the Poisonous Libelle be enabled?")
    public static boolean isEnabled = true;
    
    public static PoisonousLibelleConfig _instance;

    public PoisonousLibelleConfig() {
        super(
            Reference.MOB_POISONOUSLIBELLE,
            "Poisonous Libelle",
            "poisonousLibelle",
            null,
            PoisonousLibelle.class
        );
    }
    
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
    
    @Override
    public int getBackgroundEggColor() {
        return 123456;
    }

    @Override
    public int getForegroundEggColor() {
        return 654321;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Render getRender() {
        return new RenderPoisonousLibelle(this, new PoisonousLibelleModel(), 0.5F);
    }
    
    @Override
    public void onRegistered() {
        EntityRegistry.addSpawn(PoisonousLibelle.class, 1, 0, 1, EnumCreatureType.monster, BiomeGenBase.river);
    }
    
}
