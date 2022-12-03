package testmod.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import testmod.inventory.RulerMenu;
import testmod.networks.ModMessages;
import testmod.networks.packets.PlayerDistancePacket;

public class RulerScreen  extends AbstractContainerScreen<RulerMenu> implements Button.OnPress {
    private EditBox enterName;

    public RulerScreen(RulerMenu menu, Inventory inventory, Component component) {
        super(menu,inventory,component);
    }

    public void resize(Minecraft minecraft, int int1, int int2) {
        String s = this.enterName.getValue();
        this.init(minecraft, int1, int2);
        this.enterName.setValue(s);
    }

    @Override
    public void containerTick() {
        this.enterName.tick();
        super.containerTick();
    }

    @Override
    protected void init() {
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        enterName = new EditBox(this.font, this.width / 2 - 92, this.height / 4 - 10, 184, 20, new TextComponent("name"));
        this.enterName.setCanLoseFocus(false);
        this.enterName.setMaxLength(16);
        this.addWidget(this.enterName);
        this.setInitialFocus(this.enterName);
        this.enterName.setEditable(true);
        this.addRenderableWidget(new Button(this.width / 2 - 75, this.height * 3 / 4 - 10, 150, 20,
                CommonComponents.GUI_DONE,  this::onPress));
    }
    @Override
    public void onPress(Button button){
        ModMessages.sendToServer(new PlayerDistancePacket());
        onClose();
    }

    public boolean keyPressed(int p_97878_, int p_97879_, int p_97880_) {
        if (p_97878_ == 256) {
            this.minecraft.player.closeContainer();
        }
        return !this.enterName.keyPressed(p_97878_, p_97879_, p_97880_) && !this.enterName.canConsumeInput() ? super.keyPressed(p_97878_, p_97879_, p_97880_) : true;
    }
    @Override
    protected void renderBg(PoseStack poseStack, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(poseStack);
        this.enterName.render(poseStack, pMouseX, pMouseY, pPartialTick);
    }

    public void onClose() {
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        super.onClose();

    }
}

