--練習　4-1
--次のデータを取得するためのSQL文を作成してください。


--①注文順かつその明細順に、すべての注文データを取得する。
SELECT * FROM 注文履歴 ORDER BY 日付,注文枝番;

--②2022年1月に注文のあった商品名の一覧を商品名順に取得する。
SELECT
    商品名 
FROM
    注文履歴 WHERE 日付 BETWEEN '2022/1/1' AND'2022/1/31' 
ORDER BY
    商品名;

--③ドリンクの商品を対象に、注文金額の低いほうから2～4番目の注文の注文番号と注文枝番、注文金額を取得する。
SELECT
    注文番号
    , 注文枝番
    , 注文金額 
FROM
    注文履歴 
WHERE
    分類 = 1 
ORDER BY
    注文金額 
LIMIT
    1, 3;


--④その他の商品について、2つ以上同時に購入された商品を取得し、
--日付、商品名、単価、数量、注文金額を購入日順に表示する。
--だだし、同日に売り上げたものは、数量の多い順に表示する。
SELECT
    日付
    , 商品名
    , 単価
    , 数量
    , 注文金額 
FROM
    注文履歴 
WHERE
    分類 = 3 
    AND 数量 > 1 
ORDER BY
    日付
    , 数量 DESC;



--⑤商品の分類ごとに、分類、商品名、サイズ、単価を1つの表として取得する。
--また、サイズはドリンクの商品についてのみ表示し、分類と商品名順に並べること。

UPDATE 注文履歴 SET サイズ = NULL WHERE サイズ='x';
SELECT 分類 , 商品名 , サイズ , 単価 FROM 注文履歴 WHERE 分類 = 1
UNION
SELECT 分類 , 商品名 , サイズ , 単価 FROM 注文履歴 WHERE 分類 = 2
UNION
SELECT 分類 , 商品名 , サイズ , 単価 FROM 注文履歴 WHERE 分類 = 3 ORDER BY 分類 , 商品名;

SELECT 分類 , 商品名 , サイズ , 単価 FROM 注文履歴 分類 = 1
UNION
SELECT 分類 , 商品名 , NULL , 単価 FROM 注文履歴 WHERE 分類 !=1 ORDER BY 分類 , 商品名;

SELECT 分類 , 商品名 ,IF(分類 = 1,サイズ,NULL) サイズ , 単価 FROM 注文履歴 ORDER BY 分類 , 商品名;

SELECT 分類 , 商品名 ,CASE 分類 = 1 THEN サイズ ELSE NULL  END サイズ , 単価 FROM 注文履歴 ORDER BY 分類 , 商品名;


