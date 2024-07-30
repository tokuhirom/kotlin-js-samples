# webpack の contenthash 機能を使う

Webpack で生成されるファイル名にハッシュ値を付与することで、キャッシュの問題を解決する方法を紹介します。

## セットアップ

build.gradle.kts を以下のようにします。

<<< ./build.gradle.kts{kotlin}

`mainOutputFileName = "web.[contenthash].js"` とすることにより、contenthash の部分にファイルのハッシュ値が入ります。
最高ですね。

contenthash 値を含んだスクリプトのロード処理を HTML に書き込むために `html-webpack-plugin` を利用します。

index.html というファイル名が webpack で生成される一方で、jsProcessResources でも index.html が生成されるため、重複エラーになってしまいます。
そこで、jsProcessResources の設定で、無視するようにしています。

## コード

kotlin の実装は例えば以下のようにすれば良い。まぁこっちは普通です!

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

HTML の方は以下のようにします。

<<< ./src/jsMain/resources/index.html

script は `html-webpack-plugin` で自動的にロードされるため、ロード処理を改めていれる必要はないです。

## webpack の設定

webpack.config.d/html-minify.js に設定を書いて、HTML に script タグをインジェクトします。

<<< ./webpack.config.d/html-minify.js

生成される HTML は以下のようになります。

```html
<!doctype html><html lang="ja"><head><meta charset="UTF-8"><title>Hello World</title></head><body><div id="root">Now loading...</div><script defer="defer" src="web.87e579c7a76c6c485c23.js"></script></body></html>
```

これで、必要以上にキャッシュされなくなって平和が訪れました。
