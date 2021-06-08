/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.proyecto;

import com.unicahccpmp.proyecto.dao.*;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ikero
 */
public class Main {
    private static String inputData = "R";
    private static ArrayList<MinecraftEntry> myEntries;
    private static Conn myConnection;
    private static Scanner keyInput;
    private static String LineSeperator;
    
    public static void main(String arg[]){
        
        myConnection = new Conn();
        myConnection.hacerconexion();
        keyInput = new Scanner(System.in);
        LineSeperator = new String(new char[118]).replace("\0","-");
        /*
        Conn myConnection = new Conn();
        myConnection.hacerconexion();
        */
        
        System.out.println(LineSeperator);
        System.out.println("Trabajo en grupo");
        /*
        ArrayList<MinecraftEntry> myEntries = myConnection.getAllMinecraftEntry();
        System.out.print(myEntries.size());
        */
        
        while(!inputData.equalsIgnoreCase("Q")){
            System.out.println();
            switch(inputData.toUpperCase())
            {
                case "N":
                    crearnuevo();
                    break;
                case "A":
                    actualizarRegistro();
                    break;
                case "B":
                    eliminarRegistro();
                    break;
            }
            showEntries();
            showMenu();
        }
    }
    
    public static void showMenu(){
        System.out.println(LineSeperator);
        System.out.println("Q Salir\tN Nuevo\t A Actualizar\t B Borrar \n Press key and Enter:");
        inputData = keyInput.nextLine();
    }
    
    public static void showEntries(){
        myEntries = myConnection.getAllMinecraftEntry();
        
        System.out.println(LineSeperator);
        System.out.println(String.format("%s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t","#","MinecraftBlockName","MinecraftCraftReceipt","MincraftAttack","MinecraftDefense","Minecraft"));
        System.out.println(LineSeperator);
        
        for(MinecraftEntry _entrada : myEntries){
            System.out.println(_entrada.getFormattedText());
        }
        /*
        for (int i = 0; i<myEntries.size(); i++){
            System.out.println(myEntries.get(i).getFormattedText());
        }
        */
        System.out.println(LineSeperator);
        System.out.println(String.format("Total De Filas: %d",myEntries.size()));
    }
    
    public static void crearnuevo()
        {
            System.out.println();
            System.out.println("Obtener nueva registro");
            System.out.println(LineSeperator);
            System.out.println("Block Name: ");
            String _MinecraftBlockName = keyInput.nextLine();
            System.out.println("Craft Receipt: ");
            String _MinecraftCraftReceipt = keyInput.nextLine();
            System.out.println("Minecraft Attack: ");
            String _MincraftAttack = keyInput.nextLine();
            System.out.println("Minecraft Defense: ");
            String _MinecraftDefense = keyInput.nextLine();
            System.out.println("Minecraft: ");
            String _Minecraft = keyInput.nextLine();
            
           MinecraftEntry nueva = new MinecraftEntry();
           
           nueva.setMinecraftBlockName(_MinecraftBlockName);
           nueva.setMinecraftCraftReceipt(_MinecraftCraftReceipt);
           nueva.setMincraftAttack(Integer.valueOf(_MincraftAttack));
           nueva.setMinecraftDefense(Integer.valueOf(_MinecraftDefense));
           nueva.setMinecraft(Integer.valueOf(_Minecraft));
           
           myConnection.agregarNuevoMinecraftEntry(nueva);
           System.out.println();
        }
    
    public static void actualizarRegistro(){
        
        System.out.println("Escriba el ID del registro que desea actualizar: ");
        int IDregistro = keyInput.nextInt();
        MinecraftEntry RegistroActualizable = myConnection.obtenerUnRegistro(IDregistro);
        

        if (RegistroActualizable.getID()>0){
            
        System.out.println(LineSeperator);
        System.out.println(RegistroActualizable.getFormattedText());
        System.out.println(LineSeperator);
        
            
            System.out.println("Block Name (" + RegistroActualizable.getMinecraftBlockName() + "):");
            String _MinecraftBlockName = keyInput.nextLine();
            
            if (!_MinecraftBlockName.isEmpty() && !_MinecraftBlockName.equals(RegistroActualizable.getMinecraftBlockName())){
                RegistroActualizable.setMinecraftBlockName(_MinecraftBlockName);
            }
            
            System.out.println("Craft Receipt ("+RegistroActualizable.getMinecraftCraftReceipt()+"):");
            String _MinecraftCraftReceipt = keyInput.nextLine();
            if (!_MinecraftCraftReceipt.isEmpty() && !_MinecraftCraftReceipt.equals(RegistroActualizable.getMinecraftCraftReceipt())){
                RegistroActualizable.setMinecraftCraftReceipt(_MinecraftCraftReceipt);
            }
            
            System.out.println("Minecraft Attack ("+RegistroActualizable.getMincraftAttack()+"):");
            String _MincraftAttack = keyInput.nextLine();
            if (!_MincraftAttack.isEmpty() && !_MincraftAttack.equals(RegistroActualizable.getMincraftAttack())){
                RegistroActualizable.setMincraftAttack(Integer.valueOf(_MincraftAttack));
            }
            
            System.out.println("Minecraft Defense ("+RegistroActualizable.getMinecraftDefense()+"):");
            String _MinecraftDefense = keyInput.nextLine();
            if (!_MinecraftDefense.isEmpty() && !_MinecraftDefense.equals(RegistroActualizable.getMinecraftDefense())){
                RegistroActualizable.setMinecraftDefense(Integer.valueOf(_MincraftAttack));
            }
            
            System.out.println("Minecraft ("+RegistroActualizable.getMinecraft()+"):");
            String _Minecraft = keyInput.nextLine();
            if (!_Minecraft.isEmpty() && !_Minecraft.equals(RegistroActualizable.getMinecraft())){
                RegistroActualizable.setMinecraft(Integer.valueOf(_MincraftAttack));
            }
        }
        
        System.out.println(RegistroActualizable.getFormattedText());
        String variableHuerfana = keyInput.nextLine();
    }
    
    public static void eliminarRegistro()
    {
        System.out.println("Escriba el codigo del registro a eliminar: ");
        int IDregistro = keyInput.nextInt();
        keyInput.nextLine(); 
        MinecraftEntry registroAEliminar = myConnection.obtenerUnRegistro(IDregistro); 
        System.out.println(LineSeperator);
        System.out.println(registroAEliminar.getFormattedText());
        System.out.println(LineSeperator);
        
        System.out.println("¿Desea Eliminar el registro? [S/N]: ");
        String opcion = keyInput.nextLine(); 
        if(opcion.toUpperCase().equals("S"))
        {
            myConnection.eliminarRegistro(registroAEliminar);
            System.out.println("Registro Eliminado. Presione ENTER para continuar.");
        }else {
            System.out.println("Operacion Cancelada. Presione ENTER para continuar.");
        }
        keyInput.nextLine();
        }
    
    
}
