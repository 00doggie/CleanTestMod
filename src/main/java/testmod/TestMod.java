package testmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import testmod.init.ItemInit;
import testmod.networks.ModMessages;
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
    }
}
