
--練習　6-1

--１．日本全体としての年降水量の合計と、年間の最高気温、最低気温の平均
SELECT
    SUM(降水量)
    , AVG(最高気温)
    , AVG(最低気温) 
FROM
    都市別気象観測;

--２．都市名「東京」の年間降水量と、各月の最高気温、最低気温の平均
SELECT
    SUM(降水量)
    , AVG(最高気温)
    , AVG(最低気温) 
FROM
    都市別気象観測 
WHERE
    都市名 = '東京';

--３．各都市の降水量の平均と、最も低かった最高気温、最も高かった最低気温
SELECT
    都市名
    , AVG(降水量)降水量の平均
    , MIN(最高気温)最も低かった最高気温
    , MAX(最低気温)最も高かった最低気温 
FROM
    都市別気象観測 
GROUP BY
    都市名;

--４．月別の降水量、最高気温、最低気温の平均
SELECT
    月
    , AVG(降水量)
    , AVG(最高気温)
    , AVG(最低気温) 
FROM
    都市別気象観測 
GROUP BY
    月 
ORDER BY
    月;
    
--５．1年間で最も高い最高気温が38度以上を記録した月のある都市名とその気温
SELECT
    都市名
    , MAX(最高気温) 最高気温 
FROM
    都市別気象観測 
GROUP BY
    都市名 
HAVING
    MAX(最高気温) >= 38;
    
--６．1年間で最も低い最低気温が-10度以下を記録した月のある都市名とその気温
SELECT
    都市名
    , MIN(最低気温) 最低気温 
FROM
    都市別気象観測 
GROUP BY
    都市名 
HAVING
    MIN(最低気温) <=-10;
    
--　練習　6-2
/*
退室
・NULL：入室中
・1：退室済み

事由区分
・１：メンテナンス
・２：リリース作業
・３：障害対応
・９：その他
*/
--１．現在入室中の社員数を取得する。
SELECT 退室,COUNT(*)入室中社員数 FROM 入退室管理 WHERE 退室 IS NULL GROUP BY 退室;

--２．社員ごとの入室回数を、回数の多い順に取得する。
SELECT
    社員名
    , COUNT(退室) 入室回数 
FROM
    入退室管理 
WHERE
    退室 = 1 
GROUP BY
    社員名 
ORDER BY
    入室回数 DESC;

--３．事由区分ごとの入室回数を取得する。
SELECT
    ( 
        CASE 事由区分 
            WHEN 1 THEN 'メンテナンス' 
            WHEN 2 THEN 'リリース作業' 
            WHEN 3 THEN '障害対応' 
            WHEN 9 THEN 'その他' 
            END
    ) 事由区分
    , count(事由区分) 入室回数 
FROM
    入退室管理 
GROUP BY
    事由区分

--４．入室回数が10回を超過する社員について、社員名と入室回数を取得する。
SELECT 社員名,COUNT(*)入室回数 FROM 入退室管理 GROUP BY 社員名 HAVING 入室回数>10;

--５．これまでに障害対応が発生した日付と、それに対応した社員数を取得する。
SELECT 日付,COUNT(社員名)対応した社員数 FROM 入退室管理 WHERE 事由区分 = 3 GROUP BY 日付;
