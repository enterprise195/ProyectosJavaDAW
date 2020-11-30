/*
 * Copyright 2020 Jose Ramon Albiach Vaño - joseramon.albiach.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author Jose Ramon Albiach Vaño - joseramon.albiach.alum@iescamp.es
 */
public class UtilesAleatorio {

    public static final Random RND = new Random();

    public static final int generar(int min, int max) {
        int valorRnd = RND.nextInt(max - min + 1) + min;

        return valorRnd;
    }

    public static final double aleatorioDouble(double min, double max) {
        double valorRnd = RND.nextDouble() * (max - min + 1) + min;

        return valorRnd;
    }

    public static final boolean aleatorioEntero() {
        boolean valorRnd = RND.nextBoolean();

        return valorRnd;
    }

    public static final char aleatorioDouble(char carMin, char carMax) {
        char valorRnd = (char) (RND.nextInt(carMax - carMin + 1) + carMin);

        return valorRnd;
    }
}
