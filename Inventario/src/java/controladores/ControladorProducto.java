/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.InventProducto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import testeos.TestProducto;

/**
 *
 * @author Javier
 */
public class ControladorProducto {
    
    private InventProducto producto;
    private List<InventProducto> listaProductos;
    private InventProducto productoSeleccionado;

    /** Creates a new instance of ControladorProducto */
    public ControladorProducto() {
        producto=new InventProducto();
//        productoSeleccionado=new InventProducto();
        producto.setDescripcion("Ninguna");
        obtenerProductos();
    }
    
    public void obtenerProductos(){
        TestProducto testProducto=new TestProducto();
        try {
            listaProductos= testProducto.getInventProductoes();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se logro obtener los productos "));
        }
    }

    public void agregarProducto(){
        try {
            TestProducto testProducto=new TestProducto();
            testProducto.crearInventProducto(producto);
            producto=new InventProducto();
            producto.setDescripcion("Ninguna");
            obtenerProductos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado Exitosamente !! "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se logro almacenar el Producto "));
        }
    }
    
    public InventProducto getProducto() {
        return producto;
    }

    public void setProducto(InventProducto producto) {
        this.producto = producto;
    }

    public List<InventProducto> getListaProductos() {
        obtenerProductos();
        return listaProductos;
    }

    public void setListaProductos(List<InventProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public InventProducto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(InventProducto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    } 
}
