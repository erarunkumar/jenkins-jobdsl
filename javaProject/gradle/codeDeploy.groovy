def thr = Thread.currentThread()
def build = thr.executable
// get build parameters
def buildVariablesMap = build.buildVariables
String projectname = buildVariablesMap?.ProjectName


 job("${projectname}CodeDeploy") {
  description("Code deploy for ${projectname}")
  logRotator {
        daysToKeep(60)
        numToKeep(20)
        artifactDaysToKeep(1)
    }
  steps {
	steps {
        shell('sudo ansible-playbook -i /etc/ansible/roles/code/hosts /etc/ansible/roles/code/site.yml')
    }

    }
}
