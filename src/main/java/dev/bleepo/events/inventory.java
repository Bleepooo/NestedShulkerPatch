package dev.bleepo.events;

import dev.bleepo.Main;
import org.bukkit.block.ShulkerBox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class inventory implements Listener {
    private final Main plugin;

    public inventory(Main plugin) {
        this.plugin = plugin;
    }

    public boolean isShulker(ItemStack itemStack) {
        return itemStack != null && itemStack.getItemMeta() instanceof BlockStateMeta && ((BlockStateMeta) itemStack.getItemMeta()).getBlockState() instanceof ShulkerBox;
    }

    @EventHandler
    public void onMove(InventoryMoveItemEvent e) {
        if (isShulker(e.getItem())) {
            ItemMeta meta = e.getItem().getItemMeta();
            BlockStateMeta blockStateMeta = (BlockStateMeta) meta;
            ShulkerBox shulkerBox = (ShulkerBox) blockStateMeta.getBlockState();
            for (ItemStack i : shulkerBox.getInventory().getContents()) {
                if (isShulker(i)) shulkerBox.getInventory().remove(i);
            }
            blockStateMeta.setBlockState(shulkerBox);
            e.getItem().setItemMeta(meta);
        }
    }

    @EventHandler
    public void ClickedItem(InventoryClickEvent e) {
        if (isShulker(e.getCurrentItem())) {
            ItemMeta meta = e.getCurrentItem().getItemMeta();
            BlockStateMeta blockStateMeta = (BlockStateMeta) meta;
            ShulkerBox shulkerBox = (ShulkerBox) blockStateMeta.getBlockState();
            for (ItemStack i : shulkerBox.getInventory().getContents()) {
                if (isShulker(i)) shulkerBox.getInventory().remove(i);
            }
            blockStateMeta.setBlockState(shulkerBox);
            e.getCurrentItem().setItemMeta(meta);
        }
    }

    @EventHandler
    public void ActionEvent(InventoryPickupItemEvent e) {
        if (isShulker(e.getItem().getItemStack())) {
            ItemMeta meta = e.getItem().getItemStack().getItemMeta();
            BlockStateMeta blockStateMeta = (BlockStateMeta) meta;
            ShulkerBox shulkerBox = (ShulkerBox) blockStateMeta.getBlockState();
            for (ItemStack i : shulkerBox.getInventory().getContents()) {
                if (isShulker(i)) shulkerBox.getInventory().remove(i);
            }
            blockStateMeta.setBlockState(shulkerBox);
            e.getItem().getItemStack().setItemMeta(meta);
        }
    }
}
