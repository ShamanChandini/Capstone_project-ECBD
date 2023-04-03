Task 11 : Find the name of top 3 spenders

a = load '/user/cloudera/txns-large.dat' using PigStorage(',') as (tid,tdate,uid:int,amt:double,cat,acc,city,state,pay);
b = load '/user/cloudera/custs-large.dat' using PigStorage(',') as
(uid:int,fname:chararray,lname,age,prof);
c = join a by uid,b by uid;
d = foreach c generate $2 as uid, $3 as amt,$10 as fname;
e = group d by (uid,fname);
f = foreach e generate group, SUM(d.amt) as Total;
g = order f by Total DESC;
h = limit g 3;
dump h;
