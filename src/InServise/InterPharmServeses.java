/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InServise;

import java.util.List;

/**
 *
 * @author lenovo
 */
public interface InterPharmServeses <T> {
    void insert(T object);
    void update(T object, int id);
    void delete(int id);
    List FindAll();
    List FindById(int id );
    List searchByName(String name );
   
    void bloqueFARM(int id);
     boolean exist(int id);
    boolean isblocked(int id);
    
  
    

}
