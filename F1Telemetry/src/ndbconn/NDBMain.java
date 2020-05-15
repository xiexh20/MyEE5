/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndbconn;

import com.sun.security.auth.NTDomainPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
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
            
            
//            dbContext.insertInto(TN, TN.NAME)
//                    .values("Test name")
//                    .execute();
//            
//            Result<Record> result = dbContext.select()
//                    .from(TN)
//                    .where(TN.NAME.eq("Test name"))
//                    .fetch();
//            for(Record r:result){
//                int id = r.getValue(TN.IDNAME);
//                String name = r.getValue(TN.NAME);
//                System.out.println("Name: "+name+" id="+id);
//            }
            
            // insert all necessary data names into database 
            List<String> dataNames = new ArrayList();
            
            // int8 data names add here
//            dataNames.add("steer");
//            dataNames.add("brake");
//            dataNames.add("throttle");
//            dataNames.add("drs");
//            dataNames.add("penalties");
//            
//            // int 16 data names add here
//            dataNames.add("speed");
//            
//            // int 32 data names
//            dataNames.add("buttonStatus");
//            
//            // float data names
//            dataNames.add("gForceLateral");
//            dataNames.add("gForceLongitudinal");
//            dataNames.add("gForceVertical");
//            // from lapdata packet
//            dataNames.add("lastLapTime");
//            dataNames.add("currentLapTime");
//            dataNames.add("bestLapTime");
//            dataNames.add("lapDistance");
//            dataNames.add("totalDistance");
//            dataNames.add("currentLapNum");
//            
//            // insert them into database
//            for(String name:dataNames){
//                dbContext.insertInto(TN, TN.NAME)
//                        .values(name)
//                        .execute();
//            }
            
            // check if insert correctly
            Result<DatanamesRecord> result = dbContext.selectFrom(TN).fetch();
            for(DatanamesRecord r: result){
                
                System.out.println("id="+r.getIdname() + ", name="+r.getValue(TN.NAME));
            }
            
            
                    

            
            
            

        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
