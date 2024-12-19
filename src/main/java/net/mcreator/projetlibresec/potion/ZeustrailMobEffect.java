
package net.mcreator.projetlibresec.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

import net.mcreator.projetlibresec.procedures.ZeustrailOnEffectActiveTickProcedure;

public class ZeustrailMobEffect extends InstantenousMobEffect {
	public ZeustrailMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ZeustrailOnEffectActiveTickProcedure.execute(entity.level(), entity.getY(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
