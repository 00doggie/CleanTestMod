package testmod.client.entity.models;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import testmod.TestMod;
import testmod.common.entity.Pterodactyl;

public class PterodactylModel extends AnimatedGeoModel<Pterodactyl> {
    @Override
    public ResourceLocation getModelLocation(Pterodactyl object) {
        return new ResourceLocation(TestMod.MOD_ID, "geo/pterodactyl.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Pterodactyl object) {
        return new ResourceLocation(TestMod.MOD_ID, "textures/entity/pterodactyl/pterodactyl.png");
    }


    @Override
    public ResourceLocation getAnimationFileLocation(Pterodactyl animatable) {
        return new ResourceLocation(TestMod.MOD_ID, "animations/pterodactyl.animation.json");
    }
}
