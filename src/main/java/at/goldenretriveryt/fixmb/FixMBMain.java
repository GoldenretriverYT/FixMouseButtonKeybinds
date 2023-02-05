package at.goldenretriveryt.fixmb;

import at.goldenretriveryt.fixmb.events.ClientModBusEvents;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fixmb")
public class FixMBMain
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final boolean IS_DEBUG = false;
    public static KeyMapping TestMapping = new KeyMapping("at.goldenretriveryt.testmapping", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_P, "key.categories.gameplay");

    public FixMBMain() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST)
    public void onClick(InputEvent.MouseButton event) {
        MinecraftForge.EVENT_BUS.post(new InputEvent.Key(0,0,0,0));
    }

    @SubscribeEvent
    public void onKeyDown(InputEvent.Key event) {
        if (IS_DEBUG) LOGGER.log(Level.INFO, event.getKey() + " " + TestMapping.isDown());
    }
}
