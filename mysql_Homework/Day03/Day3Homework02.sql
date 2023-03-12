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
SELECT 飼育県,COUNT(出生日)頭数 FROM 個体識別 GROUP BY 飼育県;

--２．１で作成した頭数集計テーブルで、飼育頭数の多いほうから３つの都道府県で飼育されている牛のデータを、個体識別テーブルにより抽出する。
SELECT
    飼育県
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
                    個体識別 
                GROUP BY
                    飼育県 
                ORDER BY
                    COUNT(*) DESC 
                LIMIT
                    3
            ) 飼育県
    ) 
ORDER BY
    飼育県 DESC;

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
WHERE 雌雄コード = 2;


