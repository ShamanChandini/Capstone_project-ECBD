Find the profession of user who has spend the maximum amount

a = load '/user/cloudera/txns-large.dat' using PigStorage(',') as (tid,tdate,uid:int,amt:double,cat,acc,city,state,pay);
b = load '/user/cloudera/custs-large.dat' using PigStorage(',') as
(uid:int,fname:chararray,lname,age,prof:chararray);
c = join a by uid,b by uid;
d = foreach c generate $2 as ID,$3 as tamt,$13 as Prof;
f = group d by ($0,$2);
h = foreach f generate group,SUM(d.tamt) as Res;
i = order h by Res DESC;
j = limit i 1;
dump j;
