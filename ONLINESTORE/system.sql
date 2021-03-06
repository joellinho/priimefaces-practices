CONNECT SYSTEM/ORACLE;

CREATE USER ONLINESTORE IDENTIFIED BY oracle;
GRANT CONNECT, RESOURCE TO ONLINESTORE;
ALTER USER ONLINESTORE IDENTIFIED BY oracle ACCOUNT UNLOCK;

CREATE TABLESPACE ts_01
DATAFILE 'C:\DATABASE\ts_01.ora'
SIZE 3 m
EXTENT MANAGEMENT LOCAL AUTOALLOCATE;

CONNECT ONLINESTORE/oracle;