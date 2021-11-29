/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documedentation files (the "Software"), to deal
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

package com.iluwatar.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * The Decorator pattern is a more flexible alternative to subclassing. The Decorator class
 * implements the same interface as the target and uses composition to "decorate" calls to the
 * target. Using the Decorator pattern it is possible to change the behavior of the class during
 * runtime.
 *
 * <p>In this example we show how the simple {@link SimpleTroll} first attacks and then flees the
 * battle. Then we decorate the {@link SimpleTroll} with a {@link ClubbedTroll} and perform the
 * attack again. You can see how the behavior changes after the decoration.
 */
@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        // simple troll
        LOGGER.info("A simple looking troll approaches.");
        var simpleTroll = new SimpleTroll();
        simpleTroll.attack();
        simpleTroll.fleeBattle();
        LOGGER.info("Simple troll power: {}.\n", simpleTroll.getAttackPower());

        // clubbed troll, change the behavior of the simple troll by adding a decorator
        LOGGER.info("A troll with huge club surprises you.");
        var clubbedTroll = new ClubbedTroll(simpleTroll);
        clubbedTroll.attack();
        clubbedTroll.fleeBattle();
        LOGGER.info("Clubbed troll power: {}.\n", clubbedTroll.getAttackPower());

        // super troll, change the behavior of the simple troll by adding a decorator
        LOGGER.info("A super troll with super huge club surprises you.");
        var superTroll = new SuperTroll(simpleTroll);
        superTroll.attack();
        superTroll.fleeBattle();
        LOGGER.info("Super troll power: {}.\n", superTroll.getAttackPower());

        // peaceful troll, change the behavior of the simple troll by adding a decorator
        LOGGER.info("A peaceful troll with a awkward smile surprises you.");
        var peacefulTroll = new PeacefulTroll(simpleTroll);
        peacefulTroll.attack();
        peacefulTroll.fleeBattle();
        LOGGER.info("Peaceful troll power: {}.\n", peacefulTroll.getAttackPower());
    }
}
