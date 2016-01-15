#目的
DBなどに既に記録されているイベント，コンディションというコンテキストを評価して，何らかのアクションをHTTP経由で行うシンプルなフレームワーク

#開発環境
- Java: jdk_1.7.0_79
- Jersey: 2.22.1 
- Maven: 3.3.9

#設定は次のように記述する
event:
  type: file
  path_prefix: ./mydata/event/csv/
  
condition:
  type: file
  path_prefix: ./mydata/condition/csv/
  
action:
  type: file
  path_prefix: ./mydata/action/csv/
    