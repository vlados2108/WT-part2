package by.bsuir.wt.fourth.dao;

import by.bsuir.wt.fourth.dao.impl.ApartamentDaoImpl;
import by.bsuir.wt.fourth.dao.impl.RoleDaoImpl;
import by.bsuir.wt.fourth.dao.impl.UserDaoImpl;
import by.bsuir.wt.fourth.dao.impl.UserInformationDaoImpl;
import by.bsuir.wt.fourth.dao.impl.UserOrderDaoImpl;


public class DaoFactory {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();
    private final UserOrderDaoImpl userOrderDao=new UserOrderDaoImpl();
    private final ApartamentDaoImpl apartamentDao=new ApartamentDaoImpl();

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public RoleDaoImpl getRoleDao() {
        return roleDao;
    }

    public UserInformationDaoImpl getUserInformationDao() {
        return userInformationDao;
    }

    public UserOrderDaoImpl getUserOrderDao() {
        return userOrderDao;
    }

    public ApartamentDaoImpl getApartamentDao() {
        return apartamentDao;
    }

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }


    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}