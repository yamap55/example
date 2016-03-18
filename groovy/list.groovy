def list = ["a","b","c"]
list.each {
  print it // abc
}
assert list.collect {it * 2} == ["aa", "bb", "cc"]
assert list.first() == "a"
assert list.last() == "c"