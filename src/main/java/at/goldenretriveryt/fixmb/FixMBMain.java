package at.goldenretriveryt.fixmb;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.Keymap;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fixmb")
public class FixMBMain
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final boolean IS_DEBUG = false;
    public KeyMapping TestMapping = new KeyMapping("at.goldenretriveryt.testkeybind", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_P, "OK");

    public FixMBMain() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        if(IS_DEBUG) ClientRegistry.registerKeyBinding(TestMapping);
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST)
    public void onClick(InputEvent.RawMouseEvent event) {
        MinecraftForge.EVENT_BUS.post(new InputEvent.KeyInputEvent(0,0,0,0));
    }

    @SubscribeEvent
    public void onKeyDown(InputEvent.KeyInputEvent event) {
        if(IS_DEBUG) LOGGER.log(Level.INFO, event.getKey() + " " + TestMapping.isDown());
    }
}
