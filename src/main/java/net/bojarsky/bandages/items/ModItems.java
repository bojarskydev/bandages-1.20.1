package net.bojarsky.bandages.items;

import net.bojarsky.bandages.Bandages;

import net.minecraft.world.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bandages.MOD_ID);

    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage",
            () -> new ItemBandage());
    public static final RegistryObject<Item> LEATHER_STRIP = ITEMS.register("leather_strip",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_LEATHER_STRIP = ITEMS.register("pineapple_leather_strip",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIN1 = ITEMS.register("coin1",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIN10 = ITEMS.register("coin10",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIN100 = ITEMS.register("coin100",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}