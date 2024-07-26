package com.navas.examen;

import java.util.Scanner;

import com.navas.examen.auth.infrastructure.in.AuthController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthController authController = new AuthController(scanner);
        authController.showMenu();
    }
}