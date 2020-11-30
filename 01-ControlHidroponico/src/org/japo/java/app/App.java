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
package org.japo.java.app;

//Imports
import java.util.Calendar;
import org.japo.java.hydroponics.UtilesHidroponicos;
import org.japo.java.libraries.UtilesAleatorio;
import org.japo.java.libraries.UtilesFecha;

/**
 *
 * @author Jose Ramon Albiach Vaño - joseramon.albiach.alum@iescamp.es
 */
public class App {

    //Objeto Calendar
    public static final Calendar CAL = Calendar.getInstance();

    //Rango de valor aleatorio para la Humedad
    public static final int H_RND_MIN = 70;
    public static final int H_RND_MAX = 90;

    //Rango de valor aleatorio para la Temperatura
    public static final int T_RND_MIN = 15;
    public static final int T_RND_MAX = 25;

    //Rango de valor aleatorio para la Iluminación
    public static final int I_RND_MIN = 5;
    public static final int I_RND_MAX = 15;

    //Rango de valor para la Humedad
    public static final int H_MIN = 71;
    public static final int H_MAX = 86;

    //Rango de valor para la Temperatura
    public static final int TEMP_MIN = 19;
    public static final int TEMP_MAX = 22;

    //Rango de valor para la Iluminación
    public static final int I_MIN = 8;
    public static final int I_MAX = 13;

    //Rango de horas para el turno de mañana
    public static final int TM_MIN = 06;
    public static final int TM_MAX = 14;

    //Rango de horas para el turno de tarde
    public static final int TT_MIN = 14;
    public static final int TT_MAX = 22;

    //Rango de horas para el turno de noche
    public static final int TN_MIN = 22;
    public static final int TN_MAX = 06;

    //Mensajes para el estado
    public static final String MSG_NOM = "NOMINAL";
    public static final String MSG_ALR = "ALARMA";

    //Mensajes para los turnos de la horas
    public static final String MSG_MAÑANA = "MAÑANA";
    public static final String MSG_TARDE = "TARDE";
    public static final String MSG_NOCHE = "NOCHE";

    //Mensajes para los informes
    public static final String MSG_FECHA = "Fecha ........: ";
    public static final String MSG_HORA = "Hora .........: ";
    public static final String MSG_H = "Humedad ......: ";
    public static final String MSG_T = "Temperatura ..: ";
    public static final String MSG_I = "Iluminación ..: ";

    public void launchApp() {
        //Cabecera Incial
        System.out.println("Die Farben der Blumen GmbH – Hydroponics Sagunto");
        System.out.println("================================================");

        //SubCabecera
        System.out.println("Registro de Parámetros Operativos");
        System.out.println("---------------------------------");

        //Obtencion de la fecha del sistema
        int da = CAL.get(Calendar.DATE);
        int ma = CAL.get(Calendar.MONTH) + 1;
        int aa = CAL.get(Calendar.YEAR);

        //Obtencion de la hora del sistema
        int ha = CAL.get(Calendar.HOUR);
        int minA = CAL.get(Calendar.MINUTE);

        //Llamada metodo para obtener el nombre del mes
        String nombreMes = UtilesFecha.obtenerNombreMes(ma);

        String turno = "";

        //Turno mañana
        if (ha >= TM_MIN && ha <= TM_MAX) {
            turno = MSG_MAÑANA;
        }

        //Turno tarde
        if (ha >= TT_MIN && ha <= TT_MAX) {
            turno = MSG_TARDE;
        }

        //Turno noche
        if (ha >= TN_MIN && ha <= TN_MAX) {
            turno = MSG_NOCHE;
        }

        //Informe fecha del sistema
        System.out.printf("%s%d de %s de %d%n", MSG_FECHA, da, nombreMes, aa);

        //Informe hora del sistema y el turno
        System.out.printf("%s%02d:%dh  - %s%n", MSG_HORA, ha, minA, turno);

        //Llamada al metodo que genera un valor entero aleatorio
        int hRnd = UtilesAleatorio.generar(H_RND_MIN, H_RND_MAX);
        int tRnd = UtilesAleatorio.generar(T_RND_MIN, T_RND_MAX);
        int iRnd = UtilesAleatorio.generar(I_RND_MIN, I_RND_MAX);

        //Llamada al metodo para analizar el estado
        boolean hOK = UtilesHidroponicos.analizar(hRnd, H_MIN, H_MAX);
        boolean tOK = UtilesHidroponicos.analizar(tRnd, TEMP_MIN, TEMP_MAX);
        boolean iOK = UtilesHidroponicos.analizar(iRnd, I_MIN, I_MAX);

        //Informe Humedad y su estado
        System.out.printf("%s%d %%    - %s%n",
                MSG_H, hRnd, hOK ? MSG_NOM : MSG_ALR);

        //Informe Temperatura y su estado
        System.out.printf("%s%d ºC   - %s%n",
                MSG_T, tRnd, tOK ? MSG_NOM : MSG_ALR);

        //Informe Iluminación y su estado
        System.out.printf("%s%02d kLux - %s%n",
                MSG_I, iRnd, iOK ? MSG_NOM : MSG_ALR);
    }

}
