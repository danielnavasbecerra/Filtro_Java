package com.navas.examen.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyUtils {

    // clear screen
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Clear screen for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clear screen for Unix-like systems (including macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error while clearing screen: " + e.getMessage());
        }
    }

    // Display message for seconds and clear screen
    public static void displayMessageAndClearScreen(String message, int displayDurationSeconds) {
        System.out.println(message);
        try {
            Thread.sleep(displayDurationSeconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }

    // method to get a LocalDate
    public static LocalDate getLocalDateInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Por favor, use el formato yyyy-MM-dd.");
            return getLocalDateInput(prompt, scanner); // Vuelve a pedir la entrada si el formato es incorrecto
        }
    }

    // method to get a double
    public static double getDoubleInput(String prompt, Scanner scanner) throws InputMismatchException {
        System.out.print(prompt);
        double input = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        try {
            return input;
        } catch (Exception e) {
            System.out.println("Valor inválido. Por favor, introduce un número.");
            return getDoubleInput(prompt, scanner); // Vuelve a pedir la entrada si el valor no es un número
        }
    }

    // method to get an int
    public static int getIntInput(String prompt, Scanner scanner) throws InputMismatchException {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        try {
            return input;
        } catch (Exception e) {
            System.out.println("Valor inválido. Por favor, introduce un número entero.");
            return getIntInput(prompt, scanner); // Vuelve a pedir la entrada si el valor no es un número entero
        }
    }

    // method to get a string
    public static String getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        try {
            return input;
        } catch (Exception e) {
            System.out.println("Valor inválido. Por favor, introduce un texto.");
            return getInput(prompt, scanner); // Vuelve a pedir la entrada si el valor no es un texto
        }
    }
}
