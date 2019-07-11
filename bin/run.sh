dir=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $dir/.. && mvn package exec:java
