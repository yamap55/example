def text = """
<list>
    <technology>
        <name>Groovy</name>
    </technology>
    <technology>
        <name>Java</name>
    </technology>
    <database>
        <name>postgresql</name>
    </database>
</list>
"""

def list = new XmlSlurper().parseText(text) 

assert list instanceof groovy.util.slurpersupport.GPathResult 
assert list.technology[0].name == 'Groovy' 
assert list.'*'.name.size() == 3