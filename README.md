# kotlin-js-samples

Kotlin for JavaScript のサンプル集です。
Kotlin for JavaScript はまだまだ日本では流行ってないように思いますが、[すでに stable](https://kotlinlang.org/docs/components-stability.html) であり、日々の開発業務に活用可能です。

kotlin for JavaScript を使ってみようと思っている人の一助になれば幸いです。

## 想定環境

- Kotlin/JS 2.0.0
- Gradle 8.5.0
- IntelliJ IDEA 2024.1

## FAQ

### 以下のようなエラーがでて lock file 起因でビルドがdけいない
    
    FAILURE: Build failed with an exception.
    
    * What went wrong:
      Execution failed for task ':kotlinStoreYarnLock'.
    > Lock file was changed. Run the `kotlinUpgradePackageLock` task to actualize lock file

このエラーは、`kotlinUpgradePackageLock` タスクを実行することで解消できそうだけどうまく動かない時もある。
そんなときは、 `rm kotlin-js-store/yarn.lock` すると直ります。 

