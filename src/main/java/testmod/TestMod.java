package testmod;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import testmod.client.entity.renderer.PterodactylRenderer;
import testmod.common.entity.Pterodactyl;
import testmod.init.ItemInit;
import testmod.networks.ModMessages;
import testmod.types.ModEntityTypes;
import testmod.util.MenuUtil;

@Mod("testmod")
public class TestMod {

    public static String MOD_ID = "testmod";

    public static CreativeModeTab TEST = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.RULER.get());
        }
    };

    public TestMod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(bus);
        MenuUtil.MENUS.register(bus);
        ModMessages.register();
        ModEntityTypes.register(bus);
        GeckoLib.initialize();

        bus.addListener(TestMod::clientSetup);
    }
    private static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.PTERODACTYL.get(), PterodactylRenderer::new);
    }
}
