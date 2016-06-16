def text = """
<list>
    <technology>
        <name>Groovy</name>
    </technology>
</list>
"""

def list = new XmlSlurper().parseText(text) 

assert list instanceof groovy.util.slurpersupport.GPathResult 
assert list.technology.name == 'Groovy' 