def map = ["a":"aa","b":"bb"]
assert map["a"] == "aa"
assert map.a == "aa"

// withDefaultはカウントするときに便利。
def map2 = [:].withDefault{0}
assert map2["a"] == 0
assert ++map2["a"] == 1
assert ++map2["a"] == 2


// withDefaultは特定のモノのみ置き換えに便利。
def map3 = ["a":"aa","b":"bb"].withDefault{it}
assert map3["a"] == "aa"
assert map3["z"] == "z"
