// バッジに文言を設定。
// chrome.browserAction.setBadgeText({ text: "ABC" });
// バッジに開いているタブの数を表示
var counter = 0;
chrome.tabs.getAllInWindow( null, function( tabs ){
    counter = tabs.length;
    chrome.browserAction.setBadgeText({ text:String(counter) });
});
chrome.tabs.onCreated.addListener( function( tab ){
    counter++;
    chrome.browserAction.setBadgeText({ text: String(counter) });
});
chrome.tabs.onRemoved.addListener( function( tab ){
    counter--;
    chrome.browserAction.setBadgeText({ text: String(counter) });
});
// ここまで。

// バッジにタイトルを設定。（マウスオーバー時に表示される文言）
chrome.browserAction.setTitle({ title: "hoge" });

console.log("extention example.")

// カウンターを取得
var getCounter = function(){
    return counter;
};

// バッジのカウンターを更新
var updateCounter = function( counter ){
    chrome.browserAction.setBadgeText({text:String(counter)});
};
