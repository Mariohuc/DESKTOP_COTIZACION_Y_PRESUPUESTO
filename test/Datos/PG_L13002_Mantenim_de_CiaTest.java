/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import DB.Conector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lab02-05
 */
public class PG_L13002_Mantenim_de_CiaTest {
    
    public PG_L13002_Mantenim_de_CiaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Conector.ChangeToTestMode();
    }
    
    @After
    public void tearDown() {
        Conector.ChangeToNormalMode();
    }

    /**
     * Test of agregarCia method, of class PG_L13002_Mantenim_de_Cia.
     */
    @Test
    public void testAgregarCia() {
        System.out.println("agregarCia");
        int ciaCod = 0;
        String ciaNom = "";
        String Ruc = "";
        String estReg = "";
        PG_L13002_Mantenim_de_Cia instance = new PG_L13002_Mantenim_de_Cia();
        int expResult = 0;
        int result = instance.agregarCia(ciaCod, ciaNom, Ruc, estReg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarCia method, of class PG_L13002_Mantenim_de_Cia.
     */
    @Test
    public void testActualizarCia() {
        System.out.println("ActualizarCia");
        int ciaCod = 0;
        String ciaNom = "";
        String Ruc = "";
        String estReg = "";
        PG_L13002_Mantenim_de_Cia instance = new PG_L13002_Mantenim_de_Cia();
        int expResult = 0;
        int result = instance.ActualizarCia(ciaCod, ciaNom, Ruc, estReg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarCia method, of class PG_L13002_Mantenim_de_Cia.
     */
    @Test
    public void testEliminarCia() {
        System.out.println("EliminarCia");
        int ciaCod = 0;
        PG_L13002_Mantenim_de_Cia instance = new PG_L13002_Mantenim_de_Cia();
        int expResult = 0;
        int result = instance.EliminarCia(ciaCod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasLasCiasQueEsten method, of class PG_L13002_Mantenim_de_Cia.
     */
    @Test
    public void testObtenerTodasLasCiasQueEsten() {
        System.out.println("obtenerTodasLasCiasQueEsten");
        String criterio_seleccion = "";
        PG_L13002_Mantenim_de_Cia instance = new PG_L13002_Mantenim_de_Cia();
        Object[][] expResult = null;
        Object[][] result = instance.obtenerTodasLasCiasQueEsten(criterio_seleccion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class PG_L13002_Mantenim_de_Cia.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        PG_L13002_Mantenim_de_Cia instance = new PG_L13002_Mantenim_de_Cia();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
