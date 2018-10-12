/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Generator;
import java.io.Serializable;

/**
 *
 * @author MARIO HUAYPUNA
 */
public class GeneradorCodigos implements Serializable {
    
    private int cias;
    private int clientes;
    private int articulos;
    private int vendedores;
    private int sucursales;
    private int cotizacion_cab;
    private int cotizacion_det;

    public GeneradorCodigos(){}
    
    public void inicializar(){
        cias = 110001;
        clientes = 150001;
        articulos = 16010001;
        vendedores = 170001;
        sucursales = 10;
        cotizacion_cab = 181001;
        cotizacion_det = 190001;
    }
    
    public void setIDcia( int n ){
        cias = n;
    }
    public void setIDcliente( int n ){
        clientes = n;
    }
    public void setIDarticulo( int n ){
        articulos = n;
    }
    public void setIDvendedores( int n ){
        vendedores = n;
    }
    public void setIDsucursales( int n ){
        sucursales = n;
    }
    public void setIDcotizacionCab( int n ){
        cotizacion_cab = n;
    }
    public void setIDcotizacionDet( int n ){
        cotizacion_det = n;
    }
    //%   funciones de generacion de codigos 
    public int generarCodCia(){
        return cias++;
    }
    public int generarCodCliente(){
        return clientes++;
    }
    public int generarCodArticulo(){
        return articulos++;
    }
    public int generarCodVendedores(){
        return vendedores++;
    }
    public int generarCodSucursales(){
        return sucursales++;
    }
    public int generarCodCotCab(){
        return cotizacion_cab++;
    }
    public int generarCodCotDet(){
        return cotizacion_det++;
    }
}
