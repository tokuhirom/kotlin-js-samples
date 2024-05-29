# Kotlin/JS と Compose の基本

Kotlin/JS と compose-html を使って、Hello, World を表示するサンプルです。

このサンプルは以下のリポジトリを参考にしています。
https://github.com/JetBrains/compose-multiplatform/tree/master/tutorials/HTML/Getting_Started

以下のようにして実行できます。

```shell
./gradlew :02-frameworks:05-compose:01-compose-hello:jsRun -t
```

以下のように書いてセットアップします。

<<< ./build.gradle.kts{kotlin}

compose のコードは以下のようになります。

<<< ./src/jsMain/kotlin/Main.kt{kotlin}
