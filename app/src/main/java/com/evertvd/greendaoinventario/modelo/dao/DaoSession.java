package com.evertvd.greendaoinventario.modelo.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.evertvd.greendaoinventario.modelo.Empresa;
import com.evertvd.greendaoinventario.modelo.Inventario;
import com.evertvd.greendaoinventario.modelo.Zona;
import com.evertvd.greendaoinventario.modelo.Zona_has_Inventario;
import com.evertvd.greendaoinventario.modelo.Producto;
import com.evertvd.greendaoinventario.modelo.Conteo;
import com.evertvd.greendaoinventario.modelo.Historial;

import com.evertvd.greendaoinventario.modelo.dao.EmpresaDao;
import com.evertvd.greendaoinventario.modelo.dao.InventarioDao;
import com.evertvd.greendaoinventario.modelo.dao.ZonaDao;
import com.evertvd.greendaoinventario.modelo.dao.Zona_has_InventarioDao;
import com.evertvd.greendaoinventario.modelo.dao.ProductoDao;
import com.evertvd.greendaoinventario.modelo.dao.ConteoDao;
import com.evertvd.greendaoinventario.modelo.dao.HistorialDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig empresaDaoConfig;
    private final DaoConfig inventarioDaoConfig;
    private final DaoConfig zonaDaoConfig;
    private final DaoConfig zona_has_InventarioDaoConfig;
    private final DaoConfig productoDaoConfig;
    private final DaoConfig conteoDaoConfig;
    private final DaoConfig historialDaoConfig;

    private final EmpresaDao empresaDao;
    private final InventarioDao inventarioDao;
    private final ZonaDao zonaDao;
    private final Zona_has_InventarioDao zona_has_InventarioDao;
    private final ProductoDao productoDao;
    private final ConteoDao conteoDao;
    private final HistorialDao historialDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        empresaDaoConfig = daoConfigMap.get(EmpresaDao.class).clone();
        empresaDaoConfig.initIdentityScope(type);

        inventarioDaoConfig = daoConfigMap.get(InventarioDao.class).clone();
        inventarioDaoConfig.initIdentityScope(type);

        zonaDaoConfig = daoConfigMap.get(ZonaDao.class).clone();
        zonaDaoConfig.initIdentityScope(type);

        zona_has_InventarioDaoConfig = daoConfigMap.get(Zona_has_InventarioDao.class).clone();
        zona_has_InventarioDaoConfig.initIdentityScope(type);

        productoDaoConfig = daoConfigMap.get(ProductoDao.class).clone();
        productoDaoConfig.initIdentityScope(type);

        conteoDaoConfig = daoConfigMap.get(ConteoDao.class).clone();
        conteoDaoConfig.initIdentityScope(type);

        historialDaoConfig = daoConfigMap.get(HistorialDao.class).clone();
        historialDaoConfig.initIdentityScope(type);

        empresaDao = new EmpresaDao(empresaDaoConfig, this);
        inventarioDao = new InventarioDao(inventarioDaoConfig, this);
        zonaDao = new ZonaDao(zonaDaoConfig, this);
        zona_has_InventarioDao = new Zona_has_InventarioDao(zona_has_InventarioDaoConfig, this);
        productoDao = new ProductoDao(productoDaoConfig, this);
        conteoDao = new ConteoDao(conteoDaoConfig, this);
        historialDao = new HistorialDao(historialDaoConfig, this);

        registerDao(Empresa.class, empresaDao);
        registerDao(Inventario.class, inventarioDao);
        registerDao(Zona.class, zonaDao);
        registerDao(Zona_has_Inventario.class, zona_has_InventarioDao);
        registerDao(Producto.class, productoDao);
        registerDao(Conteo.class, conteoDao);
        registerDao(Historial.class, historialDao);
    }
    
    public void clear() {
        empresaDaoConfig.clearIdentityScope();
        inventarioDaoConfig.clearIdentityScope();
        zonaDaoConfig.clearIdentityScope();
        zona_has_InventarioDaoConfig.clearIdentityScope();
        productoDaoConfig.clearIdentityScope();
        conteoDaoConfig.clearIdentityScope();
        historialDaoConfig.clearIdentityScope();
    }

    public EmpresaDao getEmpresaDao() {
        return empresaDao;
    }

    public InventarioDao getInventarioDao() {
        return inventarioDao;
    }

    public ZonaDao getZonaDao() {
        return zonaDao;
    }

    public Zona_has_InventarioDao getZona_has_InventarioDao() {
        return zona_has_InventarioDao;
    }

    public ProductoDao getProductoDao() {
        return productoDao;
    }

    public ConteoDao getConteoDao() {
        return conteoDao;
    }

    public HistorialDao getHistorialDao() {
        return historialDao;
    }

}
