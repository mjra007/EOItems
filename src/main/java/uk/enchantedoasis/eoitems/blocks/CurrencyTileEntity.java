package uk.enchantedoasis.eoitems.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CurrencyTileEntity extends TileEntity implements IAnimatable {

        private final AnimationFactory factory = new AnimationFactory(this);
        public AnimationBuilder BREAKING = new AnimationBuilder().addAnimation("animation.model.new", false); ;
        private AnimationController controller;

        public boolean isBlockBreaking = false;

        @SuppressWarnings("unchecked")
        private <E extends TileEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
                event.getController().transitionLengthTicks = 0;
                if(isBlockBreaking){
                        controller.setAnimation(BREAKING);
                }
                return PlayState.STOP;
        }
        @Override
        public void registerControllers(AnimationData data) {
                controller = new AnimationController(this, "controller", 0, this::predicate);
                data.addAnimationController(controller);
        }

        @Override
        public AnimationFactory getFactory() {
                return factory;
        }

        public AnimationController getController(){
                return controller;
        }

        @SubscribeEvent
        public static void onBlockBreak(PlayerEvent.BreakSpeed event){
                TileEntity te = event.getEntity().world.getTileEntity(event.getPos());
                if(te != null && te instanceof CurrencyTileEntity){
                        CurrencyTileEntity teCurrency = (CurrencyTileEntity) te;
                        teCurrency.isBlockBreaking = true;
                        teCurrency.markDirty();
                }
        }

        @Override
        public boolean canRenderBreaking() {
                return true;
        }
}
