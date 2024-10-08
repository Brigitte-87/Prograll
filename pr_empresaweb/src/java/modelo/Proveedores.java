/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;



public class Proveedores {
    private int id_proveedores;
    private String proveedor;
    private String nit;
    private String direccion;
    private String telefono;
    
    private Conexion cn;
    public Proveedores(){}
    public Proveedores(int id_proveedores, String proveedor, String nit, String direccion, String telefono) {
        this.id_proveedores = id_proveedores;
        this.proveedor = proveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public HashMap drop_proveedor(){
        HashMap<String,String> drop = new HashMap();
        try{
            String query = "select id_proveedores, proveedor from proveedor;";
            cn = new Conexion();
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
            drop.put(consulta.getString("id_proveedores"), consulta.getString("proveedor"));
            }
        }catch(SQLException ex){
            System.out.println("error drop_proveedor: " + ex.getMessage());
        }
        return drop;
        
    }    

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }
}

