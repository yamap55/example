const server = require('express')();

server.get('/', function(req, res){
  const num1 = req.query.num1 * 1; // 数値に変換
  const num2 = req.query.num2 * 1; // 数値に変換
  if (!num1 || !num2) {
    res.json({});
    return;
  }
  res.json({result : num1 + num2})
});
server.listen(3000);
