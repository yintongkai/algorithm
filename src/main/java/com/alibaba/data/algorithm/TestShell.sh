#!/usr/bin/env bash
today=`date -d "2 days ago" +%Y%M%d`
#ipconfig|grep "IPv4"
ipconfig|grep "IPv4"|while read line
do
str=`echo $line|awk -F ':' '{print $2}'`
echo $str>>b.txt 2>&1
done

for((i=0;i<100;i++))
do
    if [ $i -eq 50 ];then
        echo $i
    fi
done
for i in {1..10};
do
    let a=$i*5
    echo $a
done
