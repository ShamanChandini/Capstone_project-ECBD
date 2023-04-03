a = load '/user/cloudera/sample.log' using PigStorage(' ') as (ldate,ltime,module:chararray,trace:chararray);
b = foreach a generate module,trace;
c = filter b by trace=='[ERROR]';
d = group c by module;
e = foreach d generate group,COUNT(c.trace) as Result;
f = order e by Result DESC;
g = limit f 1;
dump g;