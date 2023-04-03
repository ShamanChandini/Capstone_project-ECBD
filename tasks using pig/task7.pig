Create 4 output files, first containing only Error logs, second containing only Debug log, third containing only Trace logs and fourth containing rest of logs.

a = load '/user/cloudera/sample.log' using PigStorage(' ') as (ldate,ltime,module:chararray,trace);
b = foreach a generate ldate,ltime,module,trace;
c = filter b by trace=='[ERROR]';
dump c;
d = filter b by trace=='[ERROR]';
dump d;
e = filter b by trace=='[DEBUG]';
dump e;
f = filter b by trace=='[TRACE]';
dump f;
g = filter b by trace=='[INFO]' and trace=='[FATAL]' and trace=='[WARN]';
dump g;