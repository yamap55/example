def zd = ["zun","doko"]
def r = new Random()
def zundoko = {l = [] ->
  l+=zd[r.nextInt(2)]
  if(l.size() > 5 && l[(l.size()-5)..l.size()-1] == ["zun","zun","zun","zun","doko"]) {
    println ((l + "kiyoshi!").join("\n"))
  } else {
    trampoline(l)
  }
}.trampoline()
zundoko()