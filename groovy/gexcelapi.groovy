@Grapes([
  @GrabResolver( name='kobo-maven-repo', root='https://github.com/kobo/maven-repo/raw/master/release' ),
  @Grab("org.jggug.kobo:gexcelapi:0.3"),
])
import org.jggug.kobo.gexcelapi.GExcel

println "start"

def path = $/C:\work\20160313\hoge.xlsx/$
def book = GExcel.open(path)
def sheet = book[0]
sheet.rows.each {
  println "${it[0].value} : ${it[1]}"
}

println "end"