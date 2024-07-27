package com.navas.examen.auth.infrastructure.in;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.navas.examen.auth.domain.service.AuthService;
import com.navas.examen.persona.application.ActualizarPersonaUseCase;
import com.navas.examen.persona.application.EliminarPersonaUseCase;
import com.navas.examen.persona.application.RegistrarPersonaUseCase;
import com.navas.examen.persona.domain.service.PersonaService;
import com.navas.examen.persona.infrastructure.in.ActualizarPersonaView;
import com.navas.examen.persona.infrastructure.in.EliminarPersonaView;
import com.navas.examen.persona.infrastructure.in.RegistrarPersonaView;
import com.navas.examen.persona.infrastructure.out.PersonaRepository;
import com.navas.examen.utils.MyUtils;

public class AuthController implements AuthService{
    private final Scanner scanner;
    private final PersonaService personaService;
    private final RegistrarPersonaView registrarPersonaView;
    private final ActualizarPersonaView actualizarPersonaView;
    private final EliminarPersonaView eliminarPersonaView;

    public AuthController(Scanner scanner) {
        this.scanner = scanner;
        this.personaService = new PersonaRepository();

        RegistrarPersonaUseCase registrarPersonaUseCase = new RegistrarPersonaUseCase(personaService);
        this.registrarPersonaView = new RegistrarPersonaView(registrarPersonaUseCase, scanner);

        ActualizarPersonaUseCase actualizarPersonaUseCase = new ActualizarPersonaUseCase(personaService);
        this.actualizarPersonaView = new ActualizarPersonaView(actualizarPersonaUseCase, scanner);

        EliminarPersonaUseCase eliminarPersonaUseCase = new EliminarPersonaUseCase(personaService);
        this.eliminarPersonaView = new EliminarPersonaView(eliminarPersonaUseCase, scanner);
    }

    @Override
    public void showMenu() {
        int option = 0;
        do {
            try {
                MyUtils.clearScreen();
                System.out.println("\n╔════════════════════════════════════════════╗");
                System.out.println("║                MENU GENERAL                ║");
                System.out.println("├════════════════════════════════════════════┤");
                System.out.println("║ 1. Registrar una Persona                   ║");
                System.out.println("║ 2. Asignar una Habilidad a una Persona     ║");
                System.out.println("║ 3. Crear una Nueva Habilidad               ║");
                System.out.println("║ 4. Consultar Personas por Habilidad        ║");
                System.out.println("║ 5. Actualizar Información de una Persona   ║");
                System.out.println("║ 6. Eliminar una Persona                    ║");
                System.out.println("║ 7. Salir                                   ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        registrarPersonaView.start();
                        break;
                    case 2:
                        // CrewController crewController = new CrewController(scanner);
                        // crewController.run();
                        MyUtils.displayMessageAndClearScreen("Funcionalidad no implementada...", 2);
                        break;
                    case 3:
                        // FlightController flightController = new FlightController(scanner);
                        // flightController.run();
                        MyUtils.displayMessageAndClearScreen("Funcionalidad no implementada...", 2);
                        break;
                    case 4:
                        // TripController tripController = new TripController(scanner);
                        // tripController.run();
                        MyUtils.displayMessageAndClearScreen("Funcionalidad no implementada...", 2);
                        break;
                    case 5:
                        actualizarPersonaView.start();
                        break;
                    case 6:
                        eliminarPersonaView.start();
                        break;
                    case 7:
                        MyUtils.displayMessageAndClearScreen("Saliendo...", 2);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                MyUtils.displayMessageAndClearScreen("Only numbers are valid", 2);
            } catch (IllegalStateException e) {
                System.out.println("ERROR: Scanner not exists.");
                return;
            } catch (NoSuchElementException e) {
                System.out.println("Error: No more input available");
                return;
            }

        } while (option != 7);
    }
}