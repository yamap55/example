import os

from datetime import datetime

defaultTextPath = "./data/shift_jis-crlf.txt"
#defaultTextPath = "./data/utf8-lf.txt"

# 基本形（OSのデフォルト？文字コードで読む）
with open(defaultTextPath) as f:
    print(f.read()) # 一括で読み込む

# 行毎に読み込む
with open(defaultTextPath) as f:
    for line in f:
        print(line)

# 行毎に読み込む
# メモリに全部乗る事、改行が含まれる事に注意
with open(defaultTextPath) as f:
    for line in f.readlines():
        print(line.rstrip()) # 最後の改行も含まれるので注意。「rstrip()」で除去
        # 違いはよくわからないが、f.read().splitlines() がオススメされてた
        # https://stackoverflow.com/questions/15233340/getting-rid-of-n-when-using-readlines

# 行毎に読み込む
# 使うことあるのか？
with open(defaultTextPath) as f:
    line2 = f.readline() # 1行づつ読み込む(改行文字も含まれる)
    while line2:
        print(line2.rstrip())
        line2 = f.readline()

# 文字コードを指定する場合にはencoding
# https://docs.python.jp/3.5/library/functions.html#open
# 検索するとcodecsモジュールを使うなどと出てくるが「codecs」は古い！
# python 2でもio.openでpython 3と同じ動きとのこと）
with open("./data/euc-crlf.txt", "r", encoding="euc_jp") as f:
    print(f.read())

# ----------------------
# 書き込み
# ----------------------

d = datetime.now().strftime("%Y%m%d%H%M%S")
outputDir = "./output/" + d + "/"
os.mkdir(outputDir)

# 基本形（OSのデフォルト？文字コードで書き込み）
with open(outputDir + "fisrt.txt", "w") as writeFile:
    writeFile.write("あいうえお\nかきくけこ\nさしすせそ\n") # Windowsの場合改行コードも何故か\r\nで出力

# 1行ごとに書き込み（OSのデフォルト？文字コードで書き込み）
with open(outputDir + "second.txt", "w") as writeFile:
    # Windowsの場合改行コードも何故か\r\nで出力
    writeFile.write("あいうえお\n")
    writeFile.write("かきくけこ\n")
    writeFile.write("さしすせそ\n")

# 文字コードを指定して書き込み
with open(outputDir + "third.txt", "w", encoding="UTF-8") as writeFile:
    writeFile.write("あいうえお\nかきくけこ\nさしすせそ\n") # Windowsの場合でも改行コードは\nで出力

# --------------------
# 文字コード変換して出力
# --------------------

# 文字コード変換
with open("./data/euc-crlf.txt", "r", encoding="euc_jp") as f:
    with open(outputDir + "euc-utf8.txt", "w", encoding="UTF-8") as writeFile:
        writeFile.write(f.read())

# 文字コードと改行コード変換
with open("./data/utf8-crlf.txt", "r", encoding="UTF-8") as f:
    with open(outputDir + "utf8-shift_jis-lf.txt", "w", encoding="shift_jis") as writeFile:
        writeFile.write(f.read().replace("\r\n","\n"))
