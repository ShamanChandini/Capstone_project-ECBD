A = load 'C:\Users\schan\Downloads\Project1_Ecommerce_BigData-master\Project1_Ecommerce_BigData-master\Project1_InputFiles\Project1_InputFiles\txns-large.dat' using PigStorage (',') as (tid, d, uid, amt : double , cat, prod,city,state,pt);
B = foreach  A generate tid, amt;
C = filter B by ($1>170 and $1<200);
D = foreach C generate 1 as one;
E = group D by one;
F = foreach E generate COUNT(D.one);
dump F;
STORE F INTO 'C:\Users\schan\Downloads\Project1_Ecommerce_BigData-master\Project1_Ecommerce_BigData-master\result3';
