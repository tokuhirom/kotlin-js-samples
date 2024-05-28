# kotlin-js-samples

Kotlin for JavaScript のサンプル集です。
Kotlin for JavaScript はまだまだ日本では流行ってないように思いますが、[すでに stable](https://kotlinlang.org/docs/components-stability.html) であり、日々の開発業務に活用可能です。

kotlin for JavaScript を使ってみようと思っている人の一助になれば幸いです。

## 想定環境

- Kotlin/JS 2.0.0
- Gradle 8.5.0
- IntelliJ IDEA 2024.1

## TOC

- [01-basic](01-basic/README.md)
  - [hello, world](01-basic/01-hello-world/README.md) Kotlin/JS を利用した hello,world について開設します。
  - [bootstrap](01-basic/02-bootstrap/README.md) CSS フレームワークとして bootstrap を利用する方法について解説します。
  - [ktor-client](01-basic/03-ktor-client/README.md) ktor-client を利用してサーバーにアクセスする方法について解説します。
- [02-frameworks](02-frameworks/README.md) 今あるフレームワークについて解説します
  - [02-fritz2/01-fritz2-basic](02-frameworks/02-fritz2/01-fritz2-basic/README.md) fritz2 の基本的な挙動について解説します
  - [02-fritz2/02-fritz2-router](02-frameworks/02-fritz2/02-fritz2-router/README.md) fritz2 のルーターを触ってみます。
  - [04-react/01-react-hello](02-frameworks/04-react/01-react-hello/README.md) kotlin-react-dom を利用した hello, world について解説します。
  - [05-compose/01-compose-hello](02-frameworks/05-compose/01-compose-hello/README.md) kotlin-jb-compose を利用した hello, world について解説します。
  - [05-compose/02-compose-router](02-frameworks/05-compose/02-routing-compose/README.md) router-compose を利用したルーターの使い方について解説します。

## FAQ

### 以下のようなエラーがでて lock file 起因でビルドがdけいない
    
    FAILURE: Build failed with an exception.
    
    * What went wrong:
      Execution failed for task ':kotlinStoreYarnLock'.
    > Lock file was changed. Run the `kotlinUpgradePackageLock` task to actualize lock file

このエラーは、`kotlinUpgradePackageLock` タスクを実行することで解消できそうだけどうまく動かない時もある。
そんなときは、 `rm kotlin-js-store/yarn.lock` すると直ります。 

