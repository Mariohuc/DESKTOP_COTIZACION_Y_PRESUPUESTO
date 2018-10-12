/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Generator; 
import javax.swing.table.DefaultTableModel;  
/** 
 * 
 * @author whyem 
 */  
public class CustomDefaultTableModel extends DefaultTableModel{  
    /** 
     * Sobreescribe el método isCellEditable de DefaultTableModel, 
     * para que las celdas no sean editables. 
     *  
     * @param data
     * @param columnNames 
     */
    public CustomDefaultTableModel(Object[][] data, Object[] columnNames){
        super(data,columnNames);
    }

    public CustomDefaultTableModel() {
        super();
    }
    @Override
    public boolean isCellEditable (int row, int column)  
    {        
        return false;
    }  
    
  
} 