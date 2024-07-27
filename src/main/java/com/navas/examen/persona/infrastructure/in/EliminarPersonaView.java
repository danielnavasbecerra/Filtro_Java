package com.navas.examen.persona.infrastructure.in;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.navas.examen.persona.application.EliminarPersonaUseCase;
import com.navas.examen.persona.domain.entity.Persona;
import com.navas.examen.utils.MyUtils;

public class EliminarPersonaView {

    // Atributes
    private final EliminarPersonaUseCase eliminarPersonaUseCase;
    private final Scanner scanner;

    // Constructor
    public EliminarPersonaView(EliminarPersonaUseCase eliminarPersonaUseCase, Scanner scanner) {
        this.eliminarPersonaUseCase = eliminarPersonaUseCase;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            try {
                MyUtils.clearScreen();
                scanner.nextLine(); // clean buffer
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.println("║             Eliminar Persona             ║");
                System.out.println("╚══════════════════════════════════════════╝");
                System.out.println("\n╔══════════════════════════════════════════╗");

                String name = MyUtils.getInput("║  Ingresar Nombre: ", scanner);
                String lastname = MyUtils.getInput("║  Ingresar Apellido: ", scanner);
                int city = MyUtils.getIntInput("║ Ingresar el ID de la Ciudad: ", scanner);
                String address = MyUtils.getInput("║  Ingresar Direccion: ", scanner);
                int age = MyUtils.getIntInput("║  Ingresar Edad: ", scanner);
                String email = MyUtils.getInput("║  Ingresar Email: ", scanner);
                int gender = MyUtils.getIntInput("║  Ingresar el ID del Genero: ", scanner);
                
                System.out.println("╚══════════════════════════════════════════╝");

                Persona persona = new Persona(name, lastname, city, address, age, email, gender);
                String response = registrarPersonaUseCase.registrarPersona(persona);
                MyUtils.displayMessageAndClearScreen(response, 2);
                break;

            } catch (InputMismatchException e) {
                scanner.nextLine(); // clean buffer
                MyUtils.displayMessageAndClearScreen("Ups! Only numbers are valid try again", 2);
            } catch (NoSuchElementException e) {
                MyUtils.displayMessageAndClearScreen("Ups! not line found", 2);
                break;
            } catch (IllegalStateException e) {
                MyUtils.displayMessageAndClearScreen("Ups! the scanner is closed", 2);
                break;
            }
        }
    }
}
