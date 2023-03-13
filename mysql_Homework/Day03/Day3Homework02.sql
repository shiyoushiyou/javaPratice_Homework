--　練習　7-3

/*
雌雄コード
・１．雄
・２：雌

品種コード
・01：乳用種
・02：肉用種
・03：交雑種
*/

--１．飼育県別に飼育頭数をカウントし、その結果を次の頭数集計テーブルに登録する。
INSERT INTO 頭数集計 (SELECT 飼育県,COUNT(出生日)頭数 FROM 個体識別 GROUP BY 飼育県);

--２．１で作成した頭数集計テーブルで、飼育頭数の多いほうから３つの都道府県で飼育されている牛のデータを、個体識別テーブルにより抽出する。
SELECT
    飼育県 都道府県名
    , 個体識別番号
    , (CASE 雌雄コード WHEN 1 THEN '雄' ELSE '雌' END) 雌雄 
FROM
    個体識別 
WHERE
    飼育県 IN ( 
        SELECT
            * 
        FROM
            ( 
                SELECT
                    飼育県 
                FROM
                    頭数集計 
                ORDER BY
                    頭数 DESC
                LIMIT
                    3
            ) 飼育県
    ) ;

--３．個体識別テーブルに母牛についてもデータ登録されており、母牛が乳用種である牛の一覧を個体識別テーブルにより抽出したい。
SELECT
    個体識別番号
    , ( 
        CASE 品種コード 
            WHEN '01' THEN '乳用種' 
            WHEN '02' THEN '肉用種' 
            WHEN '03' THEN '交雑種' 
            END
    ) 品種
    , 出生日
    , 母牛番号 
FROM
    個体識別
WHERE 母牛番号 IN (SELECT 個体識別番号 FROM 個体識別 WHERE 品種コード = 1 );

SELECT
    牛寶寶.個体識別番号
    , ( 
        CASE 牛寶寶.品種コード 
            WHEN '01' THEN '乳用種' 
            WHEN '02' THEN '肉用種' 
            WHEN '03' THEN '交雑種' 
            END
    ) 品種
    , 牛寶寶.出生日
    , 牛寶寶.母牛番号 
FROM
    個体識別 牛寶寶
JOIN
    個体識別 牛媽媽
ON
    牛寶寶.母牛番号 = 牛媽媽.個体識別番号
    AND 牛媽媽.品種コード = 1;

