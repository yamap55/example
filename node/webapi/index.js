const server = require('express')();
const pg = require('pg');

const con = "tcp://postgres:postgres@localhost/webapi-example";

server.get('/', function(req, res){
  const name = req.query.name;
  const password = req.query.pass;
  console.log(name + " : " + password);
  if (!name || !password) {
    res.json({});
    return;
  }

  pg.connect(con, (err, client)=>{
    if (err) {
      console.log("error");
      console.log(err);
      return;
    }
    const query = client.query("select * from user_info where name = '" + name + "' and password = '" + password + "'",
    (e, client)=>{
      if (e) {
        console.log("error");
        console.log(err);
        return;
      }
      res.json(client.rows);
    });
  });
});
server.listen(3000);
