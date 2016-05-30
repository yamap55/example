import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
println "start ${new Date()}"


//フォルダ内のファイルを圧縮
def dir1 = /C:\work\test/
def zipfile1 = /C:\work\a.zip/
new AntBuilder().zip(destfile:zipfile1,basedir:dir1)

// 特定のファイルをまとめて圧縮
def zipfile2 = /C:\work\a.zip/
def f1 = /C:\work\20120613\a.txt/
def f2 = /C:\work\20120613\b.txt/

new AntBuilder().zip(destfile:zipfile2) {
  tarfileset(file : f1)
  tarfileset(file : f2)
}

// ZIP解凍
def zipfile2 = $/C:\work\20160419\hoge.zip/$
def output = $/C:\work\20160419\output/$

new AntBuilder().unzip(src:zipfile2,
  dest:output,
  overwrite:"false" )

// パスワード付きZIP作成。
def ip1 = $/C:\work\20160419\ziptest\a1.txt/$
def ip2 = $/C:\work\20160419\ziptest\a2.txt/$
def op = $/C:\work\20160419\ziptest\aa.zip/$

def if1 = new File(ip1)
def if2 = new File(ip2)
def of = new File(op)

ZipFile zipFile = new ZipFile(of);
//zipFile.setFileNameCharset(Charsets.UTF_8.name());

ZipParameters parameters = new ZipParameters();
parameters.setEncryptFiles(true);
parameters.setPassword("test");

// 圧縮方式　Deflate
parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
// 圧縮レベル 5
parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
// 暗号化方式 ZipCrypt
parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);

def files = [if1,if2]
zipFile.addFiles(files, parameters);

println "end ${new Date()}"
