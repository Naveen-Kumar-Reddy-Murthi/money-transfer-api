
# Simple REST API for Money Transfer Between the Accounts
  A Simple REST API which supports debit and credit between accounts. It's an executable jar with embedded jetty server and in memory
  H2 database.
  
# Frameworks used
  1. Java
  2. Maven
  3. Jersey
  4. Jetty
  5. Project Lambok
  6. Jackson
  7. H2 Database

# Available services
  1. GET   http://localhost:8080/rest/mt/healthcheck
  2. POST  http://localhost:8080/rest/mt/transfer
  
     Sample Json Request for Debit
     
              {
                   "id"           : "null",
                   "txnDate"      : "null",
                   "debitAccNo"   : "50100200879179",
                   "creditAccNo"  : "30012569584586",
                   "type"         : "D",
                   "txnAmount"    : "10000",
                   "status"       : "null"
             }
                 
      Sample Json Request for Credit
      
            {
                 "id"             : "null",
                 "txnDate"        : "null",
                 "debitAccNo"     :  "50100200879179",
                 "creditAccNo"    : "30012569584586",
                 "type"           : "C",
                 "txnAmount"      : "10000",
                 "status"         : "null"
           }
       
 # Build and run as an executable jar
     mvn clean package
     java -jar ".\target\money-transfer-api-1.0-SNAPSHOT.jar"

 # H2 Database web console can be accessed from below url with credentials sa\""
     http://localhost:7071
    
  
 
