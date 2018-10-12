/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relaciones;

/**
 *
 * @author MARIO HUAYPUNA
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class FileGeneradorCodigos {
    
    private GeneradorCodigos actual;
    
    public GeneradorCodigos getGenerador( ){
        return actual;
    }
    
    public void escribir( GeneradorCodigos nuevo )
    {
        try {
            //Objeto a guardar en archivo *.DAT
            actual = nuevo;
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( "generadorCods.dat" ));
            //Se escribe el objeto en archivo
            file.writeObject(actual);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void leer()
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( "generadorCods.dat" ));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            actual = (GeneradorCodigos) file.readObject();
            //se cierra archivo
            file.close();
            //Se utilizan metodos de la clase asi como variables guardados en el objeto
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
        } catch (IOException ex) {
             System.out.println(ex);
       }
    }

}
