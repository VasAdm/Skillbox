import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class XMLParserSAX extends DefaultHandler {

    private static final int BATCH_SIZE = 100000;
    private static StringBuilder insertQuery = new StringBuilder();
    private static int counter = 0;

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String dbName = "learn";
                String dbUser = "root";
                String dbPass = "QwEr3466";

                connection = DriverManager.getConnection(
                        "jdbc:mysql://62.148.227.113:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count_tmp");

                connection.createStatement().execute("CREATE TABLE voter_count_tmp(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "PRIMARY KEY(id))");

                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {
            countVoter(attributes.getValue("name"), attributes.getValue("birthDay"));
            counter++;

            if (counter == BATCH_SIZE) {
                writeVotersToDB();
            }
        }
    }


    @Override
    public void endDocument() {
        if (insertQuery.length() != 0) {
            writeVotersToDB();

            try {
                calculateMultiVoting();
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count_tmp");
                printVoterCounts();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count_tmp(name, birthDate) VALUES" +
                insertQuery.substring(1);

        getConnection().createStatement().execute(sql);
    }

    private static void countVoter(String name, String birthDay) {
        insertQuery.append(",").append("('").append(name).append("','").append(birthDay).append("')");
    }

    private static void writeVotersToDB() {
        try {
            executeMultiInsert();
            insertQuery = new StringBuilder();
            counter = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void calculateMultiVoting() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, count ) select name, birthDate, count(*) from voter_count_tmp group by name, birthDate";

        getConnection().createStatement().execute(sql);
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}

