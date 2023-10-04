/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author david
 */
public class Pedido {
    private int id;
    private Date fechapedido;
    private float total;
    private int clienteID;

    public Pedido() {
    }
    
    public Pedido(Date fechapedido, float total, int clienteID) {
        this.fechapedido = fechapedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public Pedido(int id, Date fechapedido, float total, int clienteID) {
        this.id = id;
        this.fechapedido = fechapedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public int getId() {
        return id;
    }        

    public Date getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Date fechapedido) {
        this.fechapedido = fechapedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }        
    
}
