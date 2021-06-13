package com.willfp.ecoenchants.proxy.v1_16_R2.enchants;

import com.willfp.ecoenchants.enchantments.EcoEnchants;
import com.willfp.ecoenchants.enchantments.support.vanilla.VanillaEnchantmentMetadata;
import com.willfp.ecoenchants.enchantments.util.EnchantmentUtils;
import net.minecraft.server.v1_16_R2.Enchantment;
import org.bukkit.craftbukkit.v1_16_R2.enchantments.CraftEnchantment;
import org.jetbrains.annotations.NotNull;

public class EcoCraftEnchantment extends CraftEnchantment {
    private final VanillaEnchantmentMetadata metadata;

    public EcoCraftEnchantment(@NotNull final Enchantment target,
                               @NotNull final VanillaEnchantmentMetadata metadata) {
        super(target);
        this.metadata = metadata;
    }

    @Override
    public int getMaxLevel() {
        return metadata.getMaxLevel() == null ? this.getHandle().getMaxLevel() : metadata.getMaxLevel();
    }

    @Override
    public boolean conflictsWith(@NotNull final org.bukkit.enchantments.Enchantment other) {
        return EcoEnchants.getFromEnchantment(other) == null ? super.conflictsWith(other) : other.conflictsWith(other);
    }

    public void register() {
        EnchantmentUtils.register(this);
    }
}