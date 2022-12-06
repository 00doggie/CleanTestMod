package testmod.networks.packets;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import testmod.client.screen.RulerScreen;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class PlayerDistancePacket {

    public static String name = RulerScreen.playerName;
    private UUID playerName = UUID.fromString(name);



    public PlayerDistancePacket(FriendlyByteBuf buf) {
        this.playerName = buf.readUUID();

    }

    public PlayerDistancePacket() {

    }

    public void toBytes(FriendlyByteBuf buf) {
    buf.writeUUID(this.playerName);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel serverLevel = player.getLevel();
            serverLevel.getPlayerByUUID(playerName);
            boolean targetOp = serverLevel.getPlayerByUUID(playerName).getName().getString().equals(name);
            if (targetOp) {

                Minecraft.getInstance().player.displayClientMessage(new TextComponent(name), false);


            } else {
                Minecraft.getInstance().player.displayClientMessage(new TextComponent("User Does not Exist"), false);
                //User does not exist!

            }






        });
        return true;
    }

}


