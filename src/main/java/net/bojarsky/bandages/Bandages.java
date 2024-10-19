package net.bojarsky.bandages;

import com.mojang.logging.LogUtils;

import net.bojarsky.bandages.items.ModCreativeTabs;
import net.bojarsky.bandages.items.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

@Mod(Bandages.MOD_ID)
public class Bandages {
    public static final String MOD_ID = "bandages";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Bandages () {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Bandages.LOGGER.info("!!! BANDAGES ENABLED !!!");

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

}
