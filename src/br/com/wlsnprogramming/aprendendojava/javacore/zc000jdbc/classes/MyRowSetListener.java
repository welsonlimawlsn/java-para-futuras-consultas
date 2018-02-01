package br.com.wlsnprogramming.aprendendojava.javacore.zc000jdbc.classes;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

public class MyRowSetListener implements RowSetListener {
    /**
     * Notifies registered listeners that a <code>RowSet</code> object
     * in the given <code>RowSetEvent</code> object has changed its entire contents.
     * <p>
     * The source of the event can be retrieved with the method
     * <code>event.getSource</code>.
     *
     * @param event a <code>RowSetEvent</code> object that contains
     *              the <code>RowSet</code> object that is the source of the event
     */
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("Comando execute");
    }

    /**
     * Notifies registered listeners that a <code>RowSet</code> object
     * has had a change in one of its rows.
     * <p>
     * The source of the event can be retrieved with the method
     * <code>event.getSource</code>.
     *
     * @param event a <code>RowSetEvent</code> object that contains
     *              the <code>RowSet</code> object that is the source of the event
     */
    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Linha foi atualizada, inserida ou deletada");
        if(event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Notifies registered listeners that a <code>RowSet</code> object's
     * cursor has moved.
     * <p>
     * The source of the event can be retrieved with the method
     * <code>event.getSource</code>.
     *
     * @param event a <code>RowSetEvent</code> object that contains
     *              the <code>RowSet</code> object that is the source of the event
     */
    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("O cursor se moveu");
    }
}
