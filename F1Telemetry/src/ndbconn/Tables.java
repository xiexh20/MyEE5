/*
 * This file is generated by jOOQ.
 */
package ndbconn;


import ndbconn.tables.Datanames;
import ndbconn.tables.Floatdata;
import ndbconn.tables.Int16data;
import ndbconn.tables.Int32data;
import ndbconn.tables.Int8data;


/**
 * Convenience access to all tables in NewF1DB
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * A table to store different names of the data stored in the data table. 
     */
    public static final Datanames DATANAMES = Datanames.DATANAMES;

    /**
     * A table to store data from UDP packets that have float type.
     */
    public static final Floatdata FLOATDATA = Floatdata.FLOATDATA;

    /**
     * The table <code>NewF1DB.Int16Data</code>.
     */
    public static final Int16data INT16DATA = Int16data.INT16DATA;

    /**
     * A table to store data from UDP packets that have int32 type.
     */
    public static final Int32data INT32DATA = Int32data.INT32DATA;

    /**
     * The table <code>NewF1DB.Int8Data</code>.
     */
    public static final Int8data INT8DATA = Int8data.INT8DATA;
}
