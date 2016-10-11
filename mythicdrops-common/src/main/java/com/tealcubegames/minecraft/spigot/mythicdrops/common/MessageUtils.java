/**
 * This file is part of MythicDrops Common, licensed under the MIT License.
 *
 * Copyright (C) 2013 Teal Cube Games
 *
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.tealcubegames.minecraft.spigot.mythicdrops.common;

import com.google.common.base.Preconditions;
import com.tealcube.minecraft.bukkit.TextUtils;
import org.bukkit.command.CommandSender;

/**
 * A utility class for sending non-fancy messages to players.
 */
public final class MessageUtils {

    private MessageUtils() {
        // do nothing
    }

    /**
     * Sends a message to the given player after replacing any color codes.
     *
     * @param sender  Player or Console
     * @param message message to send
     */
    public static void sendMessage(CommandSender sender, String message) {
        Preconditions.checkNotNull(sender, "sender cannot be null");
        Preconditions.checkNotNull(message, "message cannot be null");
        sender.sendMessage(TextUtils.color(message));
    }

    /**
     * Sends a message to the given player after replacing any color codes and replacing any tokens in the message.
     * <p>
     * Example:
     * {@code MessageUtils.sendMessage(player, "<red>Your name is %name%!", new String[][]{{"%name%", player.getName()})}
     *
     * @param sender  Player or Console
     * @param message message to send
     * @param args    tokens to replace and their values
     */
    public static void sendMessage(CommandSender sender, String message, String[][] args) {
        Preconditions.checkNotNull(sender, "sender cannot be null");
        Preconditions.checkNotNull(message, "message cannot be null");
        Preconditions.checkNotNull(args, "args cannot be null");
        sender.sendMessage(TextUtils.color(TextUtils.args(message, args)));
    }

}