# ktor-client を Kotlin/JS で使う

Kotlin/JS からサーバーにアクセスする場合は kotlin-wrappers で提供されてる fetch 関数を使う方法と、ktor-client を使う方法がある。
本項では ktor-client を使う方法を紹介します。

`fetch` を使ってもいいのだけど fetch はちょっと使い勝手が悪いんで、ktor-client を使うことをお勧めします。

ktor は JetBrains が提供している Web フレームワークで、kotlin で書かれています。
サーバーサイドを ktor で書けば、クライアントでもサーバーサイドでも同じ HTTP Client を利用することが出来て便利です。 

client と server の両方を扱う方法については [ktor のサンプル](https://github.com/Kotlin/kotlinx-rpc/tree/main/samples/ktor-web-app) を参考にすると良い。

## インストール

`build.gradle.kts` に以下のように追記します。

<<< ./build.gradle.kts{kotlin}

kotlinx.serialization が必要な場合は以下のようにプラグインをロードします。

## サンプル

以下のように記述します。
例外が発生した場合、何もエラーが表示されないことがあるので、全体を try-catch で囲った方が良いかもしれません。

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

## coroutine と ktor-client

ktor-client の API は coroutine を使っているので、suspend 関数です。

例えば kotlin-react-dom の `useEffect` は suspend 関数を受け取れません。
react-use の利用を検討してください。

