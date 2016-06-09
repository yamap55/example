assert 2 * 3 == 6
assert 3 ** 3 == 27

def i1 = 2
i1 *= 3
assert i1 == 6

def i2 = 3
i2 **= 3
assert i2 == 27

def m1 = [a:"a1",b:"b1"]
def m2 = [a:"a2",c:"c2"]
def m3 = [a:"a3",b:"b3"]
def list1 = [m1,m2,m3]

assert list1*.a  == ["a1","a2","a3"]
assert list1*.b  == ["b1",null,"b3"]

def str1 = "あいうえお"
def str2 = "abc"

def list2 = [str1, str2]
assert list2*.size() == [5,3]
assert list2.collect{it.size()} == [5,3] // 今までこう書いてた。

def function1 = {x,y,z ->
  x * y + z
}
def args1 = [1,2,3]
assert function1(*args1) == 5

def args2 = [4,5]
assert function1(*args2, 6) == 26

def list3 = [2,3]
assert [1,*list3,4] == [1,2,3,4]
assert [1,list3,4].flatten() == [1,2,3,4] // 今までこう書いてた。

def m4 = [c:3,d:4]
assert [a:1,b:2,*:m4] == [a:1,b:2,c:3,d:4]
assert [a:1,b:2,*:m4,d:99] == [a:1,b:2,c:3,d:99]
