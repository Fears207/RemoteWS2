package net.mcreator.projetlibresec.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.projetlibresec.init.ProjetlibresecModItems;
import net.mcreator.projetlibresec.ProjetlibresecMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ThunderSwordToolInHandTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
			ProjetlibresecMod.queueServerWork(10, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 2, 2, 2, 0);
			});
		}
	}
}
