package ar.com.xeven;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocalTime hora = LocalTime.now();
        System.out.println("La hora: "+hora);

        LocalDate fecha = LocalDate.now();
        System.out.println("Hoy: "+fecha);

        /*
        dd = día
        MM = mes
        yyyy = año
        HH = hora
        mm = minuto
        ss = segundos
         */

        System.out.println("Dentro de 3 meses: "+fecha.plusMonths(3));

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Ahora: "+ahora);

        String fechaConFormato = ahora.format(java.time.format.DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm"));
        System.out.println("Fecha con formato: "+fechaConFormato);

        int anio=2020;
        int mes=06;
        int dia=25;

        LocalDate unaFecha = LocalDate.ofYearDay(2020, 180);
        System.out.println("el día del año pasado: "+unaFecha);

        /*
        Pedirle al usuario, día y mes de su cumpleaños
        e informarle qué día del año cumple.
         */
        Scanner sc = new Scanner(System.in);
        /*
        System.out.print("Ingrese el día de su cumple: ");
        int elDia = sc.nextInt();
        System.out.print("Ingrese el mes de su cumple: ");
        int elMes = sc.nextInt();
        LocalDate elCumple = LocalDate.of(2021, elMes, elDia);
        int elDiaDelAnio = elCumple.getDayOfYear();
        System.out.printf("Tu cumpleaños cae el día %d de este año.",elDiaDelAnio);
        */

        LocalDateTime laNavidad = LocalDateTime.of(2021,12,24,23,59);
        LocalDateTime unDia = LocalDateTime.now().plusDays(1); //mañana

        if(unDia.isAfter(laNavidad)){ // pregunto si mañana es después de navidad
            System.out.println("Ya pasó navidad :-(");
        }else{
            int diasParaNavidad = laNavidad.getDayOfYear()-unDia.getDayOfYear();
            long diasQueFaltan = Duration.between(unDia, laNavidad).toDays();
            System.out.println("Faltan "+diasQueFaltan);
            System.out.println("Todavía faltan "+diasParaNavidad+" días para navidad! :-(");
        }

        System.out.print("Ingrese el día de vencimiento: ");
        int diaVencimiento = sc.nextInt();
        System.out.print("Ingrese el mes de vencimiento: ");
        int mesVencimiento = sc.nextInt();
        System.out.print("Ingrese el año de vencimiento: ");
        int anioVencimiento = sc.nextInt();
        LocalDate fechaVencimiento = LocalDate.of(anioVencimiento, mesVencimiento, diaVencimiento);
        LocalDate fechaHoy = LocalDate.now();
        int elDiaDeVencimiento = fechaVencimiento.getDayOfYear();
        int elDiaDeHoy = fechaHoy.getDayOfYear();

        if(elDiaDeVencimiento < elDiaDeHoy){
            // esta vencido
            System.out.println("TIRE ESO!");
        }else if(elDiaDeVencimiento >= elDiaDeHoy){
            if(elDiaDeVencimiento >= elDiaDeHoy+30){
                // faltan 30 o más días
                System.out.println("Debe guardar el producto");
            }else{
                // faltan menos de 30 días
                System.out.println("Se sugiere usar el producto");
            }
        }
    }
    /*
    Se pide al usuario que ingrese la fecha de vencimiento de un producto.
    Si el producto está vencido, se le sugiere que lo tire.
    Si faltan 30 días o más para su vencimiento, se le sugiere que lo guarde.
    Si faltan menos de 30 días para su vencimiento, se le pide que lo use pronto
     porque va a tener que tirarlo.
     */
}
