package com.msm.msmtodo.model

import java.sql.Connection
import java.sql.DriverManager
import java.util.Properties

class OracleDatabase {
    companion object {
        fun getConnection(): Connection {
//            val url = "jdbc:oracle:thin:@xkl1lskcw4kgcltk_high?TNS_ADMIN=Wallet/tnsnames.ora"
//            val user = "PanenkaSkakava123456/"
//            val password = "OCIUSER"
//            return DriverManager.getConnection(url, user, password)
            Class.forName("oracle.jdbc.driver.OracleDriver")

            val props = Properties()
//            props.setProperty("user", "OCIUSER")
//            props.setProperty("password", "PanenkaSkakava123456/")
//            props.setProperty("javax.net.ssl.trustStore", "/Wallet/cwallet.sso")
//            props.setProperty("javax.net.ssl.trustStoreType", "OracleWallet")
//            props.setProperty("javax.net.ssl.trustStorePassword", "wallet123")
//            props.setProperty("oracle.net.ssl_cipher_suites", "AES256-SHA256")
//            props.setProperty("oracle.net.ssl_server_dn_match", "true")

            props.setProperty(
                "oracle.net.wallet_location",
                "/Users/msm/IdeaProjects/connectADB/Wallet"
            )

            val dbUrl =
                "jdbc:oracle:thin:@adwmsmdb_high?TNS_ADMIN=/Users/msm/IdeaProjects/connectADB/Wallet"
            val dbUser = "OCIUSER"
            val dbPassword = "PanenkaSkakava123456/"

            return DriverManager.getConnection(dbUrl, dbUser, dbPassword)
        }
    }
}

/*
fun main(){
val conn = OracleDatabase.getConnection()
// prints true if the connection is valid
println(conn.isValid(0))

// define query
val query = "select ID,\n" +
"NAME,\n" +
"DESCRIPTION from MSM"
val stmt = conn.prepareStatement(query)
val rs = stmt.executeQuery()

val msmList = mutableListOf<msm>()

while (rs.next()) {
// getting the value of the id column
val id = rs.getInt("id")
// getting the value of the name column
val name = rs.getString("name")
// getting the value of the description column
val desc = rs.getString("description")
//        println("id: $id, name: $name, desc: $desc")

/*
constructing a msm table object and
putting data into the list
*/
msmList.add(msm(id = id, name = name, description = desc))

}

rs.close()
stmt.close()
conn.close()

println(msmList)
}
//*/