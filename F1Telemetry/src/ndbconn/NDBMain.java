/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import ndbconn.tables.Datanames;
import ndbconn.tables.Int8data;
import ndbconn.tables.records.DatanamesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author 25691
 */
public class NDBMain {
    
    private static final String USER = "xiexh";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/NewF1DB";
    
    public static void main(String[] args)
    {
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DSLContext dbContext = DSL.using(conn, SQLDialect.MYSQL);
            Datanames TN = ndbconn.Tables.DATANAMES;
            Int8data T8 = ndbconn.Tables.INT8DATA;
            
            
            dbContext.insertInto(TN, TN.NAME)
                    .values("Test name")
                    .execute();
            
            Result<Record> result = dbContext.select()
                    .from(TN)
                    .where(TN.NAME.eq("Test name"))
                    .fetch();
            for(Record r:result){
                int id = r.getValue(TN.IDNAME);
                String name = r.getValue(TN.NAME);
                System.out.println("Name: "+name+" id="+id);
            }
            
            

            
            
            

        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
