
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projetlibresec.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.projetlibresec.ProjetlibresecMod;

public class ProjetlibresecModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ProjetlibresecMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> CHARGEUP = REGISTRY.register("chargeup", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("projetlibresec", "chargeup")));
}
