import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  base: '/kotlin-js-samples/',
  title: "Kotlin JS Samples",
  description: "Sample code for Kotlin/JS",
  ignoreDeadLinks: 'localhostLinks',
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
    ],

    sidebar: [
      {
        text: 'Kotlin/JS の基本的な使い方',
        items: [
          { text: 'Kotlin/JS って?', link: '/01-basic' },
          { text: 'Hello, Kotlin/JS world', link: '/01-basic/01-hello-world' },
          { text: 'Bootstrap を使ってみる', link: '/01-basic/02-bootstrap' },
          { text: 'ktor-client を Kotlin/JS で使う', link: '/01-basic/03-ktor-client' }
        ]
      },
      {
        text: 'Kotlin/JS とフレームワーク',
        items: [
          { text: 'Kotlin/JS とフレームワーク', link: '/02-frameworks' },
          {
            text: 'kotlin-react-dom',
            items: [
              { text: 'kotlin-react-dom の基本', link: '/02-frameworks/04-react/01-react-hello' },
              { text: 'kotlin-react-dom と ktor を組み合わせる', link: '/02-frameworks/04-react/02-react-ktor' },
            ]
          },
          {
            text: 'Kotlin/JS と Compose',
            items: [
              { text: 'Kotlin/JS と Compose の基本', link: '/02-frameworks/05-compose/01-compose-hello' },
              { text: 'routing-compose の使い方', link: '/02-frameworks/05-compose/02-routing-compose' },
            ]
          }
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/tokuhirom/kotlin-js-samples/' }
    ]
  }
})
