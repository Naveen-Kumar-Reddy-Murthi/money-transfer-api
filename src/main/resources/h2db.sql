CREATE TABLE account (
  id bigint(11) NOT NULL AUTO_INCREMENT,
  accountNumber varchar(50) NOT NULL,
  active varchar(5) NOT NULL ,
  openDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  currentBalance DECIMAL NOT NULL,
  PRIMARY KEY (id)
);
 
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50100200879179', 171769.54, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50100200315840', 51428.96, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50550400879100', 200.00, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50300300564321', 25548793.58, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50400200112214', 171769.54, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50700100316969', 75145.96, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50100700812345', 99125.54, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50100800387985', 50.0, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50200900810025', 1254863.00, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50300200599931', 10000562.58, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50400200187666', 100.54, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50700200311258', 5000.12, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50700200377023', -53624.96, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50892544365963', -200.96, 'Y');
INSERT INTO account(accountNumber, currentBalance, active) VALUES('50700200300010', -12563.96, 'Y');


CREATE TABLE IF NOT EXISTS transaction(id bigint(11) NOT NULL AUTO_INCREMENT,
 txnDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, type VARCHAR(10) NOT NULL,
 debitAccNo VARCHAR(255) NOT NULL, creditAccNo VARCHAR(255) NOT NULL, txnAmount 
 DECIMAL NOT NULL, status VARCHAR(10)  NOT NULL, PRIMARY KEY (id));
  