def zd = ["zun","doko"]
def r = new Random()

def zundoko = {l = [] ->
  def z = r.nextInt(2)
  println zd[z]
  if (z) {
    if (l.size() >= 4) {
      println "kiyoshi!"
      return
    }
    l = []
  } else {
    l += z
  }
  call(l)
}()
