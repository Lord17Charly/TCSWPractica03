/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class DAOEmpleados implements IDAOGeneral<Empleados, Long> {

    @Override
    public boolean guardar(Empleados pojo) {
        Session session = null;
        Transaction t = null;
        try {
            session = HibernateUtils.getSession();
            t = session.beginTransaction();
            session.save(pojo);
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Empleados eliminar(Long id) {
       Session session = HibernateUtils.getSession();
    Transaction t = session.beginTransaction();

    Empleados emp = session.get(Empleados.class, id);
    if (emp != null) {
        session.delete(emp); 
    }

    t.commit();
    session.close();

    return emp; 
    }

    @Override
    public Empleados modificar(Empleados pojo, Long id) {
        Session session = HibernateUtils.getSession();
    Transaction t = session.beginTransaction();

    Empleados existente = session.get(Empleados.class, id);

    if (existente != null) {
        
        existente.setNombre(pojo.getNombre());
        existente.setDireccion(pojo.getDireccion());
        existente.setTelefono(pojo.getTelefono());

        session.update(existente);
        t.commit();
    }

    session.close();
    return existente;
    }

    @Override
    public Empleados findByID(Long id) {
        Session session = null;
    try {
        session = HibernateUtils.getSession();
        Empleados emp = session.get(Empleados.class, id);
        return emp; 
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        if (session != null) {
            session.close();
        }
    }
    }

    @Override
    public List<Empleados> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
