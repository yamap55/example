def zd = ["zun","doko","kiyoshi!"]
def r = new Random()
def zundoko = {l = [] ->
  if(l.size() > 5 && l[(l.size()-5)..l.size()-1] == [0,0,0,0,1]) {
    println ((l+=2).collect{zd[it]}.join("\n"))
  } else {
    trampoline(l+=r.nextInt(2))
  }
}.trampoline()
zundoko()