/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.item.merchant;

import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * <p>Represents a trade offer that a {@link Merchant} may offer a
 * {@link org.spongepowered.api.entity.living.Human}.</p>
 *
 * <p>TradeOffers usually have a limited amount of times they can be used.</p>
 *
 * <p>Also, trade offers are not guaranteed to have two buying items.</p>
 */
public interface TradeOffer {

    /**
     * Get the {@link TradeOfferBuilder} used to edit trade offers.
     *
     * @return The trade offer builder
     */
    TradeOfferBuilder builder();

    /**
     * Gets the first buying item.
     * <p>The first buying item is an item that the customer is selling to the
     * merchant in exchange for {@link #getSellingItem()}.</p>
     *
     * @return The first buying item
     */
    ItemStack getFirstBuyingItem();

    /**
     * Returns whether this trade offer has a second item the merchant is buying
     * from the customer.
     *
     * @return True if there is a second buying item
     */
    boolean hasSecondItem();

    /**
     * <p>Gets the second buying item.</p>
     *
     * <p>The second buying item is an item that the customer is selling to the
     * merchant, along with the {@link #getFirstBuyingItem()}, in exchange for
     * {@link #getSellingItem()}.</p>
     *
     * @return The second buying item, if available
     */
    Optional<ItemStack> getSecondBuyingItem();

    /**
     * Gets the selling item the {@link Merchant} will give to the customer
     * often in exchange for a singel item or sometimes, two items from the
     * following methods: {@link #getFirstBuyingItem()} and
     * {@link #getSecondBuyingItem}.
     *
     * @return The selling item
     */
    ItemStack getSellingItem();

    /**
     * Gets the current uses of this offer.
     *
     * <p>Usually, the uses of an offer a re limited by the amount of
     * {@link #getMaxUses()}. Once the uses reaches the max uses, the offer may
     * temporarily become disabled.</p>
     *
     * @return The current uses of this trade offer
     */
    int getUses();

    /**
     * Gets the current maximum uses of this offer.
     *
     * <p>Usually, the uses of an offer a re limited by the amount of maximum
     * uses. Once the uses reaches the max uses, the offer may temporarily
     * become disabled.</p>
     *
     * @return The maximum uses of this trade offer
     */
    int getMaxUses();

    /**
     * Gets the remaining amount of uses of this offer.
     *
     * @return The remaining uses of this offer.
     */
    int getRemainingUses();

    /**
     * Checks if this trade offer has indeed passed the time of which the uses
     * surpassed the maximum uses.
     *
     * @return True if the uses have surpassed the maximum uses
     */
    boolean hasExpired();

    /**
     * Gets whether this trade offer will grant experience upon usage or not.
     *
     * @return True if using this trade offer will grant experience
     */
    boolean doesGrantExperience();

}
