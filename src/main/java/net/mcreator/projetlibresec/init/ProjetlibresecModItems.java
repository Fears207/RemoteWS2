
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projetlibresec.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.projetlibresec.item.ThunderSwordItem;
import net.mcreator.projetlibresec.ProjetlibresecMod;

public class ProjetlibresecModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ProjetlibresecMod.MODID);
	public static final DeferredItem<Item> PURE_STONE = block(ProjetlibresecModBlocks.PURE_STONE);
	public static final DeferredItem<Item> PUREST_STONE = block(ProjetlibresecModBlocks.PUREST_STONE);
	public static final DeferredItem<Item> THUNDER_SWORD = REGISTRY.register("thunder_sword", ThunderSwordItem::new);
	public static final DeferredItem<Item> PORTAL_TEXTURE = block(ProjetlibresecModBlocks.PORTAL_TEXTURE);
	public static final DeferredItem<Item> PORTAL_BLOCK = block(ProjetlibresecModBlocks.PORTAL_BLOCK);
	public static final DeferredItem<Item> AIRBLOCK = block(ProjetlibresecModBlocks.AIRBLOCK);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
