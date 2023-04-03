Count the number of logs of each type like trace log 7, error logs 12 and so on .

a = load '/user/cloudera/sample.log' using PigStorage(' ') as (ldate,ltime,module:chararray,trace:chararray);
b = foreach a generate trace;
c = group b by trace;
d = foreach c generate group,COUNT(b.trace);
dump d;