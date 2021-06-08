/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.proyecto.dao;

/**
 *
 * @author ikero
 */
public class MinecraftEntry {

    /**
     * @return the _ID
     */
    public int getID() {
        return _ID;
    }

    /**
     * @param _ID the _ID to set
     */
    public void setID(int _ID) {
        this._ID = _ID;
    }

    /**
     * @return the _MinecraftBlockName
     */
    public String getMinecraftBlockName() {
        return _MinecraftBlockName;
    }

    /**
     * @param _MinecraftBlockName the _MinecraftBlockName to set
     */
    public void setMinecraftBlockName(String _MinecraftBlockName) {
        this._MinecraftBlockName = _MinecraftBlockName;
    }

    /**
     * @return the _MinecraftCraftReceipt
     */
    public String getMinecraftCraftReceipt() {
        return _MinecraftCraftReceipt;
    }

    /**
     * @param _MinecraftCraftReceipt the _MinecraftCraftReceipt to set
     */
    public void setMinecraftCraftReceipt(String _MinecraftCraftReceipt) {
        this._MinecraftCraftReceipt = _MinecraftCraftReceipt;
    }

    /**
     * @return the _MincraftAttack
     */
    public int getMincraftAttack() {
        return _MincraftAttack;
    }

    /**
     * @param _MincraftAttack the _MincraftAttack to set
     */
    public void setMincraftAttack(int _MincraftAttack) {
        this._MincraftAttack = _MincraftAttack;
    }

    /**
     * @return the _MinecraftDefense
     */
    public int getMinecraftDefense() {
        return _MinecraftDefense;
    }

    /**
     * @param _MinecraftDefense the _MinecraftDefense to set
     */
    public void setMinecraftDefense(int _MinecraftDefense) {
        this._MinecraftDefense = _MinecraftDefense;
    }

    /**
     * @return the _Minecraft
     */
    public int getMinecraft() {
        return _Minecraft;
    }

    /**
     * @param _Minecraft the _Minecraft to set
     */
    public void setMinecraft(int _Minecraft) {
        this._Minecraft = _Minecraft;
    }
    private int _ID;
    private String _MinecraftBlockName;
    private String _MinecraftCraftReceipt;
    private int _MincraftAttack;
    private int _MinecraftDefense;
    private int _Minecraft;
    
     public String getFormattedText(){
         return String.format(
                 "%d\t%-20s\t%-20s\t%-20d\t%-20d\t%-20d", 
                 _ID,
                 _MinecraftBlockName, 
                 _MinecraftCraftReceipt,
                 _MincraftAttack, 
                 _MinecraftDefense,
                 _Minecraft);
     }

}
