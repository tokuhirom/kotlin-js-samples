# kotlin-react-dom の基本

kotlin-wrappers の一コンポーネントとして kotlin-react-dom は提供されています。

https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react-dom

kotlin-react-dom は、types-kotlin により生成されています。

## セットアップ

<<< ./build.gradle.kts{kotlin}

とするだけです。
依存の追加だけなので簡単ですね。

## コード

実装は以下のようになる。
基本的には react のコンポーネントを作成しているだけです。

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

kotlin-react の最大の利点は react だということです。
react の開発はまだまだ当分続きそうですし、ドキュメントも豊富です。

一方で、react 自体が進歩し続けているため、キャッチアップがある程度必要でしょう。
react の周辺ライブラリも多く、キャッチアップに少しだけ手間がかかります。
