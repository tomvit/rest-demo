dir=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $dir/.. && source ./APIKEY &>/dev/null && mvn package exec:java
