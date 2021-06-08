/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.proyecto.dao;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ikero
 */
public class Conn {
    Connection c = null;
    public java.sql.Connection hacerconexion(){
        if (c != null){
            return c;
        }
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TrabajoEnGrupo.db");
            String SQLVerifyTable = "CREATE TABLE IF NOT EXISTS Minecraft"
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "MinecraftBlockName TEXT NOT NULL,"
                    + "MinecraftCraftReceipt TEXT NOT NULL,"
                    + "MincraftAttack INT NOT NULL,"
                    + "MinecraftDefense INT NOT NULL,"
                    + "Minecraft INT NOT NULL)";
            Statement stmt = c.createStatement();
            stmt.executeUpdate(SQLVerifyTable);
            stmt.close();
            return c;
        }
        catch(Exception e){
            System.err.println(" ERROR... " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public ArrayList<MinecraftEntry> getAllMinecraftEntry(){
        try{
            if(c==null){
               hacerconexion();
            }
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Minecraft;");
            ArrayList<MinecraftEntry> allMyEntries = new ArrayList<MinecraftEntry>();
            while(rs.next()){
                MinecraftEntry nuevaEntrada = new MinecraftEntry();
                nuevaEntrada.setID(rs.getInt("ID"));
                nuevaEntrada.setMinecraftBlockName(rs.getString("MinecraftBlockName"));
                nuevaEntrada.setMinecraftCraftReceipt(rs.getString("MinecraftCraftReceipt"));
                nuevaEntrada.setMincraftAttack(rs.getInt("MincraftAttack"));
                nuevaEntrada.setMinecraftDefense(rs.getInt("MinecraftDefense"));
                nuevaEntrada.setMinecraft(rs.getInt("Minecraft"));
                
                allMyEntries.add(nuevaEntrada);
            }
            stmt.close();
            return allMyEntries;
        }
        catch(Exception e){
            System.err.println("Error"+e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public void agregarNuevoMinecraftEntry(MinecraftEntry nueva){
        try
        {
            String sqlstr = "INSERT INTO Minecraft (MinecraftBlockName, "
                    + "MinecraftCraftReceipt, MincraftAttack, MinecraftDefense, "
                    + "Minecraft)"
                    + " values('%s','%s','%d','%d','%d');";
            Statement stmt = c.createStatement();
            stmt.executeUpdate(
                   String.format(
                           sqlstr,
                           nueva.getMinecraftBlockName(),
                           nueva.getMinecraftCraftReceipt(),
                           nueva.getMincraftAttack(),
                           nueva.getMinecraftDefense(),
                           nueva.getMinecraft()
                   )
            );
            stmt.close();
        }
        catch(Exception e)
        {
            System.err.println("ERROR"+e.getMessage());
            System.exit(0);
        }
    }
    
    public MinecraftEntry obtenerUnRegistro(int IDregistro){
        try{
            String sentencialSql = "SELECT * from Minecraft where ID=%d;";
            Statement comandoSql = c.createStatement();
            ResultSet cursorDeRegistro = comandoSql.executeQuery(
                String.format(sentencialSql, IDregistro)
            );
            MinecraftEntry miRegistro = new MinecraftEntry();
            while(cursorDeRegistro.next()){
                miRegistro.setID(cursorDeRegistro.getInt("ID"));
                miRegistro.setMinecraftBlockName(cursorDeRegistro.getString("MinecraftBlockName"));
                miRegistro.setMinecraftCraftReceipt(cursorDeRegistro.getString("MinecraftCraftReceipt"));
                miRegistro.setMincraftAttack(cursorDeRegistro.getInt("MincraftAttack"));
                miRegistro.setMinecraftDefense(cursorDeRegistro.getInt("MinecraftDefense"));
                miRegistro.setMinecraft(cursorDeRegistro.getInt("Minecraft"));
            }
            return miRegistro;
        }
        catch(Exception e)
        {
            System.err.println("ERROR..."+e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public void actualizarRegistro(MinecraftEntry RegistroActualizable){
        try
        {
            String sentencialSQL = "UPDATE Minecraft set MinecraftBlockName=%s, "
                    + "MinecraftCraftReceipt=%s, MincraftAttack=%d, "
                    + "MinecraftDefense=%d, Minecraft=%d "
                    + "where ID=%d;";
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate
                (
                    String.format
                    ( 
                            sentencialSQL,
                            RegistroActualizable.getMinecraftBlockName(),
                            RegistroActualizable.getMinecraftCraftReceipt(),
                            RegistroActualizable.getMincraftAttack(),
                            RegistroActualizable.getMinecraftDefense(),
                            RegistroActualizable.getMinecraft()
                    )
                );
            comandoSQL.close();
        }
        catch(Exception ex)
        {
            System.err.println("Error"+ ex.getMessage());
            System.exit(0);
        }
    }
    
    public void eliminarRegistro(MinecraftEntry registroAEliminar)
    {
        try
        {
            String sentenciaSQL = "DELETE FROM Minecraft where ID=%d;";
            Statement comandoSQL =c.createStatement();
            comandoSQL.executeUpdate
            (
                    String.format(
                            sentenciaSQL,
                            registroAEliminar.getID()
                    )
            );
        }
        catch(Exception ex){
            System.err.println("Error "+ ex.getMessage());
            System.exit(0);
        }
    }
    
}
