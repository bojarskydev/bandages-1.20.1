package net.bojarsky.bandages.items;

import net.bojarsky.bandages.Bandages;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Bandages.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BANDAGES_TAB = CREATIVE_MODE_TABS.register("bandages_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BANDAGE.get()))
                    .title(Component.translatable("creativetab.bandages_tab"))
                    .displayItems((pParameters, output) -> {

                        output.accept(ModItems.BANDAGE.get());
                        output.accept(ModItems.LEATHER_STRIP.get());
                        output.accept(ModItems.PINEAPPLE_LEATHER_STRIP.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}