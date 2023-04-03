Task 9 : Find the user who has spend the max amount in July month.

a = load '/user/cloudera/txns-large.dat' using PigStorage(',') as (tid,tdate:chararray,uid,amt:double,cat,acc,city,state,pay);;
b = foreach a generate SUBSTRING(tdate,0,2) as month,uid,amt;
c = filter b by month=='07';
d = load '/user/cloudera/custs-large.dat' using PigStorage(',') as
(uid:int,fname:chararray,lname,age,prof);
e = foreach d generate uid,fname;
f = join c by uid,e by uid;
g = foreach f generate $1 as uid, $2 as amt,$4 as fname;
h = group g by (uid,fname);
i = foreach h generate group, SUM(g.amt) as Total;
j = order i by Total DESC;
k = limit j 1;
dump k;
