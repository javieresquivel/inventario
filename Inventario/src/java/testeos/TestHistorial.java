/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import clases.InventHistorial;
import java.io.Serializable;
/**
 *
 * @author Javier
 */
public class TestHistorial {
    
    private Session session;

    public TestHistorial() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /**
     * Metodo para obtener todos los jugadores de la base de datos
     * @return
     * @throws Exception impotante colocar getSession.getTransaction().rollback();
     */
        public List<InventHistorial> getInventHistoriales() throws Exception{
        List<InventHistorial> jugador=new ArrayList<InventHistorial>();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(InventHistorial.class);
        jugador=criteria.list();
        session.getTransaction().commit();
        return jugador;
        }
        /**
         * 
         * @param jugador
         * @throws Exception impotante colocar getSession.getTransaction().rollback(); 
         */
        public void crearInventHistorial(InventHistorial jugador)throws Exception{ 
                org.hibernate.Transaction transaction=session.beginTransaction();
                session.save(jugador);
                transaction.commit();
                //session.close();            
        }
        /**
         * 
         * @param jugador
         * @throws Exception impotante colocar getSession.getTransaction().rollback();
         */
        public void actualizarInventHistorial(InventHistorial jugador) throws Exception{
                org.hibernate.Transaction transaction=session.beginTransaction();
                session.update(jugador);
                transaction.commit();
        }
        /**
         * 
         * @param id
         * @return
         * @throws Exception impotante colocar getSession.getTransaction().rollback();
         */
        public InventHistorial buscar(Serializable id) throws Exception{
            InventHistorial a=new InventHistorial();
            session.beginTransaction();
            a=(InventHistorial) session.get(InventHistorial.class, id);
            return a;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }        
}
