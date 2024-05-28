# 02-frameworks

このディレクトリでは、フロントエンドフレームワークを利用した開発に関する情報をまとめています。
素の kotlin/js だけで DOM 操作をして開発することも可能ですが、ほとんどの場合は

## kotlin-wrappers と kotlin-react-dom

kotlin/js では [kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers/tree/master) というものが提供されています。
kotlin-wrappers は、TypeScript の型定義から Kotlin/JS 用のコードを生成したライブラリ群です。

この中には kotlin-react-dom, kotlin-react-router-dom, kotlin-mui などが含まれています。
kotlin-wrappers にあるライブラリを組み合わせれば、react をベースとして一通りの開発が可能です。

## Compose と Kotlin/JS

[compose-multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) は、JetBrains が開発している、Android 用の UI フレームワークです。

関連して compose-html-core というライブラリが提供されており、[kotlinx.html](https://github.com/Kotlin/kotlinx.html) のような DSL で、HTML を生成することができます。
Compose のようにリアクティブに HTML をベースとした UI を構築することができます。

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
    
### 04-react

[kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers) は、TypeScript から Kotlin/JS 用のコードを生成したライブラリ群です。
React を始め、メジャーなライブラリはここにかなりの数が定義されております。

TypeScript の型定義を kotlin に変換する [Karakum](https://github.com/karakum-team/karakum) が要素技術となっています。

フレームワークっぽいのは、kotlin-wrappers の中では react だけです。
React 自体の学習コストが高いという面はあり、react を使う場合はルーターどれにしよう。。 とか悩まないといけないというデメリットはあります。
また、JS 側のコードを多少なりとも把握していないといけなかったり、結合部分でややこしい問題が起きる可能性はあります。

一方で、react 自体の人気が高いため、情報は豊富ですし、MUI などのコンポーネントライブラリも非常に充実しています。

### 05-compose

Compose は、JetBrains が開発している、Android 用の UI フレームワークです。
Compose には Compose for web というものがあり、これを使うことで、Web アプリケーションを作成することができます。

Compose for web はまだ開発中であり、安定版はリリースされていません。
Compose for web は、Compose for Android と同じく、JetBrains が開発しているため、継続性には期待できるでしょう。

Compose for web は Kotlin/Wasm で利用することが現在は前提となっています。
Kotlin/Wasm はまだまだ開発途中であり、安定版はリリースされていません。

- https://github.com/JetBrains/compose-multiplatform/tree/master/examples/html

## どのフレームワークを選ぶか

Doodle は独特なので、ちょっと違うなと思ったら他のものを選ぶのが良いでしょう。

Kvision, fritz2, react は、どれも良いフレームワークです。
継続性、ドキュメント、サンプルコード、コミュニティ、などを総合的に判断して、自分に合ったものを選ぶと良いでしょう。
