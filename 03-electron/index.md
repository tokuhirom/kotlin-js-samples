# Kotlin/JSとElectronのサンプルコード

この記事では、Kotlin/JSとElectronを使ってデスクトップアプリケーションを開発する方法を紹介します。

現在、kotlin-wrappersはkotlin-electronを提供していますが、開発チームはまだそれをテストしていません。
そのため、周囲にはサンプルコードがありません。
(https://github.com/JetBrains/kotlin-wrappers/issues/2083)

この記事では、Kotlin/JS と Electron を使用する方法を紹介します。
これはあまりスマートではありませんが、Kotlin/JSでElectronを使用する方法の一つです。

## ディレクトリ構成

このサンプルコードには以下のディレクトリ構成があります。

```
  - build.gradle.kts        # Gradle設定
  - settings.gradle.kts
  - gradlew/                # Gradleラッパー
  - gradle.properties

  - target/                 # Electronのビルドディレクトリ
    - package.json          # Electronの設定
    - index.html            # ElectronのHTMLファイル
    - preload.js            # Electronのプリロードスクリプト
    - forge.config.js       # Electron Forgeの設定

  - main                    # メインプロセス用のKotlin/JSコード  
    - build.gradle.kts
    - src/jsMain/kotlin/main.kt
  - renderer                # レンダラープロセス用のKotlin/JSコード  
    - build.gradle.kts
    - src/jsMain/kotlin/renderer.kt
```

- `main`モジュールはElectronのメインプロセスを構成します。
- `renderer`モジュールはElectronのレンダラープロセスを構成します。

各モジュールでは、Kotlin/JSコードは`src/jsMain/kotlin`ディレクトリに書かれています。

Electronアプリケーションをビルドするには、以下のコマンドを実行する必要があります。

## main モジュールの実装

build.gradle.kts を以下のように実装します。

<<< ./main/build.gradle.kts{kotlin}

ビルド結果の JS ファイルを target/main/ 以下にコピーするのがポイントですね。

## preload.js の問題

preload.jsをKotlin/JSで書きたいのですが、その方法が見つかりませんでした。
そのため、JavaScriptで記述しました。

なんでかというと、ESM で preload.js を書く方法がないからです。
ESM じゃなく書く場合に、preload.js から kotlin-kotlin-stdlib.js が読めないというエラーが発生します。

もし、Kotlin/JSで書く方法をご存知でしたら教えてください。

preload.js は以下のような形で実装しました。

<<< ./target/preload.js{js}

## renderer の実装

スクリプトはほとんど一緒です。

<<< ./renderer/build.gradle.kts{kotlin}

## デバッグ方法

デバッグスクリプトとして以下のようなものを用意します。

<<< ./debug.py{python}

そして、実行します。

```shell
./debug.py
```

このコマンドはKotlin/JSコードをコンパイルし、カスタムGradleタスクによってターゲットディレクトリにコピーします。

## パッケージのビルド方法

パッケージをビルドするには、以下のコマンドを実行します。

```shell
cd target/
npx electron-forge make
```

## 既知の問題

- preload.jsはJavaScriptで書かれています。
- `BrowserWindow.getAllWindows()`が動作しません。
  - https://github.com/JetBrains/kotlin-wrappers/issues/2262

## 参考資料

- https://github.com/JetBrains/kotlin-wrappers/blob/master/kotlin-electron/README.md
- https://github.com/JetBrains/kotlin-wrappers/issues/2083
