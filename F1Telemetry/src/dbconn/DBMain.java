/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import dbconn.Tables;

/**
 * main class for interaction with the database
 * @author 25691
 */
public class DBMain {
    
    private static final String USER = "xiexh";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/F1GameDB";
    
    public static void main(String[] args)
    {
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
//            create.insertInto(Tables.DRIVERS, Tables.DRIVERS.IDDRIVER, Tables.DRIVERS.DRIVERNAME)
//                    .values((short)100, "first from jOOQ")
//                    .execute();
//            create.insertInto(Tables.TRACKS, Tables.TRACKS.IDTRACK, Tables.TRACKS.TRACKNAME)
//                    .values((short)20, "Shanghai")
//                    .execute();
            // TODO: error handler
            for(int i = 10;i<100;i++)
            {
                create.insertInto(Tables.PLAYERS, Tables.PLAYERS.IDPLAYER, Tables.PLAYERS.PLAYERNAME)
                        .values(i, "Player"+i)
                        .execute();
            }
//            Result<Record> result = create.select().from(AUTHOR).fetch();

//            for (Record r : result) {
//                Integer id = r.getValue(AUTHOR.ID);
//                String firstName = r.getValue(AUTHOR.FIRST_NAME);
//                String lastName = r.getValue(AUTHOR.LAST_NAME);
//
//                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
//            }

        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
