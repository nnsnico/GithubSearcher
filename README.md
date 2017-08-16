
# GithubSearcher
Githubのリポジトリをインクリメンタルサーチで検索するアプリです

## 概要
- SearchViewによってインクリメンタルサーチを実装しました
- キーワード入力を行うと過去1週間のリポジトリ名がサジェスト表示されます
- サジェストされたリポジトリを押すことでリポジトリ名で再検索されます
- 入力確定後はリポジトリ名，スター数，概要が表示されます

## 開発環境
- Android Studio 2.3.3
  - MIN SDK 21
  - MAX SDK 25
- Galaxy S7 Edge(Android 7.0)

## 使用したライブラリ
- recyclerview-v7 25.3.1
- cardview-v7 25.3.1
- retrofit2 2.1.0
- converter-gson 2.1.0
- retrofit2-rxjava2-adapter 1.0.0
- okhttp3 logging-interceptor 3.8.0
- rxjava 2.1.0
- rxandroid 2.0.1
- floatingsearchview 2.1.1
- DBFlow 4.0.4

## スクリーンショット
![screenshot](http://i.imgur.com/LvbFbww.gif "screenshot")
