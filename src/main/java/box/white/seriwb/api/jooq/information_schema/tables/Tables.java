/*
 * This file is generated by jOOQ.
*/
package box.white.seriwb.api.jooq.information_schema.tables;


import box.white.seriwb.api.jooq.information_schema.InformationSchema;
import box.white.seriwb.api.jooq.information_schema.tables.records.TablesRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables extends TableImpl<TablesRecord> {

    private static final long serialVersionUID = 61282850;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.TABLES</code>
     */
    public static final Tables TABLES = new Tables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TablesRecord> getRecordType() {
        return TablesRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TABLE_CATALOG</code>.
     */
    public final TableField<TablesRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TABLE_SCHEMA</code>.
     */
    public final TableField<TablesRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TABLE_NAME</code>.
     */
    public final TableField<TablesRecord, String> TABLE_NAME = createField("TABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TABLE_TYPE</code>.
     */
    public final TableField<TablesRecord, String> TABLE_TYPE = createField("TABLE_TYPE", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.STORAGE_TYPE</code>.
     */
    public final TableField<TablesRecord, String> STORAGE_TYPE = createField("STORAGE_TYPE", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.SQL</code>.
     */
    public final TableField<TablesRecord, String> SQL = createField("SQL", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.REMARKS</code>.
     */
    public final TableField<TablesRecord, String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.LAST_MODIFICATION</code>.
     */
    public final TableField<TablesRecord, Long> LAST_MODIFICATION = createField("LAST_MODIFICATION", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.ID</code>.
     */
    public final TableField<TablesRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TYPE_NAME</code>.
     */
    public final TableField<TablesRecord, String> TYPE_NAME = createField("TYPE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.TABLE_CLASS</code>.
     */
    public final TableField<TablesRecord, String> TABLE_CLASS = createField("TABLE_CLASS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.TABLES.ROW_COUNT_ESTIMATE</code>.
     */
    public final TableField<TablesRecord, Long> ROW_COUNT_ESTIMATE = createField("ROW_COUNT_ESTIMATE", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.TABLES</code> table reference
     */
    public Tables() {
        this(DSL.name("TABLES"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.TABLES</code> table reference
     */
    public Tables(String alias) {
        this(DSL.name(alias), TABLES);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.TABLES</code> table reference
     */
    public Tables(Name alias) {
        this(alias, TABLES);
    }

    private Tables(Name alias, Table<TablesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Tables(Name alias, Table<TablesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tables as(String alias) {
        return new Tables(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tables as(Name alias) {
        return new Tables(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tables rename(String name) {
        return new Tables(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tables rename(Name name) {
        return new Tables(name, null);
    }
}
