def zd = ["zun","doko"]
def r = new Random()
def zundoko = {l = [] ->
  l+=r.nextInt(2)
  if(l.size() > 5 && l[(l.size()-5)..l.size()-1] == [0,0,0,0,1]) {
    println l.collect{zd[it]}.join("\n")
    println "kiyoshi!"
  } else {
    trampoline(l)
  }
}.trampoline()
zundoko()