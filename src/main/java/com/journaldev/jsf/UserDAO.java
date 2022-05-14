package com.journaldev.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 *
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {


    private static final String SELECT_ALL_CHITATELI = "select NumberChitatelya,NumberBileta,FamiliyaImyaOtchestvo,Address,TelephoneRab,TelephoneDom FROM books.chitateli";
    private static final String SELECT_ALL_USERS = "select books.books.NumberKnigi,books.books.Chif,books.books.Nazvanie,books.books.Avtor,books.books.MestoIzdaniya,books.books.Izadtelstvo,books.books.YearIzdaniya,books.books.KolStranic from books.books";
    private static final String SQL_INSERT_PILOT = "INSERT INTO books.chitateli(NumberChitatelya, NumberBileta, FamiliyaImyaOtchestvo,Address,TelephoneRab,TelephoneDom) VALUES(?, ?, ?,?, ?, ?)";
    public UserDAO() {}



    public List<Books> pilotsList () {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Books pilot = null;
        List<Books> pilots = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL_USERS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int NumberKnigi = rs.getInt(1);
                String Chif = rs.getString(2);
                String Nazvanie = rs.getString(3);
                String Avtor = rs.getString(4);
                String MestoIzdaniya = rs.getString(5);
                String Izdatelstvo = rs.getString(6);
                Date YearIzdaniya = rs.getDate(7);
                int KolStranic = rs.getInt(8);
                pilot = new Books(NumberKnigi, Chif, Nazvanie,Avtor,MestoIzdaniya,Izdatelstvo,YearIzdaniya,KolStranic);
                pilots.add(pilot);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionDB.Close(rs);
            ConnectionDB.Close(stmt);
            ConnectionDB.Close(conn);
        }

        return pilots;
    } //end of pilotList method


    public List<Chitateli> chitateliList () {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Chitateli pilot = null;
        List<Chitateli> pilots = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL_CHITATELI);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int NumberChitatelya = rs.getInt(1);
                int NumberBileta = rs.getInt(2);
                String FamiliyaImyaOtchestvo = rs.getString(3);
                String Address = rs.getString(4);
                int TelephoneRab = rs.getInt(5);
                int TelephoneDom = rs.getInt(6);

                pilot = new Chitateli(NumberChitatelya,NumberBileta,FamiliyaImyaOtchestvo,Address,TelephoneRab,TelephoneDom);
                pilots.add(pilot);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionDB.Close(rs);
            ConnectionDB.Close(stmt);
            ConnectionDB.Close(conn);
        }

        return pilots;
    } //end of pilotList method

    public int insertPilot (Chitateli chitateli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PILOT);
            stmt.setInt(1, chitateli.getNumberChitatelya());
            stmt.setInt(2, chitateli.getNumberBileta());
            stmt.setString(3, chitateli.getFamiliyaImyaOtchestvo());
            stmt.setString(4, chitateli.getAddress());
            stmt.setInt(5, chitateli.getTelephoneRab());
            stmt.setInt(6, chitateli.getTelephoneDom());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionDB.Close(stmt);
            ConnectionDB.Close(conn);
        }

        return rows;
    } //end of insertPilot method

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}