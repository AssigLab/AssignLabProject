package Impl;

import DAO.LabDAO;
import Interfaces.LabInt;
import Pojo.Course;
import Pojo.Lab;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:48 AM
 */
public class LabImpl implements LabInt {

	public LabDAO m_LabDAO;

    public LabImpl(LabDAO m_LabDAO) {
        this.m_LabDAO = m_LabDAO;
    }

        
    @Override
    public int create(Lab obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Lab obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllLab(Course obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getOneLab(Lab obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Lab obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}