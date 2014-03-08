# Jenkins and Hudson remote APIs and Update Center scripts

You'll find in this repository scripts 
*   to interact with Hudson or Jenkins remote API (to list failed builds for example)
*   to interact with Hudson or Jenkins Update Centers (to list plugins for example)

Those scripts are written in Groovy, Python and JavaScript

##  Running the scripts

### html/UpdateCenter.html
Just load that file in your browser and choose an update center to request; you'll get the list of available plugins

### html/BuildParser.html
Just load that file in your browser and give a valid jenkins to request; you'll get the list of failing jobs

### groovy/src/BuildParser.groovy
Simply run the script with your Jenkins URL, for example :

```bash
groovy BuildParser.groovy http://ci.jruby.org
```

This script will use the /api/xml Hudson/Jenkins endpoint and xpath to get the list of failing jobs.

### python/BuildParser.python
Simply run the script with your Jenkins URL, for example :

```bash
python BuildParser.py http://ci.jruby.org
```

This script will use the /api/json Jenkins endpoint and xpath to get the list of failing jobs.


## License : Apache 2
Copyright [2014] [Anthony Dahanne]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
