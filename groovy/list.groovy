def list = ["a","b","c"]
list.each {
  // a
  // b
  // c
  println it
}
assert list.collect {it * 2} == ["aa", "bb", "cc"]
assert list.first() == "a"
assert list.last() == "c"
assert list.min() == "a"
assert list.max() == "c"
assert list*.plus("z") == ["az", "bz", "cz"]
assert list.join("@") == "a@b@c"
assert list.any { it == "a" }
assert !list.any { it == "z" }
assert list.every { ["a","b","c"].contains(it) }
assert !list.every { it == "a" }
assert list.find { it == "a" } == "a"
assert list.findAll { it > "a" } == ["b", "c"]
assert list.inject { total, v -> total + v } == "abc"
assert list.inject("z") {total, v -> total + v } == "zabc"
assert list.drop(2) == ["c"]
assert list.split { it == "a" } == [["a"], ["b", "c"]]

println ("*" * 10)

list.eachWithIndex {v, i->
  // 0 : a
  // 1 : b
  // 2 : c
  println "${i} : ${v}"
}

println ("*" * 10)
