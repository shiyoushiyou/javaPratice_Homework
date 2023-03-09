--　練習　3-1
--このテーブルについて、次のデータを取得するSQL文を作成してください。

--①6月のデータ
SELECT *FROM 気象観測 WHERE 月 = 6;

--②6月以外のデータ
SELECT *FROM 気象観測 WHERE 月 NOT IN(6);
SELECT *FROM 気象観測 WHERE 月 !=6;
SELECT *FROM 気象観測 WHERE 月 <>6;

--③降水量が100未満のデータ
SELECT *FROM 気象観測 WHERE 降水量 < 100;

--④降水量が200より多いデータ
SELECT *FROM 気象観測 WHERE 降水量 > 200;

--⑤最高気温が30以上のデータ
SELECT *FROM 気象観測 WHERE 最高気温 >= 30;

--⑥最低気温が0以下のデータ
SELECT *FROM 気象観測 WHERE 最低気温 <= 0;

--⑦3月、5月、7月のデータ
SELECT *FROM 気象観測 WHERE 月 IN(3,5,7);

--⑧3月、5月、7月以外のデータ
SELECT *FROM 気象観測 WHERE 月  NOT IN(3,5,7);

--⑨降水量が100以下で、湿度が50より低いデータ
SELECT *FROM 気象観測 WHERE 降水量<100 AND 湿度 < 50;

--⑩最低気温が5未満か、最高気温が35より高いデータ
SELECT *FROM 気象観測 WHERE 最低気温 < 5 OR 最高気温 > 35;

--⑪湿度が60～79の範囲にあるデータ
SELECT *FROM 気象観測 WHERE 湿度 BETWEEN 60 AND 70 ;

--⑫観測データがない列のある月のデータ
SELECT *FROM 気象観測 WHERE 月 IS NULL,降水量 IS NULL,最高気温 IS NULL,最低気温 IS NULL,湿度 IS NULL;

--練習　3-1
--次のデータを取得するSQL文を作成してください。

--①都道府県名が「川」で終わる都道府県名
SELECT *FROM 都道府県 WHERE 都道府県名 LIKE '%川';

--②都道府県名に「島」が含まれる都道府県名
SELECT *FROM 都道府県 WHERE 都道府県名 LIKE '%島%';

--③都道府県が「愛」で始まる都道府県名
SELECT *FROM 都道府県 WHERE 都道府県名 LIKE '愛%';

--④都道府県名と県庁所在地が一致するデータ
SELECT *FROM 都道府県 WHERE 都道府県名 LIKE 県庁所在地;
SELECT *FROM 都道府県 WHERE 都道府県名 = 県庁所在地;


--⑤都道府県名と県庁所在地が一致しないデータ
SELECT *FROM 都道府県 WHERE 都道府県名 NOT LIKE 県庁所在地;
SELECT *FROM 都道府県 WHERE 都道府県名 != 県庁所在地;


