@Grapes([
  @Grab("com.h2database:h2:1.4.191"),
  @GrabConfig(systemClassLoader = true),
])
import groovy.sql.Sql

println "start"

def db = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
db.execute("create table sample_table(a int)")
db.dataSet("sample_table").add([a:99])
db.eachRow("select * from sample_table") {
  println it
}
db.close()
println "end"

// éQçl
//http://qiita.com/yamap_55/items/07b601fddbf9633248fe