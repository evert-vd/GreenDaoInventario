package com.evertvd.greendaoinventario.modelo.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.evertvd.greendaoinventario.modelo.Inventario;
import com.evertvd.greendaoinventario.modelo.Zona;

import com.evertvd.greendaoinventario.modelo.Zona_has_Inventario;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ZONA_HAS__INVENTARIO".
*/
public class Zona_has_InventarioDao extends AbstractDao<Zona_has_Inventario, Void> {

    public static final String TABLENAME = "ZONA_HAS__INVENTARIO";

    /**
     * Properties of entity Zona_has_Inventario.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property NombreZona = new Property(0, String.class, "nombreZona", false, "NOMBRE_ZONA");
        public final static Property Inventario_id2 = new Property(1, Long.class, "inventario_id2", false, "INVENTARIO_ID2");
        public final static Property Zona_id2 = new Property(2, Long.class, "zona_id2", false, "ZONA_ID2");
    }

    private DaoSession daoSession;

    private Query<Zona_has_Inventario> inventario_Zona_has_InventarioListQuery;
    private Query<Zona_has_Inventario> zona_Zona_has_InventarioListQuery;

    public Zona_has_InventarioDao(DaoConfig config) {
        super(config);
    }
    
    public Zona_has_InventarioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ZONA_HAS__INVENTARIO\" (" + //
                "\"NOMBRE_ZONA\" TEXT," + // 0: nombreZona
                "\"INVENTARIO_ID2\" INTEGER," + // 1: inventario_id2
                "\"ZONA_ID2\" INTEGER);"); // 2: zona_id2
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_ZONA_HAS__INVENTARIO_INVENTARIO_ID2 ON ZONA_HAS__INVENTARIO" +
                " (\"INVENTARIO_ID2\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ZONA_HAS__INVENTARIO_ZONA_ID2 ON ZONA_HAS__INVENTARIO" +
                " (\"ZONA_ID2\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ZONA_HAS__INVENTARIO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Zona_has_Inventario entity) {
        stmt.clearBindings();
 
        String nombreZona = entity.getNombreZona();
        if (nombreZona != null) {
            stmt.bindString(1, nombreZona);
        }
 
        Long inventario_id2 = entity.getInventario_id2();
        if (inventario_id2 != null) {
            stmt.bindLong(2, inventario_id2);
        }
 
        Long zona_id2 = entity.getZona_id2();
        if (zona_id2 != null) {
            stmt.bindLong(3, zona_id2);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Zona_has_Inventario entity) {
        stmt.clearBindings();
 
        String nombreZona = entity.getNombreZona();
        if (nombreZona != null) {
            stmt.bindString(1, nombreZona);
        }
 
        Long inventario_id2 = entity.getInventario_id2();
        if (inventario_id2 != null) {
            stmt.bindLong(2, inventario_id2);
        }
 
        Long zona_id2 = entity.getZona_id2();
        if (zona_id2 != null) {
            stmt.bindLong(3, zona_id2);
        }
    }

    @Override
    protected final void attachEntity(Zona_has_Inventario entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Zona_has_Inventario readEntity(Cursor cursor, int offset) {
        Zona_has_Inventario entity = new Zona_has_Inventario( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // nombreZona
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // inventario_id2
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // zona_id2
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Zona_has_Inventario entity, int offset) {
        entity.setNombreZona(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setInventario_id2(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setZona_id2(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Zona_has_Inventario entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Zona_has_Inventario entity) {
        return null;
    }

    @Override
    public boolean hasKey(Zona_has_Inventario entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "zona_has_InventarioList" to-many relationship of Inventario. */
    public List<Zona_has_Inventario> _queryInventario_Zona_has_InventarioList(Long inventario_id2) {
        synchronized (this) {
            if (inventario_Zona_has_InventarioListQuery == null) {
                QueryBuilder<Zona_has_Inventario> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Inventario_id2.eq(null));
                inventario_Zona_has_InventarioListQuery = queryBuilder.build();
            }
        }
        Query<Zona_has_Inventario> query = inventario_Zona_has_InventarioListQuery.forCurrentThread();
        query.setParameter(0, inventario_id2);
        return query.list();
    }

    /** Internal query to resolve the "zona_has_InventarioList" to-many relationship of Zona. */
    public List<Zona_has_Inventario> _queryZona_Zona_has_InventarioList(Long zona_id2) {
        synchronized (this) {
            if (zona_Zona_has_InventarioListQuery == null) {
                QueryBuilder<Zona_has_Inventario> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Zona_id2.eq(null));
                zona_Zona_has_InventarioListQuery = queryBuilder.build();
            }
        }
        Query<Zona_has_Inventario> query = zona_Zona_has_InventarioListQuery.forCurrentThread();
        query.setParameter(0, zona_id2);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getInventarioDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getZonaDao().getAllColumns());
            builder.append(" FROM ZONA_HAS__INVENTARIO T");
            builder.append(" LEFT JOIN INVENTARIO T0 ON T.\"INVENTARIO_ID2\"=T0.\"_id\"");
            builder.append(" LEFT JOIN ZONA T1 ON T.\"ZONA_ID2\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Zona_has_Inventario loadCurrentDeep(Cursor cursor, boolean lock) {
        Zona_has_Inventario entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Inventario inventario = loadCurrentOther(daoSession.getInventarioDao(), cursor, offset);
        entity.setInventario(inventario);
        offset += daoSession.getInventarioDao().getAllColumns().length;

        Zona zona = loadCurrentOther(daoSession.getZonaDao(), cursor, offset);
        entity.setZona(zona);

        return entity;    
    }

    public Zona_has_Inventario loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Zona_has_Inventario> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Zona_has_Inventario> list = new ArrayList<Zona_has_Inventario>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Zona_has_Inventario> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Zona_has_Inventario> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
