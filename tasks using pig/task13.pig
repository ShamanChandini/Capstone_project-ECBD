Task 13 

Divide the file into 12 files, each file containing each month of data. For eg. file 1 should contain data of january txn, file 2 should contain data of feb txn.

a = load '/user/cloudera/txns-large.dat' using PigStorage(',') as (tid,tdate:chararray,uid,amt:double,cat,acc,city,state,pay);;
b = foreach a generate SUBSTRING(tdate,0,2) as month,tid,tdate,uid,amt,cat,acc,city,state,pay;
c = filter b by month=='01';
dump c;
d = filter b by month=='02';
dump d;
e = filter b by month=='03';
dump e;
f = filter b by month=='04';
dump f;
g = filter b by month=='05';
dump g;
h = filter b by month=='06';
dump h;
i = filter b by month=='07';
dump i;
j = filter b by month=='08';
dump j;
k = filter b by month=='09';
dump k;
l = filter b by month=='10';
dump l;
m = filter b by month=='11';
dump m;
n = filter b by month=='12';
dump n;
