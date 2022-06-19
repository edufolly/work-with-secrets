#! /bin/bash

set -e

code=0

# Check if 'curl' is installed.
if ! command -v curl &> /dev/null
then
    echo "'curl' could not be found."
    exit 10
fi

# Check if 'jq' is installed.
if ! command -v jq &> /dev/null
then
    echo "'jq' could not be found."
    exit 10
fi


###########
# git tag #
###########
git fetch --tags --depth=1 origin &> /dev/null

branch=$(git rev-parse --abbrev-ref HEAD)

suffix=""

case $branch in
  alpha) suffix="A" ;;
  beta) suffix="B" ;;
  dev) branch="main" ;;
esac

version=$(grep 'version' build.gradle | cut -f 2 -d "'")$suffix

echo ""
if git rev-parse "v$version^{tag}" >/dev/null 2>&1
then
  echo "[ERROR] Tag v$version already deployed."
  code=20
else
  echo "Tag v$version is ready to deploy."
fi
echo ""

exit $code
