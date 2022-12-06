package testmod.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import testmod.TestMod;
import testmod.common.entity.Pterodactyl;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, TestMod.MOD_ID);

    public static final RegistryObject<EntityType<Pterodactyl>> PTERODACTYL =
            ENTITY_TYPES.register("pterodactyl",
                    () -> EntityType.Builder.of(Pterodactyl::new, MobCategory.MONSTER)
                            .sized(0.9f, 0.5f)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(TestMod.MOD_ID, "pterodactyl").toString()));






    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
