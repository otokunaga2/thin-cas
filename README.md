# 目的
DBなどに既に記録されているイベント，コンディションというコンテキストを評価して，何らかのアクションをHTTP経由で行うシンプルなフレームワーク

# 開発環境
- Java: jdk_1.7.0_79
- Jersey: 2.22.1 
- Maven: 3.3.9
- jQuery: 1.10.1
- jQuery-UI: 1.11.4

# 設定は以下のようにイベント，コンディション，アクションをUIなどからDBに保存する
- Context
 - url: <value>true/false</value>を返却することを期待
 - name: 任意の名前
 - type: event,condition,actionを判別するために必要（モデルを使いまわしているため）
# 
