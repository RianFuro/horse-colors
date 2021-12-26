package sekelsta.horse_colors.item;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

import sekelsta.horse_colors.HorseColors;

// Horse armor that has a separate texture for the 1.12 horse model used by 
// this mod and the 1.14 horse model
public class CompatibleHorseArmor extends HorseArmorItem {
    private String armorName;
    // This texture fits the 1.12 horse model used by the modded horses
    private ResourceLocation alternateTexture;

    public CompatibleHorseArmor(int armorValue, String armorName, Item.Properties builder) {
        super(armorValue, new ResourceLocation(HorseColors.MODID, "textures/entity/vanillahorse/armor/horse_armor_" + armorName + ".png"), builder);
        this.armorName = armorName;
        this.alternateTexture = new ResourceLocation(HorseColors.MODID, "textures/entity/horse/armor/horse_armor_" + armorName + ".png");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        if (ModList.get().isLoaded("familiarhorses")) {
            return getAlternateTexture();
        }
        return super.getTexture();
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getAlternateTexture() {
        return alternateTexture;
    }
}
