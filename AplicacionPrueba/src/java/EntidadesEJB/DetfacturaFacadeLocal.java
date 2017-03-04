/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesEJB;

import Entidades.Detfactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leonardo Arevalo
 */
@Local
public interface DetfacturaFacadeLocal {

    void create(Detfactura detfactura);

    void edit(Detfactura detfactura);

    void remove(Detfactura detfactura);

    Detfactura find(Object id);

    List<Detfactura> findAll();

    List<Detfactura> findRange(int[] range);

    int count();
    
}
