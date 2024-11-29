/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import accesodatos.PersonaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Persona;

/**
 *
 * @author felip
 */
@Stateless
@LocalBean
public class MDPersona {

    @EJB
    private PersonaFacade personaFacade;

    public void registrarPersona(Persona p) {
        personaFacade.create(p);
    }

    public List<Persona> personas() {
        return personaFacade.findAll();
    }

    public void eliminarP(Persona p) {
        Persona personaExistente = personaFacade.find(p.getIdPersona());

        if (personaExistente != null) {
            personaFacade.remove(personaExistente);
        } else {
            System.out.println("La persona no existe en la base de datos.");
            throw new IllegalArgumentException("Persona no encontrada.");
        }
    }

    public Persona personaUpLogin(Persona p) {
        return personaFacade.persona_usu_pas_login(p.getUsuario(), p.getPassword());
    }

    public Persona personaUp(Persona p) {
        return personaFacade.persona_usu_pas(p.getUsuario());
    }

    public Persona personauUsuario(Persona p) {
        return personaFacade.persona_usuario(p.getUsuario());
    }

}
