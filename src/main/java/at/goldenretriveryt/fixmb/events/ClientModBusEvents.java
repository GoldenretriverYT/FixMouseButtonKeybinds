package at.goldenretriveryt.fixmb.events;

import at.goldenretriveryt.fixmb.FixMBMain;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import static at.goldenretriveryt.fixmb.FixMBMain.IS_DEBUG;
import static at.goldenretriveryt.fixmb.FixMBMain.TestMapping;

@Mod.EventBusSubscriber(modid = "fixmb", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusEvents {
    @SubscribeEvent
    public static void onRegisterKeyMappingsEvent(RegisterKeyMappingsEvent event) {
        LogManager.getLogger().log(Level.INFO, "on reg keymap");
        if(IS_DEBUG) {
            event.register(TestMapping);
        }
    }
}
