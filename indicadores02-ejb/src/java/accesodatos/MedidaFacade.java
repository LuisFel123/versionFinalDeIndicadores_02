/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Medida;

/**
 *
 * @author felip
 */
@Stateless
public class MedidaFacade extends AbstractFacade<Medida> {

    @PersistenceContext(unitName = "indicadores02-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedidaFacade() {
        super(Medida.class);
    }
    
}
