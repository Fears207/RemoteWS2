package net.mcreator.projetlibresec.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.projetlibresec.init.ProjetlibresecModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ZeustrailOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 2; index0++) {
			if (world.isEmptyBlock(BlockPos.containing(entity.getX() + 2, y, entity.getZ() + 2))) {
				world.setBlock(BlockPos.containing(entity.getX() + 2, y, entity.getZ() + 2), ProjetlibresecModBlocks.AIRBLOCK.get().defaultBlockState(), 3);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Blocks in the way (Zeustrail)"), false);
			}
		}
	}
}
