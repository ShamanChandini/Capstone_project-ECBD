Calculate the total sum and total count of all the transaction for each user id.

step1 = load 'C:\Users\schan\Downloads\Project1_Ecommerce_BigData-master\Project1_Ecommerce_BigData-master\Project1_InputFiles\Project1_InputFiles\txns-large.dat' using PigStorage(',');
step2 = foreach step1 generate $2 as uid,$3 as amt;
step3 = group step2 by uid;
step4 = foreach step3 generate group, SUM(step2.amt);
dump step4;

step1 = load 'C:\Users\schan\Downloads\Project1_Ecommerce_BigData-master\Project1_Ecommerce_BigData-master\Project1_InputFiles\Project1_InputFiles\txns-large.dat'' using PigStorage(',');
step2 = foreach step1 generate $2 as uid,$3 as amt;
step3 = group step2 by uid;
step4 = foreach step3 generate group, SUM(step2.amt),COUNT(step2.amt),AVG(step2.amt);
dump step4;

STORE step4 INTO 'C:\Users\schan\Downloads\Project1_Ecommerce_BigData-master\Project1_Ecommerce_BigData-master\result4';