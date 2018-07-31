package kirbyquerby.sockettest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Code borrowed from https://github.com/GoogleCloudPlatform/cloud-sql-jdbc-socket-factory/blob/master/examples/mysql/compute-engine/src/main/java/com/google/cloud/sql/mysql/example/ListTables.java
public class Main {

  public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

    // The instance connection name can be obtained from the instance overview page in Cloud Console
    // or by running "gcloud sql instances describe <instance> | grep connectionName".
    // String instanceConnectionName = "{project}:{region}:{name}";
    String instanceConnectionName = "nathandias-playground:us-central1:nathan-mysql-40";
    // The database from which to list tables.
    String databaseName = "mysql";

    String username = "root";

    // This is the password that was set via the Cloud Console or empty if never set
    // (not recommended).
    String password = "";

    //[START doc-example]
    String jdbcUrl = String.format(
        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
        databaseName,
        instanceConnectionName);

    try {
      Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
      try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery("show tables;");
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //[END doc-example]

  }

}
