__author__ = "Anthony Dahanne"
import ast
import urllib
import sys

if len(sys.argv) != 2:
  print "Please run the script with a Jenkins or Hudson url as the only argument\n Example : python BuildParser.py http://ci.jruby.org"
  sys.exit(1)

url = str(sys.argv[1])
print url

xml_input_no_filter = ast.literal_eval(urllib.urlopen(url + "/api/python?depth=1&tree=jobs[displayName,lastBuild[result]]").read())

all_jobs = xml_input_no_filter['jobs']
non_successful_jobs = [row for row in all_jobs if 'SUCCESS' != row['lastBuild']['result']]

print(str(len(non_successful_jobs)) + " jobs out of " + str(len(all_jobs)) + " are currently failing")

for (i, item) in enumerate(non_successful_jobs):
  print "Job name : " + item['displayName'] + "Result : " + item['lastBuild']['result']
