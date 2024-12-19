
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projetlibresec.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.projetlibresec.ProjetlibresecMod;

public class ProjetlibresecModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, ProjetlibresecMod.MODID);
	public static final DeferredHolder<Potion, Potion> ZEUSTRAILS = REGISTRY.register("zeustrails", () -> new Potion(new MobEffectInstance(ProjetlibresecModMobEffects.ZEUSTRAIL, 3600, 0, false, true)));
}
