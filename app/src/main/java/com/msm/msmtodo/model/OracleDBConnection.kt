package com.msm.msmtodo.model

import java.sql.Connection
import java.sql.DriverManager
import java.util.Properties

class OracleDBConnection {
    companion object {
        fun getConnection(): Connection? {
            Class.forName("oracle.jdbc.driver.OracleDriver")
            val walletLocation = "/Users/msm/AndroidStudioProjects/MSMToDo/Wallet"
//            val tnsName = "(DESCRIPTION=(ADDRESS=(PROTOCOL=TCPS)(HOST=your_db_host)(PORT=your_db_port))(CONNECT_DATA=(SERVICE_NAME=your_service_name)))"
//            val tnsName =
//                "(description= (address=(protocol=tcps)(port=1522)(host=adb.eu-zurich-1.oraclecloud.com))(connect_data=(service_name=g8c9a51bc78a43e_adwmsmdb_low.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))"

            val properties = Properties()
            properties["oracle.net.wallet_location"] = walletLocation
            properties["javax.net.ssl.trustStoreType"] = "PKCS12"
            properties["javax.net.ssl.trustStore"] = "$walletLocation/ewallet.p12"
            properties["javax.net.ssl.trustStorePassword"] = "wallet123"
//            val connection = DriverManager.getConnection("jdbc:oracle:thin:@$tnsName", properties)

            val connection = DriverManager.getConnection("jdbc:oracle:thin:@adwmsmdb_low?TNS_ADMIN=./Wallet", properties)
//            val statement = connection.createStatement()
//            val resultSet = statement.executeQuery("SELECT * FROM MSM")
//
//            while (resultSet.next()) {
//                // Process each row of the result set
//                val ociname = resultSet.getString("name")
//                val column2Value = resultSet.getInt("column2")
//                // Process the values as needed
//            }


// Close the resources
//            resultSet.close()
//            statement.close()
//            connectionnection.close()
            return connection
        }
    }
}