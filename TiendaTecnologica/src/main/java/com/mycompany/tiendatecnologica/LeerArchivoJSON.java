/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendatecnologica;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoJSON {

    private static JsonObject dataJson;

    public static void main(String[] args) {
        // Intentar leer el archivo JSON
        inicializarDatosDesdeJSON();
    }

    // Inicializa los datos del archivo JSON
    private static void inicializarDatosDesdeJSON() {
        Gson gson = new Gson();
        try {
            System.out.println("Intentando leer el archivo data.json...");
            FileReader reader = new FileReader("data.json");
            dataJson = gson.fromJson(reader, JsonObject.class);
            reader.close();
            System.out.println("Archivo JSON leído exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo JSON.");
        }
    }

    // Método para obtener el objeto JSON leído (opcional si necesitas usar los datos)
    public static JsonObject getDataJson() {
        return dataJson;
    }
}
