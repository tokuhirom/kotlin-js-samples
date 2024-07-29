# kotlin-react-dom と ktor を組み合わせる

kotlin-react を使う時でも ktor-client を使うと便利です。

~~ktor-client は suspend 関数を使うため、react の `useEffect` とは相性が悪いですが、
kotlin-react-use に含まれる `useAsyncEffect` を使うことで、簡単に使うことができます。~~

最近のKotlin-Wrappersではデフォルトの `useEffect` が　suspend function　に対応しています。

## セットアップ

JSON を取り出すので、kotlinx.serialization を使うために、`kotlin("plugin.serialization")` を追加します。

<<< ./build.gradle.kts{kotlin}

## コード

`useEffect` を使って、JSON を取得する例です。

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

## まとめ

react-use はこれ以外にも react 関連の様々な hooks を提供しています。
[react-useで使える便利なReact Hooksを紹介します](https://qiita.com/st_12/items/c4e4c1237e97c1b6a657) などを参照してください。
