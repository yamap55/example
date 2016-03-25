def l = ["zun","doko"]
def f = {Math.floor(Math.random() * 2) as int}

def ll = []
while(true) {
  def i = f()
  println l[i]
  ll << i
  if (ll == [0,0,0,0,0,1]) {
    println "kiyoshi!"
    return
  }
  if (i == 1) {
    ll.clear()
  }
}