//package Ejercicio6;

import java.util.Scanner;

public class Practica05 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        System.out.println("\n");
        System.out.println("Menu: ");
        System.out.println("1.- Ejercicio 1");
        System.out.println("2.- Ejercicio 2");
        System.out.println("3.- Ejercicio 3");
        System.out.println("4.- Ejercicio 4");
        System.out.println("5.- Ejercicio 5");
        System.out.println("6.- Ejercicio 6 \n");

        System.out.println("Enter option: ");
        String opcion = sc.next();

        switch (opcion) {
            case "1":
                exercise1();

                break;
            case "2":
                exercise2();

                break;
            case "3":
                exercise3();

                break;
            case "4":
                exercise4();

                break;
            case "5":
                exercise5();

                break;
            case "6":
                exercise6();

            default:
                System.out.println("Opcion incorrecta");
        }
    }

    static void exercise1() {
        int contador;
        contador = 0;
        System.out.print("Question 1: What is the output of 'System.out.println(5+3);'?\n");
        System.out.println("a) 53");
        System.out.println("b) 8");
        System.out.println("c) 5+3");
        System.out.println("d) Error");
        System.out.println("Answer: ");
        String opcion1 = sc.next();

        System.out.println("Question 2: Which keyword is used to create a class in Java?");
        System.out.println("a) class");
        System.out.println("b) create");
        System.out.println("c) new");
        System.out.println("d) method");
        System.out.println("Answer: ");
        String opcion2 = sc.next();

        System.out.println("Question 3: What data type is used to create a variable that should store text?");
        System.out.println("a) myString");
        System.out.println("b) String");
        System.out.println("c) Txt");
        System.out.println("d) Text");
        System.out.println("Answer: ");
        String opcion3 = sc.next();

        System.out.println("Question 4: How do you start the main methot in Java?");
        System.out.println("a) public void main()");
        System.out.println("b) public static void main()");
        System.out.println("c) main()");
        System.out.println("d) static void main()");
        System.out.println("Answer: ");
        String opcion4 = sc.next();

        System.out.println("Question 5: What is the correct way to crate a variable of type int");
        System.out.println("a) int num = 5");
        System.out.println("b) integer num = 5");
        System.out.println("c) num int = 5");
        System.out.println("d) num = int 5");
        System.out.println("Answer: ");
        String opcion5 = sc.next();

        if (opcion1.equals("B")) {
            contador = contador + 1;
        }
        if (opcion2.equals("A")) {
            contador = contador + 1;
        }
        if (opcion3.equals("D")) {
            contador = contador + 1;
        }
        if (opcion4.equals("B")) {
            contador = contador + 1;
        }
        if (opcion5.equals("A")) {
            contador = contador + 1;

        }
        System.out.print("Final Grade: " + contador + "/5");
    }

    static void exercise2() {
        System.out.println("Enter a 3-digit number: ");
        String strnumero = sc.next();
        int numero = Integer.parseInt(strnumero);
        char d1 = strnumero.charAt(0);
        char d2 = strnumero.charAt(1);
        char d3 = strnumero.charAt(2);
        char d4 = strnumero.charAt(3);

        if (strnumero.length() == 4 || strnumero.length() == 3) {

            if (d1 == '-') {

                if (d2 == d4) {
                    System.out.println("The number is capicua");
                } else {

                }
            } else if (d1 != '-') {

                if (d2 == d4) {
                    System.out.println("The number is capicua");
                } else {
                }

            }

        }

    }

    static void exercise3() {
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        if (((num / 1) >= 1) && ((num / 1) <= 9) || ((num / 1) <= -1) && ((num / 1) >= -9)) {
            System.out.println("The number has 1 digit");
        } else if (((num / 10) >= 1) && ((num / 10) <= 9) || ((num / 10) <= -1) && ((num / 10) >= -9)) {
            System.out.println("The number has 2 digits");
        } else if (((num / 100) >= 1) && ((num / 100) <= 9) || ((num / 100) <= -1) && ((num / 100) >= -9)) {
            System.out.println("The number has 3 digits");
        } else if (((num / 1000) >= 1) && ((num / 1000) <= 9) || ((num / 1000) <= -1) && ((num / 1000) >= -9)) {
            System.out.println("The number has 4 digits");
        } else if (((num / 10000) >= 1) && ((num / 10000) <= 9) || ((num / 10000) <= -1) && ((num / 10000) >= -9)) {
            System.out.println("The number has 5 digits");
        } else {
            System.out.println("Invalid number");
        }
    }

    static void exercise4() {
        System.out.println("\n");
        System.out.println("Enter a day of the week: ");
        String day = sc.next();
        System.out.println("Enter time (HH MM): ");
        String time = sc.next();
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        String Hora = "" + h1 + h2;
        int hora = Integer.parseInt(Hora);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        String Minutos = "" + m1 + m2;
        int minutos = Integer.parseInt(Minutos);

        //System.out.println(h1+h2 + m1+m2);
        if (day.contentEquals("Monday") && (hora < 24) && (minutos < 60)) {
            int horaRestante;
            horaRestante = (24 - hora);
            int totalHoradia = (horaRestante * 60);
            int totalMinutosDia = (minutos + totalHoradia);
            int minutosRestanteTotal = 6660 - totalMinutosDia;
            System.out.println("Minutes until weekend: " + minutosRestanteTotal);
        }
        if (day.contentEquals("Tuesday") && (hora < 24) && (minutos < 60)) {
            int horaRestante;
            horaRestante = (24 - hora);
            int totalHoradia = (horaRestante * 60);
            int totalMinutosDia = (minutos + totalHoradia);
            int minutosRestanteTotal = 5220 - totalMinutosDia;
            System.out.println("Minutes until weekend: " + minutosRestanteTotal);
        }
        if (day.contentEquals("Wednesday") && (hora < 24) && (minutos < 60)) {
            int horaRestante;
            horaRestante = (24 - hora);
            int totalHoradia = (horaRestante * 60);
            int totalMinutosDia = (minutos + totalHoradia);
            int minutosRestanteTotal = 3780 - totalMinutosDia;
            System.out.println("Minutes until weekend: " + minutosRestanteTotal);
        }
        if (day.contentEquals("Thursday") && (hora < 24) && (minutos < 60)) {
            int horaRestante;
            horaRestante = (24 - hora);
            int totalHoradia = (horaRestante * 60);
            int totalMinutosDia = (minutos + totalHoradia);
            int minutosRestanteTotal = 2240 - totalMinutosDia;
            System.out.println("Minutes until weekend: " + minutosRestanteTotal);
        }
        if (day.contentEquals("Friday") && (hora < 24) && (minutos < 60)) {
            int horaRestante;
            horaRestante = (24 - hora);
            if (hora >= 15) {
                System.out.println("Its alrredy weekend");
            }
            else{
            int totalHoradia = (horaRestante * 60);
            int totalMinutosDia = (minutos + totalHoradia);
            int minutosRestanteTotal = 900 - totalMinutosDia;
            System.out.println("Minutes until weekend: " + minutosRestanteTotal);
            }
            
        }
        if (day.contentEquals("Saturday") && (hora < 24) && (minutos < 60)) {
            System.out.println("Its alrredy weekend");
        }
        if (day.contentEquals("Sunday") && (hora < 24) && (minutos < 60)) {
            System.out.println("Its alrredy weekend");
        } else {

        }
    }

    static void exercise5() {
        System.out.println("Enter the taxable base: ");
        float value = sc.nextFloat();
        System.out.println("Enter the TAX type (general, reduced, super-reduced");
        String typeTax = sc.next();
        System.out.println("Enter the promo code (noPromo, half, fixDiscount, percentage");
        String typePromocode = sc.next();
        float valueTax;
        valueTax = 0;
        float Promocode;
        Promocode = 0;
        int TAX;
        TAX = 0;
        String typePromo;
        typePromo ="";
        
        
        TAX = 0;
        String strTAX;
        strTAX ="";
        switch (typeTax) {
            
            case "general":
                TAX =21;
                valueTax = (value * TAX / 100);
                strTAX="TAX"+"("+ TAX+"%"+")";
                break;

            case "reduced":
                TAX =10;
                valueTax = (value * TAX / 100);
                strTAX="TAX"+"("+ TAX+"%"+")";
                break;

            case "super-reduced":
                TAX =4;
                valueTax = (value * TAX / 100);
                strTAX="TAX"+"("+ TAX+"%"+")";
                break;
        }
        float priceWithTaxes;
        priceWithTaxes = (valueTax + value);
        switch (typePromocode) {
            
            case "noPromo":
                Promocode = 0;
                typePromo = "Promo code(noPromo):";
                break;

            case "half":
                
                Promocode = ((priceWithTaxes * 50 / 100) - (priceWithTaxes));
                typePromo = "Promo code(half):";
                break;

            case "fixDiscount":
                Promocode = (Promocode - 5);
                typePromo = "Promo code(fixDiscount):";
                break;

            case "percentage":
                Promocode = ((priceWithTaxes * 5 / 100) - (priceWithTaxes));
                typePromo = "Promo code(percentage):";
                break;
                
           
        }
        
        System.out.printf("%-1s %6.2f\n", "Taxable base:", value);
        System.out.printf("%-1s %6.2f\n",strTAX, valueTax);
        System.out.printf("%-1s %6.2f\n","Price With taxes",priceWithTaxes);
        System.out.printf("%-1s %6.2f\n",typePromo, Promocode);
        System.out.printf("%-1s %6.2f\n","TOTAL",(priceWithTaxes + Promocode));
    }     

    static void exercise6() {}
    
}
