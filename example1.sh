#!/usr/bin/bash

git status
git add .
git commit -m "new"
git push origin master
echo "Latest file is updated to git repo"