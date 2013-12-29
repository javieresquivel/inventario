/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import clases.InventProducto;
import java.io.Serializable;
/**
 *
 * @author Javier
 */
public class TestProducto {
    
    private Session session;

    public TestProducto() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /**
     * Metodo para obtener todos los jugadores de la base de datos
     * @return
     * @throws Exception impotante colocar getSession.getTransaction().rollback();
     */
        public List<InventProducto> getInventProductoes() throws Exception{
        List<InventProducto> jugador=new ArrayList<InventProducto>();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(InventProducto.class);
        jugador=criteria.list();
        session.getTransaction().commit();
        return jugador;
        }
        /**
         * 
         * @param jugador
         * @throws Exception impotante colocar getSession.getTransaction().rollback(); 
         */
        public void crearInventProducto(InventProducto jugador)throws Exception{ 
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
        public void actualizarInventProducto(InventProducto jugador) throws Exception{
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
        public InventProducto buscar(Serializable id) throws Exception{
            InventProducto a=new InventProducto();
            session.beginTransaction();
            a=(InventProducto) session.get(InventProducto.class, id);
            return a;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }        
}
