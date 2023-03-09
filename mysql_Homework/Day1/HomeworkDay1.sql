﻿--　練習　2-3
--①すべての列名を明示的に指定して、すべての行を取得する。
SELECT コード FROM 都道府県 ;
SELECT 地域 FROM 都道府県 ;
SELECT 都道府県名 FROM 都道府県 ;
SELECT 県庁所在地 FROM 都道府県 ;
SELECT 面積 FROM 都道府県 ;
SELECT コード,地域,都道府県名,県庁所在地 ,面積 FROM 都道府県
--②列名の指定を省略して、①と同様の結果を取得する。
SELECT * FROM 都道府県;
--③「地域」「都道府県名」の列について、「area」と[pref」という別名を付けてすべての行を取得する。
SELECT 地域 AS area , 都道府県名 AS pref FROM 都道府県;
SELECT 地域 area, 都道府県名 pref FROM 都道府県;

--　練習　2-4
/*
練習　2-3の都道府県名テーブルについて、次のような3つのデータを追加するSQL文をそれぞれ作成してください。
ただし、コード37のデータの追加では、SQL文中に列名を指定しない方法を利用してください。
なお、表中で空欄となっている部分の値は指定しません。
*/
INSERT INTO 都道府県(コード,地域,都道府県名,面積) VALUES (26,'近畿','京都',4613);
INSERT INTO 都道府県 VALUES (37,'四国','香川','高松',1876);
INSERT INTO 都道府県(コード,都道府県名,県庁所在地) VALUES  (40,'福岡','福岡');

--　練習　2-5
/*
練習　2-4でデータが追加された都道府県テーブルについて、
表中で空白だった箇所に次の値を格納するSQL文を作成してください。
*/
--①コード26の県庁所在地に「京都」を格納する。
UPDATE 都道府県 SET 県庁所在地 ='京都' WHERE コード=26;

--②コード40の地域に「九州」、面積に4976を格納する。
UPDATE 都道府県 SET 地域 ='九州', 面積 = 4976 WHERE コード = 40;

--練習　2-6
/*
練習　2-4で追加したコード26のデータを都道府県テーブルから削除するSQL文を作成してください。
対象行はコード番号で指定してください。*/
DELETE FROM 都道府県 WHERE コード = 26;


