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
public interface InterInterServeses <T> {
    void insert(T object);
    void update(T object, int id);
    void delete(int id);
    List FindAll(int idM);
    List FindById(int idM,int idP );
    List searchByPatientName(String name ,int idM);
    //List searchByDescription(String input );
    
    
}
