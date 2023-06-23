package com.msm.msmtodo.model

import oracle.jdbc.OracleConnection
import java.sql.DriverManager
import java.util.Properties

class OracleDatabaseHelper(private val walletPath: String) {

    companion object {
        init {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver")

        }
    }

    fun getConnection(serviceName: String): OracleConnection {
        val connectionProperties = Properties()
        connectionProperties.setProperty("oracle.net.ssl_server_dn_match", "yes")
        connectionProperties.setProperty("oracle.net.wallet_location", walletPath)
        connectionProperties.setProperty("javax.net.ssl.trustStoreType", "JKS")
        connectionProperties.setProperty("javax.net.ssl.trustStore", "$walletPath/truststore.jks")
        connectionProperties.setProperty("javax.net.ssl.trustStorePassword", "wallet123")

        val connectionUrl = "jdbc:oracle:thin:@$serviceName?TNS_ADMIN=./Users/msm/AndroidStudioProjects/MSMToDo/Wallet"
        return DriverManager.getConnection(connectionUrl, connectionProperties) as OracleConnection
    }
}
