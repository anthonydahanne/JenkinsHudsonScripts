/**
 * @author : Anthony Dahanne
 */
class BuildParser {
  static void main(String[] args) {
    if (args.length != 1) {
      println("Please run the script with a Jenkins or Hudson url as the only argument\n Example : groovy BuildParser.groovy http://ci.jruby.org");
      return;
    }
    def url = args[0];
    def xmlInputFilteringSuccess = new XmlParser().parse(url + "/api/xml?depth=1&tree=jobs[displayName,lastBuild[result]]&exclude=hudson/job[lastBuild[result=%27SUCCESS%27]]");
    def xmlInputNoFilter = new XmlParser().parse(url + "/api/xml?depth=1&tree=jobs");

    def jobs = xmlInputFilteringSuccess.job;
    println(jobs.size() + " jobs out of " + xmlInputNoFilter.job.size() + " are currently failing")
    jobs.each(
        {
          println(
              it.displayName.text() +
              " result is " + it.lastBuild.result.text())
        }
    )
  }

}
