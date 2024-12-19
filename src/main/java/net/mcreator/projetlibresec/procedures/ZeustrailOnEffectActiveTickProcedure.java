package net.mcreator.projetlibresec.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.projetlibresec.init.ProjetlibresecModMobEffects;
import net.mcreator.projetlibresec.ProjetlibresecMod;

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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ProjetlibresecModMobEffects.ZEUSTRAIL)) {
			for (int index0 = 0; index0 < 2; index0++) {
				if (world.isEmptyBlock(BlockPos.containing(entity.getX() + 2, y, entity.getZ() + 2))) {
					ProjetlibresecMod.queueServerWork(20, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + 2, y, entity.getZ() + 2)));;
							_level.addFreshEntity(entityToSpawn);
						}
					});
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Blocks in the way (Zeustrail)"), false);
				}
			}
		}
	}
}
