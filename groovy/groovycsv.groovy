@Grab('com.xlson.groovycsv:groovycsv:1.1')
import com.xlson.groovycsv.CsvParser

//def inputPath = $/c:\work\20140627\test.txt/$
//def text = new File(inputPath).text
def text = """hoge1,huga1,piyo1
hoge2,huga2,piyo2
hoge3,huga3,piyo3
"""
def data = new CsvParser().parse(text, separator: ',', quoteChar: '"', columnNames: ["columnA","columnB","columnC"],readFirstLine: true)

data.each {
  println "${it.columnA} : ${it.columnB} : ${it.columnC}"
}

println ("-"*10)
text = """columnA,columnB,columnC
hoge1,huga1,piyo1
hoge2,huga2,piyo2
hoge3,huga3,piyo3
"""
data = new CsvParser().parse(text, separator: ',', quoteChar: '"')

data.each {
  println "${it.columnA} : ${it.columnB} : ${it.columnC}"
}