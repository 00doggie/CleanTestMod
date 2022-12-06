package testmod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import testmod.TestMod;
import testmod.init.custom.Ruler;
import testmod.types.ModEntityTypes;

import java.util.function.Supplier;

public class ItemInit {
    public static DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> RULER = register("ruler",
            () -> new Ruler(new Item.Properties().tab(TestMod.TEST)));

    public static final RegistryObject<Item> PTERODACTYL_SPAWN_EGG = ITEMS.register("pterodactyl_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PTERODACTYL,0xb98349, 0x9e7347,
                    new Item.Properties().tab(TestMod.TEST)));

    public static <T extends Item> RegistryObject<T> register(String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }
}
