# 02-frameworks

このディレクトリでは、フロントエンドフレームワークを利用した開発に関する情報をまとめています。

## フレームワーク一覧

[Kotlin for JavaScript](https://kotlinlang.org/docs/js-overview.html) に記載されている3つのフレームワークと、
[kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers/tree/master) で利用可能な react を紹介します。

Kotlin for JavaScript のためのネイティブなフレームワークの方が kotlin/js に最適化されているというメリットがあります。
しかし、ほとんどが個人開発者によってメンテナンスされているため、継続性に不安を感じる人もいるかもしれません。

### 01-kvision

[Kvision](https://kvision.io/) は Kotlin/JS のためのフレームワークです。

2024年5月現在、最新版は 7.5.0 です。
Kvision のコントリビューターはほとんど [@rjaros](https://github.com/rjaros) 氏のみです。
https://github.com/rjaros/kvision/graphs/contributors
Star の数は 1.2k  です。

### 02-fritz2

[fritz2](https://www.fritz2.dev/) は、Kotlin/JS のためのリアクティブ Web フレームワークです。
ルーティングや通信まで含んだ、フルスタックのフレームワークになっています。

[Documentation](https://www.fritz2.dev/docs/) も充実していて、困ることはないでしょう。

2024年5月現在、Star数は 615 です。最新版は 1.0-RC17 です。1.0 が出ると安心して使えるようになるでしょう。
1.0へのマイルストーンは https://github.com/jwstegemann/fritz2/milestones で示されています。
[@jwstegemann](https://github.com/jwstegemann) 氏を中心に、チームで開発が進められているようです。

### 03-doodle

Doodle は伝統的なHTMLやCSSに依存せず、ベクターグラフィックスを使用してユーザーインターフェースを作成します。
この文言に惹かれない場合には、Doodle はたぶん、あなたが求めているモノではないでしょう。。

Kvision, fritz2 とはだいぶ毛色が違うフレームワークです。

2024年5月現在、最新版は 0.10.1 です。

[公式のドキュメント](https://nacular.github.io/doodle/docs/introduction) と
[公式の tutorial](https://nacular.github.io/doodle-tutorials/docs/introduction) がありますので、興味ある場合は
ここから学んでいくと良さそうです。

[Github の insights](https://github.com/nacular/doodle/graphs/contributors) を見ると、[@pusolito](https://github.com/pusolito) 氏がほぼ一人で開発をしているようです。

### 04-react

[kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers) は、TypeScript から Kotlin/JS 用のコードを生成したライブラリ群です。
React を始め、メジャーなライブラリはここにかなりの数が定義されております。

TypeScript の型定義を kotlin に変換する [Karakum](https://github.com/karakum-team/karakum) が要素技術となっています。

フレームワークっぽいのは、kotlin-wrappers の中では react だけです。
React 自体の学習コストが高いという面はあり、react を使う場合はルーターどれにしよう。。 とか悩まないといけないというデメリットはあります。
また、JS 側のコードを多少なりとも把握していないといけなかったり、結合部分でややこしい問題が起きる可能性はあります。

一方で、react 自体の人気が高いため、情報は豊富ですし、MUI などのコンポーネントライブラリも非常に充実しています。

## どのフレームワークを選ぶか

Doodle は独特なので、ちょっと違うなと思ったら他のものを選ぶのが良いでしょう。

Kvision, fritz2, react は、どれも良いフレームワークです。
継続性、ドキュメント、サンプルコード、コミュニティ、などを総合的に判断して、自分に合ったものを選ぶと良いでしょう。
