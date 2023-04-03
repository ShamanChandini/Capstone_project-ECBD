Task 12 : Sort the whole file on the basis of amt.

a = load '/user/cloudera/txns-large.dat' using PigStorage(',') as (tid,tdate:chararray,uid,amt:double,cat,acc,city,state,pay);;
b = foreach a generate tid,tdate,uid,amt,cat,acc,city,state,pay;
c = order b by amt;
dump c;
