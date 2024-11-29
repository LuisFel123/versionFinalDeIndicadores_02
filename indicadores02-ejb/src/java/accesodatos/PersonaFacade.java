/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author felip
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "indicadores02-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*
    public Persona persona_usu_pas(String usuario, String password) {
        Persona persona = null;
        try {
            Query consultaup = em.createNamedQuery("Persona.findByUsuarioPassword");
            consultaup.setParameter("usuario", usuario);
            consultaup.setParameter("password", password);
            persona = (Persona) consultaup.getSingleResult();
        } catch (Exception e) {return null;}
        return persona;
    }
     */
    public Persona persona_usu_pas(String usuario) {
        Persona persona = null;
        try {
            Query consultaup = em.createNamedQuery("Persona.findByUsuarioPassword");
            consultaup.setParameter("usuario", usuario);
            persona = (Persona) consultaup.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return persona;
    }

    public Persona persona_usuario(String u) {
        Persona persona = null;
        try {
            Query consultaup = em.createNamedQuery("Persona.findByUsuario");
            consultaup.setParameter("usuario",u);
            persona = (Persona) consultaup.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return persona;

    }

    public PersonaFacade() {
        super(Persona.class);
    }

}
