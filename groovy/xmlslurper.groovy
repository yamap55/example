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
        <test>
            <name>aaaa</name>
        </test>
    </database>
</list>
"""

def list = new XmlSlurper().parseText(text) 

assert list instanceof groovy.util.slurpersupport.GPathResult 
assert list.technology[0].name == 'Groovy' 
assert list.'*'.name.size() == 3
assert list.'**'.findAll{it.name()=='name'}*.text() == ["Groovy","Java","postgresql","aaaa"]