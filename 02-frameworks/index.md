# Kotlin/JS とフレームワーク

このディレクトリでは、フロントエンドフレームワークを利用した開発に関する情報をまとめています。
素の kotlin/js だけで DOM 操作をして開発することも可能ですが、ほとんどの場合はフレームワークを利用することになるでしょう。

Jetbrains は kotlin-react と Compose for web を提供しているので、この2つをまず検討するのが良いでしょう。
どちらを利用する場合でもリアクティブに開発することが可能です。

そのほかにコミュニティが提供しているフレームワークもありますので、検討してみても良いでしょう。

## kotlin-react

kotlin/js では [kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers/tree/master) というものが提供されています。
kotlin-wrappers は、TypeScript の型定義から Kotlin/JS 用のコードを生成したライブラリ群です。

TypeScript の型定義を kotlin に変換する [Karakum](https://github.com/karakum-team/karakum) が要素技術となっています。


この中には kotlin-react-dom, kotlin-react-router-dom, kotlin-mui などが含まれています。
kotlin-wrappers にあるライブラリを組み合わせれば、react をベースとして一通りの開発が可能です。

react のコミュニティが産んだ豊富なコンポーネントライブラリを利用することができるため、開発効率が向上します。
react 自体の人気が高いため、情報は豊富ですし、MUI などのコンポーネントライブラリも非常に充実しています。

## Compose と Kotlin/JS

[compose-multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) は、JetBrains が開発している、Android 用の UI フレームワークです。

関連して compose-html-core というライブラリが提供されており、[kotlinx.html](https://github.com/Kotlin/kotlinx.html) のような DSL で、HTML を生成することができます。
Compose のようにリアクティブに HTML をベースとした UI を構築することができます。

compose のメリットは以下のようなところです。

* ライブラリがすべて kotlin で書かれているので、ライブラリのコードを追うときにやりやすい
* coroutine などが最初から考慮されている。

### Compose for web と安定性

Compose for web based on Kotlin/Wasm はまだ alpha 版であり、安定版はリリースされていません。
Web based on Kotlin/JS は Stable 版です。

https://www.jetbrains.com/help/kotlin-multiplatform-dev/supported-platforms.html

### そのほかのフレームワーク

[Kotlin for JavaScript](https://kotlinlang.org/docs/js-overview.html) に記載されているコミュニティベースの3つのフレームワークを紹介します。

- [Kvision](https://kvision.io/)
  - Kotlin/JS のためのフレームワークです。
  - [@rjaros](https://github.com/rjaros) 氏によって開発されています。
- [fritz2](https://www.fritz2.dev/)
  - Kotlin/JS のためのリアクティブ Web フレームワークです。 
  - ルーティングや通信まで含んだ、フルスタックのフレームワークになっています。
  - [Documentation](https://www.fritz2.dev/docs/) も充実しています。 
  - 見た目をケアしてくれないので、bootstrap や tailwind を使うことになります。 
  - tailwind 等の知識が必要になります。
  - [@jwstegemann](https://github.com/jwstegemann) 氏を中心に、チームで開発が進められているようです。
- [Doodle](https://nacular.github.io/doodle/)
  - Doodle は伝統的なHTMLやCSSに依存せず、ベクターグラフィックスを使用してユーザーインターフェースを作成します。
  - ベクターメインのフロントエンドフレームワークが欲しい場合には選択肢になるかもしれません。
  - [@pusolito](https://github.com/pusolito) 氏がほぼ一人で開発をしているようです。
    
