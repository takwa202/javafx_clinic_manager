/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InServise;

import entity.Medcin;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface InterMedServeses <T> {
    void insert(T object);
    void update(T object, int id);
    void delete(int id);
    boolean exist(int id);
     boolean isblocked(int id);
    List FindAll();
    Medcin FindById(int id );
     Medcin searchByName(String name );
    List searchBySpeciality(String name );
    void bloqueMed(int id);
    
  
    
}
