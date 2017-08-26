package com.evertvd.greendaoinventario.modelo;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import com.evertvd.greendaoinventario.modelo.dao.DaoSession;
import org.greenrobot.greendao.DaoException;

import com.evertvd.greendaoinventario.modelo.dao.ProductoDao;
import com.evertvd.greendaoinventario.modelo.dao.ZonaDao;
import com.evertvd.greendaoinventario.modelo.dao.Zona_has_InventarioDao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "ZONA".
 */
@Entity(active = true)
public class Zona {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String nombre;
    private Integer diferencia;
    private Integer estado;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient ZonaDao myDao;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "zona_id2")
    })
    private List<Zona_has_Inventario> zona_has_InventarioList;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "zona_id")
    })
    private List<Producto> productoList;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Zona() {
    }

    public Zona(Long id) {
        this.id = id;
    }

    @Generated
    public Zona(Long id, String nombre, Integer diferencia, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.diferencia = diferencia;
        this.estado = estado;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getZonaDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Integer diferencia) {
        this.diferencia = diferencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Zona_has_Inventario> getZona_has_InventarioList() {
        if (zona_has_InventarioList == null) {
            __throwIfDetached();
            Zona_has_InventarioDao targetDao = daoSession.getZona_has_InventarioDao();
            List<Zona_has_Inventario> zona_has_InventarioListNew = targetDao._queryZona_Zona_has_InventarioList(id);
            synchronized (this) {
                if(zona_has_InventarioList == null) {
                    zona_has_InventarioList = zona_has_InventarioListNew;
                }
            }
        }
        return zona_has_InventarioList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetZona_has_InventarioList() {
        zona_has_InventarioList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<Producto> getProductoList() {
        if (productoList == null) {
            __throwIfDetached();
            ProductoDao targetDao = daoSession.getProductoDao();
            List<Producto> productoListNew = targetDao._queryZona_ProductoList(id);
            synchronized (this) {
                if(productoList == null) {
                    productoList = productoListNew;
                }
            }
        }
        return productoList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetProductoList() {
        productoList = null;
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public String toString() {
        return nombre;
    }
    // KEEP METHODS END

}
