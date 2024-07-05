// TemplateMod.java
//
// SPDX-License-Identifier: LGPL-2.1
//

package io.github.antiphysika.mods.template;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

@Mod(TemplateMod.MOD_ID)
public class TemplateMod
{
  public static final String MOD_ID = "template";

  private static final Logger LOGGER = LogUtils.getLogger();

  public TemplateMod (IEventBus bus, ModContainer container)
  {
    bus.addListener(this::commonSetup);

    NeoForge.EVENT_BUS.register(this);
  }

  private void commonSetup (final FMLCommonSetupEvent event)
  {
    LOGGER.info("{}: In commonSetup()", MOD_ID);
  }

  @SubscribeEvent
  public void onServerStarting (ServerStartingEvent event)
  {
    LOGGER.info("{}: In onServerStarting()", MOD_ID);
  }

  @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents
  {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
      LOGGER.info("{}: In onClientSetup()", MOD_ID);
    }
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :
