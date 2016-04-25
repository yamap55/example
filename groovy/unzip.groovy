println "start ${new Date()}"

def ant = new AntBuilder()
def p = $/C:\work\20160419\hoge.zip/$
def o = $/C:\work\20160419\output/$

ant.unzip(src:p,
  dest:o,
  overwrite:"false" )

println "end ${new Date()}"
