step1 = load 'C:/Users/schan/Downloads/Project1_Ecommerce_BigData-master/Project1_Ecommerce_BigData-master/txns-large.dat' using PigStorage(',');
step2 = foreach step1 generate $2,$3;
step3 = filter step2 by $1>160;
dump step3;
STORE step3 INTO 'C:/Users/schan/Downloads/Project1_Ecommerce_BigData-master/Project1_Ecommerce_BigData-master/result1' using PigStorage(',');