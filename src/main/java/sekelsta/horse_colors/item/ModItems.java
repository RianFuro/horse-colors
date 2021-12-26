package sekelsta.horse_colors.item;


import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

import sekelsta.horse_colors.CreativeTab;
import sekelsta.horse_colors.HorseColors;

@Mod.EventBusSubscriber(modid = HorseColors.MODID, bus = Bus.MOD)
public class ModItems {
    public static GeneBookItem geneBookItem;
    public static GenderChangeItem genderChangeItem;
    public static CompatibleHorseArmor netheriteHorseArmor;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        geneBookItem = new GeneBookItem((new Item.Properties()).stacksTo(1));
        geneBookItem.setRegistryName("gene_book");
        ForgeRegistries.ITEMS.register(geneBookItem);

        genderChangeItem = new GenderChangeItem((new Item.Properties()).stacksTo(64).tab(CreativeTab.instance));
        genderChangeItem.setRegistryName("gender_change_item");
        ForgeRegistries.ITEMS.register(genderChangeItem);

        netheriteHorseArmor = new CompatibleHorseArmor(13, "netherite", (new Item.Properties()).stacksTo(1).tab(CreativeTab.instance).fireResistant());
        netheriteHorseArmor.setRegistryName("netherite_horse_armor");
        ForgeRegistries.ITEMS.register(netheriteHorseArmor);
        registerDispenserBehaviour();
    }

    private static void registerDispenserBehaviour() {
        DefaultDispenseItemBehavior dispenseHorseArmor = new OptionalDispenseItemBehavior() {
            /**
             * Dispense the specified stack, play the dispense sound and spawn particles.
             */
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));

                for(AbstractHorse abstracthorseentity : source.getLevel().getEntitiesOfClass(AbstractHorse.class, new AABB(blockpos), (horse) -> {
                    return horse.isAlive() && horse.canWearArmor();
                })) {
                    if (abstracthorseentity.isArmor(stack) && !abstracthorseentity.isWearingArmor() && abstracthorseentity.isTamed()) {
                        abstracthorseentity.getSlot(401).set(stack.split(1));
                        this.setSuccess(true);
                        return stack;
                    }
                }

                return super.execute(source, stack);
            }
        };
        DispenserBlock.registerBehavior(netheriteHorseArmor, dispenseHorseArmor);
    }
}
