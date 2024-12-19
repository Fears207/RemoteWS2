package net.mcreator.projetlibresec.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.projetlibresec.init.ProjetlibresecModItems;
import net.mcreator.projetlibresec.ProjetlibresecMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class HeavenSmiteProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("projetlibresec:heavens_smite")))) == 2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("projetlibresec:chargeup")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("projetlibresec:chargeup")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 3, 3, 3, 0);
							ProjetlibresecMod.queueServerWork(170, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));;
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));;
									_level.addFreshEntity(entityToSpawn);
								}
							});
							if (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entity)) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
									if (world instanceof ServerLevel _level) {
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _level, null, _stkprov -> {
										});
									}
								} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
									if (world instanceof ServerLevel _level) {
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(5, _level, null, _stkprov -> {
										});
									}
								}
							}
						}
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("projetlibresec:heavens_smite")))) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("projetlibresec:chargeup")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("projetlibresec:chargeup")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 3, 3, 3, 0);
							ProjetlibresecMod.queueServerWork(170, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));;
									_level.addFreshEntity(entityToSpawn);
								}
							});
							if (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entity)) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
									if (world instanceof ServerLevel _level) {
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(8, _level, null, _stkprov -> {
										});
									}
								} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ProjetlibresecModItems.THUNDER_SWORD.get()) {
									if (world instanceof ServerLevel _level) {
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(8, _level, null, _stkprov -> {
										});
									}
								}
							}
						}
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
			}
		}
	}
}
