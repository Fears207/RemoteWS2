
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projetlibresec.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.projetlibresec.ProjetlibresecMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ProjetlibresecModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjetlibresecMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VALORIA_TAB = REGISTRY.register("valoria_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.projetlibresec.valoria_tab")).icon(() -> new ItemStack(ProjetlibresecModBlocks.PURE_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ProjetlibresecModBlocks.PURE_STONE.get().asItem());
				tabData.accept(ProjetlibresecModBlocks.PUREST_STONE.get().asItem());
				tabData.accept(ProjetlibresecModItems.THUNDER_SWORD.get());
				tabData.accept(ProjetlibresecModItems.VALORIA.get());
				tabData.accept(ProjetlibresecModBlocks.PORTAL_BLOCK.get().asItem());
				tabData.accept(ProjetlibresecModBlocks.AIRBLOCK.get().asItem());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(ProjetlibresecModItems.THUNDER_SWORD.get());

		}
	}
}
