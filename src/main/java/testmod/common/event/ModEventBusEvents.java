package testmod.common.event;

import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import testmod.common.entity.Pterodactyl;
import testmod.types.ModEntityTypes;

@Mod.EventBusSubscriber(modid = "testmod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.PTERODACTYL.get(), Monster.createMonsterAttributes().build());



    }



}
