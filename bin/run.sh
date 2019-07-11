# set this variable to retrieve data about city's temperatures
export OPENWEATHER_KEY=

dir=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $dir/.. && mvn package exec:java
