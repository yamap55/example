import os
import zipfile
import pyminizip

from datetime import datetime

d = datetime.now().strftime("%Y%m%d%H%M%S")
outputDir = "./output/" + d + "/"
os.mkdir(outputDir)

# --------------
# ZIP解凍
# --------------

# 基本形（とりあえず全部解凍）
with zipfile.ZipFile("./data/simple.zip", "r") as zf:
    zf.extractall(outputDir) # 引数を指定しないとカレントに出力

# パスワード付きzipを全部解凍
with zipfile.ZipFile("./data/password.zip", "r") as zf:
    zf.extractall(outputDir, pwd="password".encode("ascii")) # encodeしないとエラー

# ファイル指定して解凍する
with zipfile.ZipFile("./data/somefile.zip", "r") as zf:
    print(zf.namelist()) # namelistでファイル名確認

    # バイトで書き込むので「b」で開く
    with open(outputDir + "somefile.txt", "wb") as writeFile:
        writeFile.write(zf.read("somefile/file2.txt")) # readはバイトが返る

    # テキストで取得したい場合はopenで開いてデコード？
    # zipfile.open は文字コード指定できない
    with zf.open("somefile/file2.txt") as targetFile:
        for line in targetFile:
            print(line.decode("UTF-8").rstrip())

# --------------
# ZIP圧縮
# --------------

# 基本的な圧縮
with zipfile.ZipFile(outputDir + "compress1.zip", "w") as zf:
    # 第2引数がない場合は第1引数の通りに格納される。（この場合だと「/data/text1.txt」となる。）
    zf.write("./data/text1.txt", "text1.txt")
    zf.write("./data/text2.txt","nest/text2.txt")

# パスワード付きは標準ライブラリではできない
# pyminizipモジュールを使用する
# https://github.com/smihica/pyminizip
# ↓で入ればよいが入らない場合には下記参照
# pip install pyminizip
# Windows10の場合↓のエラーが出たので、下記の通り「Microsoft Visual C++ Build Tools」をインストール
#  Microsoft Visual C++ 14.0 is required. Get it with "Microsoft Visual C++ Build Tools": http://landinghub.visualstudio.com/visual-cpp-build-tools
#  その後zlibが必要だと言われたが解決できず。↓が参考になるかも
#  https://stackoverflow.com/questions/42529239/
# Ubuntuの場合
#  sudo apt-get install zlib1g-dev

pyminizip.compress("./data/text1.txt", outputDir + "compress2.zip", "password", 5)
