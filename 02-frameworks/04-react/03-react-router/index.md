# react-router を使う

react-router を使ってページ遷移を実現します。

## セットアップ

<<< ./build.gradle.kts{kotlin}

## コード

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

通常の場合と異なり、`NavLink` を使ってリンクを作成します。

jso を使ってるところがちょっと生々しいですが、react-router の機能をそのまま使えているので、機能的には十分だと思います。

### エラーの処理

デフォルトではエラーページは以下のようになります。

![img.png](img.png)

以下のように自分で、エラーページを作成することもできます。

```kotlin
val ErrorPage = FC<Props> {
    val error = useRouteError().unsafeCast<JsError>()

    div {
        css {
            color = NamedColor.red
        }
        +error.message
    }
}
```

以下のように、ErrorBoundary を設定するとエラー処理が出来ます。

```kotlin
jso {
    path = "/fail"
    Component = FailContent
    ErrorBoundary = ErrorPage
}
```

