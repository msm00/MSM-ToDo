======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc8-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc8-full.tar.gz) contains the 19.19.0.0 release of the Oracle JDBC Thin driver(ojdbc8.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc8.jar (4502465 bytes) - 
(SHA1 Checksum: eb90c858f6b8856123d01b8fadd0d57b8505cc2a)
Oracle JDBC Driver compatible with JDK8, JDK9, and JDK11;
(2) ucp.jar (1695327 bytes) - (SHA1 Checksum: 04c2f3be53e392796737e0ea27494a730a929130)
Universal Connection Pool classes for use with JDK8, JDK9, and JDK11 -- for performance, scalability, high availability, sharded and multitenant databases.
(3) ojdbc.policy (11762 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (308283 bytes ) - (SHA1 Checksum: a43c9fd76fab33629dd133de8884d7433c549cc5
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (210560 bytes) - (SHA1 Checksum: 6b8430405f8b5569ccc215c913ea8d65c9d7d026)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (312515 bytes) - (SHA1 Checksum: aad5164ae9fb47509708871f4797d1733f7c02ac)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1664182 bytes) - (SHA1 Checksum: 47cf95607afdcae43d920760a26f61229518c0d1) 
Classes for NLS support
(8) xdb.jar (129355 bytes) - (SHA1 Checksum: 180bd754c8649f117b43c56779a5741c7e04bb63)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1935724 bytes) - (SHA1 Checksum: a69d7719fe0766d8c27803333ac9f7a15dab5381)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(10) xmlparserv2_sans_jaxp_services.jar (1933191 bytes) - (SHA1 Checksum: 7a7c4269d27018b908cf43ec728462b2dca08277) 
Classes to support standard JDBC 4.x java.sql.SQLXML interface

====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(11) ons.jar (156466 bytes ) - (SHA1 Checksum: 6312e17fbfe58682cfa5c00d104185ff5ad6edf6)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(12) simplefan.jar (32396 bytes) - (SHA1 Checksum: 35507b4156622b367ecf9e722a1a9dfac84c9fc7)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

==================================================================================
NOTE: The diagnosability JARs **SHOULD NOT** be used in the production environment. 
These JARs (ojdbc8_g.jar,ojdbc8dms.jar, ojdbc8dms_g.jar) are meant to be used in the 
development, testing, or pre-production environment to diagnose any JDBC related issues. 

=====================================
OJDBC - Diagnosability Related JARs
===================================== 

(13) ojdbc8_g.jar (7559279 bytes) - (SHA1 Checksum: cf3b8f480f9301470db5edef28e72113e7e5e964)
Same as ojdbc8.jar except compiled with "javac -g" and contains tracing code.

(14) ojdbc8dms.jar (6281128 bytes) - (SHA1 Checksum: 4d37458ab2a015ac9806ce7446a9f5cd8540808e)
Same as ojdbc8.jar, except that it contains instrumentation to support DMS and limited java.util.logging calls.

(15) ojdbc8dms_g.jar (7589003 bytes) - (SHA1 Checksum: bd5ed80a26d7ab1889db66ad9e0e6056fe640c88)
Same as ojdbc8_g.jar except that it contains instrumentation to support DMS.

(16) dms.jar (2194533 bytes) - (SHA1 Checksum: cb20f6da4888d906ae44013dbec2cec0880d9941)
dms.jar required for DMS-enabled JAR files.

==================================================================
Oracle JDBC and UCP - Javadoc and README
==================================================================

(17) JDBC-Javadoc-19c.jar (1753383 bytes) - JDBC API Reference 19c

(18) ucp-Javadoc-19c.jar (366209 bytes) - UCP Java API Reference 19c

(19) simplefan-Javadoc-19c.jar (84139 bytes) - Simplefan API Reference 19c 

(20) xdb-Javadoc-19c.jar (2861664 bytes) - XDB API Reference 19c 

(21) xmlparserv2-Javadoc-19c.jar (2861664 bytes) - xmlparserv2 API Reference 19c 

(22) Jdbc-Readme.txt: It contains general information about the JDBC driver and bugs that have been fixed in the 19.19.0.0 release. 

(23) UCP-Readme.txt: It contains general information about UCP and bugs that are fixed in the 19.19.0.0 release. 


=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjucp/index.html) for more details. 
