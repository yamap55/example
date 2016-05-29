
var onLoadFunction = () => {
    // バックグラウンドを取得。
    var BG = chrome.extension.getBackgroundPage();
//    $('#counter').val(BG.getCounter());
    window.document.getElementById("counter").value = BG.getCounter();

    var counterUpdate = () => {
      var counter = window.document.getElementById("counter").value;
      BG.updateCounter(counter);
    };
    window.document.getElementById("update").addEventListener("click", counterUpdate, false);
//    $('#update').click(function(){
//        BG.updateCounter( $('#counter').val() );
//    });
};
window.addEventListener( 'load', onLoadFunction, false );
