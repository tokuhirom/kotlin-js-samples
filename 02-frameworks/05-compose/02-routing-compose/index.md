# routing-compose の使い方

Kotlin/JS と compose-html の組み合わせでは、ルーターが欲しくなります。
が、ルーターが compose-html では提供されていないようです。

OSS のライブラリとして [routing-compose](https://github.com/hfhbd/routing-compose) 
が提供されています。

[hfhbd](https://github.com/hfhbd) 氏が個人として開発しているライブラリですが、コードベースが大きいものではないため、
開発が停滞した場合は fork して自分でメンテナンスを続けることも可能でしょう。

そのうち、compose-html や compose-web にルーターが提供されるようになるかもしれませんが、
一旦これ以外にはインターネッツで探すことができませんでしたよ、と。。

## インストール

    implementation("app.softwork:routing-compose:0.2.14")

を追加するだけで良いです。

## 使い方

### ルーティングの定義

以下のように定義します。

```kotlin
fun main() {
    renderComposable(rootElementId = "root") {
        HashRouter(initPath = "/") {
            route("/") {
                Text("Top page")
            }
            route("/hello") {
                Div {
                    Text("Hello, World!")
                }
            }
            noMatch {
                Text("Not found!")
            }
        }
    }
}
```

`/user/:id` のようなパスパラメータを使うこともできます。
マッチングをパス文字列の中の特殊記法で記述するのではなく、中で int, string などのメソッドを呼び出して処理するスタイルになっています。

```kotlin
// /user/:id のようなパスにマッチ
route("/user") {
    int {id ->
        Div {
            Text("User ID: $id")
        }
    }
    noMatch {
        Text("User not found!")
    }
}
```

クエリパラメータを使うこともできます。

```kotlin
// #/greet?name=John のようなパスにマッチ
route("/greet") {
    navBar()

    parameters?.map?.get("name")?.let { name ->
        Text("Hello, ${name[0]}!")
    } ?: run {
        Text("Hello, World!")
    }
}
```

### ページ遷移のためのリンク作成

通常のリンクを作成するには、`NavLink` を使います。

```kotlin
NavLink(to = "/about") {
    Text("About")
}
```

router のコンテキストの中でしか使えないことに注意してください。

### プログラムからのページ遷移

プログラムからのページ遷移には、`router.navigate` を使います。

```kotlin
val router = Router.current

Input(type = InputType.Button) {
    onClick {
        router.navigate("/greet", Parameters.from("name" to "paul"))
    }
    value("Navigate to greet with the userName paul")
}
```

