package net.mcreator.projetlibresec.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class AirblokeffectOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double PosY = 0;
		PosY = y + 0.2;
		for (int index0 = 0; index0 < 3; index0++) {
			if (world.isClientSide() == true) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5), PosY, (z + 0.5), 0, 0.5, 0);
			}
			PosY = PosY + 0.2;
		}
	}
}
