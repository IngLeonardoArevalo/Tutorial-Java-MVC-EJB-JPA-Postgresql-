/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesEJB;

import Entidades.Moneda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leonardo Arevalo
 */
@Local
public interface MonedaFacadeLocal {

    void create(Moneda moneda);

    void edit(Moneda moneda);

    void remove(Moneda moneda);

    Moneda find(Object id);

    List<Moneda> findAll();

    List<Moneda> findRange(int[] range);

    int count();
    
}
